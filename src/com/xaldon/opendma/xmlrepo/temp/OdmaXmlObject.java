package com.xaldon.opendma.xmlrepo.temp;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

import org.opendma.api.OdmaClass;
import org.opendma.api.OdmaCommonNames;
import org.opendma.api.OdmaGuid;
import org.opendma.api.OdmaId;
import org.opendma.api.OdmaObject;
import org.opendma.api.OdmaProperty;
import org.opendma.api.OdmaPropertyInfo;
import org.opendma.api.OdmaQName;
import org.opendma.api.OdmaRepository;
import org.opendma.api.OdmaType;
import org.opendma.exceptions.OdmaAccessDeniedException;
import org.opendma.exceptions.OdmaInvalidDataTypeException;
import org.opendma.exceptions.OdmaPropertyNotFoundException;
import org.opendma.exceptions.OdmaRuntimeException;
import org.opendma.impl.OdmaPropertyImpl;

import com.xaldon.opendma.xmlrepo.exceptions.OdmaXmlRepositoryException;

/**
 * Template implementation of the interface <code>{@link OdmaObject}</code>.<p>
 * 
 * Full description follows.
 * 
 * @author Stefan Kopf, xaldon Technologies GmbH, the OpenDMA architecture board
 */
public class OdmaXmlObject implements OdmaObject
{

    protected Map<OdmaQName, OdmaProperty> properties = null;
    
    protected OdmaClass cls = null;
    
    protected OdmaXmlObject(Map<OdmaQName, OdmaProperty> props) throws OdmaXmlRepositoryException
    {
        properties = props;
        // validate presence of required OpenDMA properties
        if(!properties.containsKey(OdmaCommonNames.PROPERTY_CLASS))
        {
            throw new IllegalArgumentException("Missing property: "+OdmaCommonNames.PROPERTY_CLASS);
        }
        if(!properties.containsKey(OdmaCommonNames.PROPERTY_ID))
        {
            throw new IllegalArgumentException("Missing property: "+OdmaCommonNames.PROPERTY_ID);
        }
        if(!properties.containsKey(OdmaCommonNames.PROPERTY_GUID))
        {
            throw new IllegalArgumentException("Missing property: "+OdmaCommonNames.PROPERTY_GUID);
        }
        if(!properties.containsKey(OdmaCommonNames.PROPERTY_REPOSITORY))
        {
            throw new IllegalArgumentException("Missing property: "+OdmaCommonNames.PROPERTY_REPOSITORY);
        }
        // get the class of this object
        try
        {
            cls = (OdmaClass)props.get(OdmaCommonNames.PROPERTY_CLASS).getReference();
        }
        catch(Exception e)
        {
            throw new OdmaRuntimeException("Implementation error: invalid class property",e);
        }
        if(cls == null)
        {
            throw new OdmaRuntimeException("Implementation error: empty class property");
        }
        // create artificial properties
        createArtificialProperties();
    }
    
