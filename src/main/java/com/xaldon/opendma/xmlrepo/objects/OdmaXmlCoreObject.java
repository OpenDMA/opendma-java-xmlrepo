package com.xaldon.opendma.xmlrepo.objects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

import org.opendma.api.OdmaClass;
import org.opendma.api.OdmaCommonNames;
import org.opendma.api.OdmaCoreObject;
import org.opendma.api.OdmaId;
import org.opendma.api.OdmaObject;
import org.opendma.api.OdmaProperty;
import org.opendma.api.OdmaPropertyInfo;
import org.opendma.api.OdmaQName;
import org.opendma.api.OdmaType;
import org.opendma.exceptions.OdmaAccessDeniedException;
import org.opendma.exceptions.OdmaInvalidDataTypeException;
import org.opendma.exceptions.OdmaPropertyNotFoundException;
import org.opendma.exceptions.OdmaRuntimeException;
import org.opendma.impl.OdmaPropertyImpl;

import com.xaldon.opendma.xmlrepo.exceptions.OdmaXmlRepositoryException;

public class OdmaXmlCoreObject implements OdmaCoreObject
{

    protected final Map<OdmaQName, OdmaProperty> properties;
    
    protected final OdmaClass odmaClass;
    
    protected Iterable<OdmaClass> odmaAspects;
    
    protected OdmaXmlCoreObject(Map<OdmaQName, OdmaProperty> props) throws OdmaXmlRepositoryException
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
            odmaClass = (OdmaClass)props.get(OdmaCommonNames.PROPERTY_CLASS).getReference();
        }
        catch(Exception e)
        {
            throw new OdmaRuntimeException("Implementation error: invalid class property",e);
        }
        if(odmaClass == null)
        {
            throw new OdmaRuntimeException("Implementation error: empty class property");
        }
    }
    
    protected void validateProperties(boolean allowUnevaluatedReferences, boolean enforceRequired) throws OdmaXmlRepositoryException
    {
        // try to get the ID of this object for better error reporting
        String objectId = "(unknown)";
        try
        {
            OdmaId id = getProperty(OdmaCommonNames.PROPERTY_ID).getId();
            objectId = id.toString();
        }
        catch(Exception e)
        {
            objectId = "(id-missing)";
        }
        // get the list of effective properties from class
        Iterable<OdmaPropertyInfo> propertyInfos = odmaClass.getProperties();
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
                    prop = OdmaPropertyImpl.fromValue(pname,pi.isMultiValue().booleanValue()?new ArrayList<Object>(0):null,OdmaType.fromNumericId(pi.getDataType()),pi.isMultiValue().booleanValue(),pi.isReadOnly().booleanValue());
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
                        propertiesEntry.setValue(OdmaPropertyImpl.fromValue(propertiesEntry.getKey(),resolvedList,OdmaType.REFERENCE,true,true));
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
                        propertiesEntry.setValue(OdmaPropertyImpl.fromValue(propertiesEntry.getKey(),resolvedObject,OdmaType.REFERENCE,false,true));
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

    // ----- OdmaCoreObject -----------------------------------------------------------------------

    public OdmaProperty getProperty(OdmaQName propertyName) throws OdmaPropertyNotFoundException {
        OdmaProperty p = properties.get(propertyName);
        if(p == null)
            throw new OdmaPropertyNotFoundException(propertyName);
        return p;
    }

    public void prepareProperties(OdmaQName[] propertyNames, boolean refresh) {
        // nothing to do here
    }

    public void setProperty(OdmaQName propertyName, Object newValue) throws OdmaPropertyNotFoundException, OdmaInvalidDataTypeException, OdmaAccessDeniedException {
        throw new OdmaAccessDeniedException();
    }

    public boolean isDirty() {
        return false;
    }

    public void save() {
        // nothing to do here
    }

    @SuppressWarnings("unchecked")
    public boolean instanceOf(OdmaQName classOrAspectName) {
        OdmaClass test = odmaClass;
        while(test != null) {
            if(test.getQName().equals(classOrAspectName)) {
                return true;
            }
            Iterable<OdmaClass> aspects = test.getIncludedAspects();
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
        if(odmaAspects == null) {
            try
            {
                odmaAspects = (Iterable<OdmaClass>)properties.get(OdmaCommonNames.PROPERTY_ASPECTS).getReferenceIterable();
            }
            catch(Exception e)
            {
                throw new OdmaRuntimeException("Implementation error: invalid class property",e);
            }
        }
        for(OdmaClass testAspect : odmaAspects) {
            while(testAspect != null) {
                if(testAspect.getQName().equals(classOrAspectName)) {
                    return true;
                }
                testAspect = testAspect.getSuperClass();
            }
        }
        return false;
    }

    @Override
    public Iterator<OdmaProperty> availableProperties() {
        return properties.values().iterator();
    }

    @Override
    public boolean availablePropertiesComplete() {
        return true;
    }

    @Override
    public boolean isEmbeddingRecommended() {
        return false;
    }

}