    protected void validateProperties(boolean allowUnevaluatedReferences, boolean enforceRequired) throws OdmaXmlRepositoryException
    {
        // try to get the ID of this object for better error reporting
        String objectId = "(unknown)";
        try
        {
            objectId = getId().toString();
        }
        catch(Exception e)
        {
            objectId = "(id-missing)";
        }
        // get the list of effective properties from class
        Iterable<OdmaPropertyInfo> propertyInfos = cls.getProperties();
        if(propertyInfos == null)
        {
            throw new OdmaRuntimeException("Implementation error: missing property infos at class");
        }
        // validate all properties
        for(OdmaPropertyInfo pi : propertyInfos)
        {
            OdmaQName pname = pi.getQName();
            OdmaProperty prop = (OdmaProperty)properties.get(pname);
            // if property is missing, generate a property with NULL value
            if(prop == null)
            {
                if(pi.isRequired() && enforceRequired)
                {
                    throw new OdmaXmlRepositoryException("Required property missing: "+pname+" at "+objectId);
                }
                try
                {
                    prop = new OdmaPropertyImpl(pname,null,OdmaType.fromNumericId(pi.getDataType()),pi.isMultiValue().booleanValue(),pi.isReadOnly().booleanValue());
                    properties.put(pname,prop);
                }
                catch(OdmaInvalidDataTypeException e)
                {
                    throw new OdmaRuntimeException("Implementation error",e);
                }
            }
            // validate property data type
            int definedDataType = pi.getDataType();
            if( allowUnevaluatedReferences && (definedDataType == OdmaType.REFERENCE.getNumericId()) )
            {
                if(! ( (prop instanceof UnevaluatedReferenceProperty) || (prop.getType() == OdmaType.REFERENCE) ) )
                {
                    throw new OdmaXmlRepositoryException("Property datatype mismatch for property "+pname+" at "+objectId);
                }
            }
            else
            {
                if(prop.getType().getNumericId() != definedDataType)
                {
                    throw new OdmaXmlRepositoryException("Property datatype mismatch for property "+pname+" at "+objectId);
                }
            }
            // validate property cardinality
            if(prop.isMultiValue() != pi.isMultiValue())
            {
                throw new OdmaXmlRepositoryException("Property cardinality mismatch for property "+pname+" at "+objectId);
            }
            // check writability
            if(pi.isReadOnly().booleanValue() && (!prop.isReadOnly()))
            {
                throw new OdmaXmlRepositoryException("Class defines read only property but property is writavble: "+pname+" at "+objectId);
            }
        }
    }
    
    protected void createArtificialProperties() throws OdmaXmlRepositoryException
    {
        // nothing to do here for OdmaObject
    }

    protected void resolveIds(HashMap<OdmaId, OdmaObject> objects) throws OdmaXmlRepositoryException
    {
        staticResolveIds(properties,objects);
    }

    protected static void staticResolveIds(Map<OdmaQName, OdmaProperty> properties, HashMap<OdmaId, OdmaObject> objects) throws OdmaXmlRepositoryException
    {
        for(Map.Entry<OdmaQName, OdmaProperty> propertiesEntry : properties.entrySet())
        {
            OdmaProperty prop = propertiesEntry.getValue();
            if(prop instanceof UnevaluatedReferenceProperty)
            {
                try
                {
                    if(prop.isMultiValue())
                    {
                        LinkedList<OdmaObject> resolvedList = new LinkedList<OdmaObject>();
                        for(OdmaId objRef : prop.getIdList())
                        {
                            OdmaObject referencedObject = objects.get(objRef);
                            if(referencedObject == null)
                            {
                                throw new OdmaXmlRepositoryException("Reference to non existing object ID "+objRef);
                            }
                            resolvedList.add(referencedObject);
                        }
                        propertiesEntry.setValue(new OdmaPropertyImpl(propertiesEntry.getKey(),resolvedList,OdmaType.REFERENCE,true,true));
                    }
                    else
                    {
                        OdmaObject resolvedObject =  null;
                        if(prop.getId() != null)
                        {
                            resolvedObject = objects.get(prop.getId());
                            if(resolvedObject == null)
                            {
                                throw new OdmaXmlRepositoryException("Reference to non existing object ID "+prop.getId());
                            }
                        }
                        propertiesEntry.setValue(new OdmaPropertyImpl(propertiesEntry.getKey(),resolvedObject,OdmaType.REFERENCE,false,true));
                    }
                }
                catch(OdmaInvalidDataTypeException e)
                {
                    throw new OdmaRuntimeException("Implementation error",e);
                }
            }
        }
    }
    
    public Map<OdmaQName, OdmaProperty> getInternalProperties()
    {
        return properties;
    }

    // ----- Generic property access ---------------------------------------------------------------

    /**
     * Returns an <code>{@link OdmaProperty}</code> for the property identified by the given qualified name.
     * The named property is automatically retrieved from the server if it is not yet in the local cache.
     * To optimize performance, consider calling <code>{@link #prepareProperties(OdmaQName[], boolean)}</code>
     * first when accessing multiple properties.
     * 
     * @param propertyName
     *            the qualified name of the property to return
     * 
     * @return an <code>{@link OdmaProperty}</code> for the property identified by the given qualified name.
     * 
     * @throws OdmaPropertyNotFoundException
     *             Thrown if the given qualified name does not identify a property in the effective properties of the class of this object.
     */
    public OdmaProperty getProperty(OdmaQName propertyName) throws OdmaPropertyNotFoundException {
        OdmaProperty p = properties.get(propertyName);
        if(p == null)
            throw new OdmaPropertyNotFoundException(propertyName);
        return p;
    }

    /**
     * Checks if the named properties are already in the local cache and performs one single round trip to the server to
     * retrieve all properties that are not yet in the cache. If the flag <code>refresh</code> is set to
     * <code>true</code>, the proerties are always retrieved from the server. Such a refresh will reset unsaved
     * changes of properties to the current value.<br>
     * If a given qualified name does not identify a property, it is silently ignored.
     * 
     * @param propertyNames
     *            array of qualified property names to retrieve from the server or <code>null</code> to retrieve all
     * 
     * @param refresh
     *            flag to indicate if the properties should also be retrieved if they are already in the local cache.
     */
    public void prepareProperties(OdmaQName[] propertyNames, boolean refresh) {
        // nothing to do here
    }

    /**
     * Set the property identified by the given qualified name to the new value.<br>
     * This method is a shortcut for <code>getProperty(propertyName).setValue(newValue)</code> that can avoid the
     * retrieval of the property in the <code>getProperty(propertyName)</code> method if the property is not yet in
     * the local cache.
     * 
     * @param propertyName
     *            the qualified name of the property to be changed
     * @param newValue
     *            the new value to set the named property to
     * 
     * @throws OdmaPropertyNotFoundException
     *             if and only if the given qualified name does not identify a property in the list of effective
     *             properties of the class of this object
     * @throws OdmaInvalidDataTypeException
     *             if and only if the Class of the given Object does not match the data type of the named property
     * @throws OdmaAccessDeniedException
     *             if this property can not be set by the current user
     */
    public void setProperty(OdmaQName propertyName, Object newValue) throws OdmaPropertyNotFoundException, OdmaInvalidDataTypeException, OdmaAccessDeniedException {
        throw new OdmaAccessDeniedException();
    }

    /**
     * Returns true if there are some pending changes to properties that have not yet been persisted to the server.
     * 
     * @return true if there are pending changes that have not yet been persisted
     */
    public boolean isDirty() {
        return false;
    }

    /**
     * Persist the current pending changes to properties at the server.
     */
    public void save() {
        // nothing to do here
    }

    /**
     * Returns <code>true</code> if and only if the class of this object or one of its ancestors equals
     * the given name or the class of this object or one of its ancestors incorporates the aspect with
     * the given name.
     * 
     * @param classOrAspectName
     *             the qualified name of the class or aspect to test for
     * 
     * @return if the class of this object is or extends the given class or incorportes the given aspect
     */
    public boolean instanceOf(OdmaQName classOrAspectName) {
        OdmaClass test = getOdmaClass();
        while(test != null) {
            if(test.getQName().equals(classOrAspectName)) {
                return true;
            }
            Iterable<OdmaClass> aspects = test.getAspects();
            if(aspects != null) {
                Iterator<OdmaClass> itAspects = aspects.iterator();
                while(itAspects.hasNext()) {
                    OdmaClass declaredAspect = itAspects.next();
                    if(declaredAspect.getQName().equals(classOrAspectName)) {
                        return true;
                    }
                }
            }
            test = test.getSuperClass();
        }
        return false;
    }

    // ----- Object specific property access -------------------------------------------------------

    // CHECKTEMPLATE: the following code has most likely been copied from a class template. Make sure to keep this code up to date!
    // The following template code is available as OdmaObjectTemplate

    /**
     * Returns the OpenDMA <code>Class</code> describing this <code>Object</code>.<br>
     * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_CLASS).getReference()</code>.
     * 
     * <p>Property <b>Class</b> (opendma): <b>Reference to Class (opendma)</b><br/>
     * [SingleValue] [ReadOnly] [Required]<br/>
     * Full description follows.</p>
     * 
     * @return the OpenDMA <code>Class</code> describing this <code>Object</code>
     */
    public OdmaClass getOdmaClass() {
        try {
            return (OdmaClass)getProperty(OdmaCommonNames.PROPERTY_CLASS).getReference();
        }
        catch(ClassCastException cce) {
            throw new OdmaRuntimeException("Invalid data type of system property",cce);
        }
        catch(OdmaInvalidDataTypeException oidte) {
            throw new OdmaRuntimeException("Invalid data type of system property",oidte);
        }
        catch(OdmaPropertyNotFoundException oonfe) {
            throw new OdmaRuntimeException("Predefined system property missing",oonfe);
        }
    }

    /**
     * Returns the <i>unique object identifier</i> identifying this <code>Object</code> inside its <code>Repository</code>.<br>
     * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_ID).getId()</code>.
     * 
     * <p>Property <b>Id</b> (opendma): <b>String</b><br/>
     * [SingleValue] [ReadOnly] [Required]<br/>
     * Full description follows.</p>
     * 
     * @return the <i>unique object identifier</i> identifying this <code>Object</code> inside its <code>Repository</code>
     */
    public OdmaId getId() {
        try {
            return getProperty(OdmaCommonNames.PROPERTY_ID).getId();
        }
        catch(OdmaInvalidDataTypeException oidte) {
            throw new OdmaRuntimeException("Invalid data type of system property",oidte);
        }
        catch(OdmaPropertyNotFoundException oonfe) {
            throw new OdmaRuntimeException("Predefined system property missing",oonfe);
        }
    }

    /**
     * Returns the <i>global unique object identifier</i> globally identifying this <code>Object</code>.<br>
     * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_GUID).getGuid()</code>.
     * 
     * <p>Property <b>Guid</b> (opendma): <b>String</b><br/>
     * [SingleValue] [ReadOnly] [Required]<br/>
     * Full description follows.</p>
     * 
     * @return the <i>global unique object identifier</i> globally identifying this <code>Object</code>
     */
    public OdmaGuid getGuid() {
        try {
            return getProperty(OdmaCommonNames.PROPERTY_GUID).getGuid();
        }
        catch(OdmaInvalidDataTypeException oidte) {
            throw new OdmaRuntimeException("Invalid data type of system property",oidte);
        }
        catch(OdmaPropertyNotFoundException oonfe) {
            throw new OdmaRuntimeException("Predefined system property missing",oonfe);
        }
    }

    /**
     * Returns the OpenDMA <code>Repository</code> where this <code>Object</code> resides.<br>
     * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_REPOSITORY).getReference()</code>.
     * 
     * <p>Property <b>Repository</b> (opendma): <b>Reference to Repository (opendma)</b><br/>
     * [SingleValue] [ReadOnly] [Required]<br/>
     * Full description follows.</p>
     * 
     * @return the OpenDMA <code>Repository</code> where this <code>Object</code> resides
     */
    public OdmaRepository getRepository() {
        try {
            return (OdmaRepository)getProperty(OdmaCommonNames.PROPERTY_REPOSITORY).getReference();
        }
        catch(ClassCastException cce) {
            throw new OdmaRuntimeException("Invalid data type of system property",cce);
        }
        catch(OdmaInvalidDataTypeException oidte) {
            throw new OdmaRuntimeException("Invalid data type of system property",oidte);
        }
        catch(OdmaPropertyNotFoundException oonfe) {
            throw new OdmaRuntimeException("Predefined system property missing",oonfe);
        }
    }

}
