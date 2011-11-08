package com.xaldon.opendma.xmlrepo.temp;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.opendma.OdmaTypes;
import org.opendma.api.OdmaClass;
import org.opendma.api.OdmaObject;
import org.opendma.api.OdmaProperty;
import org.opendma.api.OdmaPropertyInfo;
import org.opendma.api.OdmaQName;
import org.opendma.api.collections.OdmaClassEnumeration;
import org.opendma.api.collections.OdmaPropertyInfoEnumeration;
import org.opendma.exceptions.OdmaAccessDeniedException;
import org.opendma.exceptions.OdmaInvalidDataTypeException;
import org.opendma.exceptions.OdmaObjectNotFoundException;
import org.opendma.exceptions.OdmaRuntimeException;
import org.opendma.impl.OdmaPropertyImpl;
import org.opendma.impl.core.OdmaArrayListPropertyInfoEnumeration;
import org.opendma.impl.core.OdmaStaticClassHierarchy;

import com.xaldon.opendma.xmlrepo.exceptions.OdmaXmlRepositoryException;

/**
 * Template implementation of the interface <code>{@link OdmaClass}</code>.<p>
 * 
 * The <i>Class</i> specific version of the <code>{@link OdmaObject}</code> interface that offers short cuts to all defined OpenDMA properties.
 * 
 * @author Stefan Kopf, xaldon Technologies GmbH, the OpenDMA architecture board
 */
public class OdmaXmlClass extends OdmaXmlObject implements OdmaClass
{

    // protected OdmaArrayListClassEnumeration subClasses = new OdmaArrayListClassEnumeration();

    protected OdmaXmlClass(Map<OdmaQName, OdmaProperty> props, OdmaStaticClassHierarchy sch) throws OdmaXmlRepositoryException
    {
        super(props);
        // validate presence of required properties
        if(!properties.containsKey(OdmaTypes.PROPERTY_NAME))
        {
            throw new IllegalArgumentException("Missing property: "+OdmaTypes.PROPERTY_NAME);
        }
        if(!properties.containsKey(OdmaTypes.PROPERTY_NAMEQUALIFIER))
        {
            throw new IllegalArgumentException("Missing property: "+OdmaTypes.PROPERTY_NAMEQUALIFIER);
        }
        // class hierarchy
        try
        {
            properties.put(OdmaTypes.PROPERTY_SUBCLASSES,new OdmaPropertyImpl(OdmaTypes.PROPERTY_SUBCLASSES,sch.getSubClassesEnumeration(getQName()),OdmaTypes.TYPE_REFERENCE,true,true));
        }
        catch(OdmaInvalidDataTypeException e)
        {
            throw new OdmaRuntimeException("Implementation error",e);
        }
        
        
        
        
        
        
        //createArtificialProperties();
        /*
        // validate presence of required properties
        if(!properties.containsKey(OdmaTypes.PROPERTY_NAME))
        {
            throw new IllegalArgumentException("Missing property: "+OdmaTypes.PROPERTY_NAME);
        }
        if(!properties.containsKey(OdmaTypes.PROPERTY_NAMEQUALIFIER))
        {
            throw new IllegalArgumentException("Missing property: "+OdmaTypes.PROPERTY_NAMEQUALIFIER);
        }
        // create QName
        try
        {
            properties.put(OdmaTypes.PROPERTY_QNAME,new OdmaPropertyImpl(OdmaTypes.PROPERTY_QNAME,new OdmaQName(getNameQualifier(),getName()),OdmaTypes.TYPE_QNAME,false,true));
        }
        catch(OdmaInvalidDataTypeException e)
        {
            throw new OdmaRuntimeException("Implementation error",e);
        }
        // validate presence of required properties
        if(!properties.containsKey(OdmaTypes.PROPERTY_DISPLAYNAME))
        {
            throw new IllegalArgumentException("Missing property: "+OdmaTypes.PROPERTY_DISPLAYNAME);
        }
        if(!properties.containsKey(OdmaTypes.PROPERTY_PARENT))
        {
            throw new IllegalArgumentException("Missing property: "+OdmaTypes.PROPERTY_PARENT);
        }
        if(!properties.containsKey(OdmaTypes.PROPERTY_ASPECTS))
        {
            throw new IllegalArgumentException("Missing property: "+OdmaTypes.PROPERTY_ASPECTS);
        }
        if(!properties.containsKey(OdmaTypes.PROPERTY_DECLAREDPROPERTIES))
        {
            throw new IllegalArgumentException("Missing property: "+OdmaTypes.PROPERTY_DECLAREDPROPERTIES);
        }
        if(!properties.containsKey(OdmaTypes.PROPERTY_INSTANTIABLE))
        {
            throw new IllegalArgumentException("Missing property: "+OdmaTypes.PROPERTY_INSTANTIABLE);
        }
        if(!properties.containsKey(OdmaTypes.PROPERTY_HIDDEN))
        {
            throw new IllegalArgumentException("Missing property: "+OdmaTypes.PROPERTY_HIDDEN);
        }
        if(!properties.containsKey(OdmaTypes.PROPERTY_SYSTEM))
        {
            throw new IllegalArgumentException("Missing property: "+OdmaTypes.PROPERTY_SYSTEM);
        }
        // class hierarchy
        try
        {
            properties.put(OdmaTypes.PROPERTY_SUBCLASSES,new OdmaPropertyImpl(OdmaTypes.PROPERTY_SUBCLASSES,subClasses,OdmaTypes.TYPE_REFERENCE,true,true));
        }
        catch(OdmaInvalidDataTypeException e)
        {
            throw new OdmaRuntimeException("Implementation error",e);
        }
        */
    }
    
/*    public void registerParent(OdmaClass parent)
    {
        try
        {
            properties.put(OdmaTypes.PROPERTY_PARENT,new OdmaPropertyImpl(OdmaTypes.PROPERTY_PARENT,parent,OdmaTypes.TYPE_REFERENCE,false,true));
        }
        catch(OdmaInvalidDataTypeException e)
        {
            throw new OdmaRuntimeException("Implementation error",e);
        }
        if(parent != null)
        {
            if(parent instanceof OdmaStaticSystemClass)
            {
                ((OdmaStaticSystemClass)parent).registerSubClass(this);
            }
            else if(parent instanceof OdmaXmlClass)
            {
                ((OdmaXmlClass)parent).registerSubClass(this);
            }
        }
        // effective properties
        / *
        try
        {
            buildProperties();
        }
        catch(OdmaInvalidDataTypeException e)
        {
            throw new OdmaRuntimeException("Implementation error",e);
        }
        catch(OdmaAccessDeniedException e)
        {
            throw new OdmaRuntimeException("Implementation error",e);
        }
        * /
    }
*/
/*
    public void registerSubClass(OdmaClass cls)
    {
        subClasses.add(cls);
    }
*/
    protected void buildProperties() throws OdmaInvalidDataTypeException, OdmaXmlRepositoryException
    {
        HashMap<OdmaQName, OdmaPropertyInfo> uniquePropertyNameMap = new HashMap<OdmaQName, OdmaPropertyInfo>();
        HashMap<OdmaQName, OdmaClass> propertyNameInfoMap = new HashMap<OdmaQName, OdmaClass>();
        // create new enumeration for properties
        OdmaArrayListPropertyInfoEnumeration props = new OdmaArrayListPropertyInfoEnumeration();
        // add all properties of the parent
        if(getParent() != null)
        {
            OdmaPropertyInfoEnumeration parentProps = getParent().getProperties();
            Iterator<?> itParentProps = parentProps.iterator();
            while(itParentProps.hasNext())
            {
                OdmaPropertyInfo pi = (OdmaPropertyInfo)itParentProps.next();
                OdmaQName propName = pi.getQName();
                props.add(pi);
                uniquePropertyNameMap.put(propName,pi);
                propertyNameInfoMap.put(propName,getParent());
            }
        }
        // add all properties of all aspects
        OdmaClassEnumeration aspects = getAspects();
        if(aspects != null)
        {
            Iterator<?> itAspects = aspects.iterator();
            while(itAspects.hasNext())
            {
                OdmaClass aspect = (OdmaClass)itAspects.next();
                OdmaPropertyInfoEnumeration aspectProps = aspect.getProperties();
                Iterator<?> itAspectProps = aspectProps.iterator();
                while(itAspectProps.hasNext())
                {
                    OdmaPropertyInfo pi = (OdmaPropertyInfo)itAspectProps.next();
                    OdmaQName propName = pi.getQName();
                    if(uniquePropertyNameMap.containsKey(propName))
                    {
                        OdmaPropertyInfo parentPi = uniquePropertyNameMap.get(propName);
                        if( (!parentPi.getDataType().equals(pi.getDataType())) || (!parentPi.getMultiValue().equals(pi.getMultiValue())) || ((pi.getDataType().intValue() == OdmaTypes.TYPE_REFERENCE)&&(!parentPi.getReferenceClass().getQName().equals(pi.getReferenceClass().getQName()))) )
                        {
                            throw new OdmaXmlRepositoryException("The aspect "+aspect.getQName()+" in class "+getQName()+" contains the property "+propName+" that has already been inherited previously from "+propertyNameInfoMap.get(propName).getQName());
                        }
                    }
                    else
                    {
                        props.add(pi);
                        uniquePropertyNameMap.put(propName,pi);
                        propertyNameInfoMap.put(propName,aspect);
                    }
                }
            }
        }
        // add all declared properties
        OdmaPropertyInfoEnumeration declaredProperties = getDeclaredProperties();
        if(declaredProperties != null)
        {
            Iterator itDeclaredProperties = declaredProperties.iterator();
            while(itDeclaredProperties.hasNext())
            {
                OdmaPropertyInfo pi = (OdmaPropertyInfo)itDeclaredProperties.next();
                OdmaQName propName = pi.getQName();
                if(uniquePropertyNameMap.containsKey(propName))
                {
                    throw new OdmaXmlRepositoryException("The class "+getQName()+" declares the property "+propName+" that has already been inherited.");
                }
                else
                {
                    props.add(pi);
                    uniquePropertyNameMap.put(propName,pi);
                    propertyNameInfoMap.put(propName,this);
                }
            }
        }
        properties.put(OdmaTypes.PROPERTY_PROPERTIES,new OdmaPropertyImpl(OdmaTypes.PROPERTY_DECLAREDPROPERTIES,props,OdmaTypes.TYPE_REFERENCE,true,true));
    }

    public String toString()
    {
        return getQName().toString();
    }

    // =============================================================================================
    // Object specific property access
    // =============================================================================================

    // CHECKTEMPLATE: the following code has most likely been copied from a class template. Make sure to keep this code up to date!
    // The following template code is available as OdmaClassTemplate

    /**
     * Returns the internal (technical) <i>name</i> of this <code>Class</code>.<br>
     * 
     * <p>Property <b>Name</b> (opendma): <b>String</b><br>
     * [SingleValue] [Writable] [Required]<br>
     * Full description follows.</p>
     * 
     * @return the internal (technical) <i>name</i> of this <code>Class</code>
     */
    public String getName()
    {
        try
        {
            return getProperty(OdmaTypes.PROPERTY_NAME).getString();
        }
        catch(OdmaInvalidDataTypeException oidte)
        {
            throw new OdmaRuntimeException("Invalid data type of system property",oidte);
        }
        catch(OdmaObjectNotFoundException oonfe)
        {
            throw new OdmaRuntimeException("Predefined system property missing",oonfe);
        }
    }

    /**
     * Sets the internal (technical) <i>name</i> of this <code>Class</code>.<br>
     * 
     * <p>Property <b>Name</b> (opendma): <b>String</b><br>
     * [SingleValue] [Writable] [Required]<br>
     * Full description follows.</p>
     * 
     * @throws OdmaAccessDeniedException
     *             if this property can not be set by the current user
     */
    public void setName(String value) throws OdmaAccessDeniedException
    {
        try
        {
            getProperty(OdmaTypes.PROPERTY_NAME).setValue(value);
        }
        catch(OdmaInvalidDataTypeException oidte)
        {
            throw new OdmaRuntimeException("Invalid data type of system property",oidte);
        }
        catch(OdmaObjectNotFoundException oonfe)
        {
            throw new OdmaRuntimeException("Predefined system property missing",oonfe);
        }
    }

    /**
     * Returns the name <i>qualifier</i> of this <code>Class</code>.<br>
     * 
     * <p>Property <b>NameQualifier</b> (opendma): <b>String</b><br>
     * [SingleValue] [Writable] [Nullable]<br>
     * Full description follows.</p>
     * 
     * @return the name <i>qualifier</i> of this <code>Class</code>
     */
    public String getNameQualifier()
    {
        try
        {
            return getProperty(OdmaTypes.PROPERTY_NAMEQUALIFIER).getString();
        }
        catch(OdmaInvalidDataTypeException oidte)
        {
            throw new OdmaRuntimeException("Invalid data type of system property",oidte);
        }
        catch(OdmaObjectNotFoundException oonfe)
        {
            throw new OdmaRuntimeException("Predefined system property missing",oonfe);
        }
    }

    /**
     * Sets the name <i>qualifier</i> of this <code>Class</code>.<br>
     * 
     * <p>Property <b>NameQualifier</b> (opendma): <b>String</b><br>
     * [SingleValue] [Writable] [Nullable]<br>
     * Full description follows.</p>
     * 
     * @throws OdmaAccessDeniedException
     *             if this property can not be set by the current user
     */
    public void setNameQualifier(String value) throws OdmaAccessDeniedException
    {
        try
        {
            getProperty(OdmaTypes.PROPERTY_NAMEQUALIFIER).setValue(value);
        }
        catch(OdmaInvalidDataTypeException oidte)
        {
            throw new OdmaRuntimeException("Invalid data type of system property",oidte);
        }
        catch(OdmaObjectNotFoundException oonfe)
        {
            throw new OdmaRuntimeException("Predefined system property missing",oonfe);
        }
    }

    /**
     * Returns the <i>display name</i> of this <code>Class</code> to be displayed to end users.<br>
     * 
     * <p>Property <b>DisplayName</b> (opendma): <b>String</b><br>
     * [SingleValue] [Writable] [Required]<br>
     * Full description follows.</p>
     * 
     * @return the <i>display name</i> of this <code>Class</code> to be displayed to end users
     */
    public String getDisplayName()
    {
        try
        {
            return getProperty(OdmaTypes.PROPERTY_DISPLAYNAME).getString();
        }
        catch(OdmaInvalidDataTypeException oidte)
        {
            throw new OdmaRuntimeException("Invalid data type of system property",oidte);
        }
        catch(OdmaObjectNotFoundException oonfe)
        {
            throw new OdmaRuntimeException("Predefined system property missing",oonfe);
        }
    }

    /**
     * Sets the <i>display name</i> of this <code>Class</code> to be displayed to end users.<br>
     * 
     * <p>Property <b>DisplayName</b> (opendma): <b>String</b><br>
     * [SingleValue] [Writable] [Required]<br>
     * Full description follows.</p>
     * 
     * @throws OdmaAccessDeniedException
     *             if this property can not be set by the current user
     */
    public void setDisplayName(String value) throws OdmaAccessDeniedException
    {
        try
        {
            getProperty(OdmaTypes.PROPERTY_DISPLAYNAME).setValue(value);
        }
        catch(OdmaInvalidDataTypeException oidte)
        {
            throw new OdmaRuntimeException("Invalid data type of system property",oidte);
        }
        catch(OdmaObjectNotFoundException oonfe)
        {
            throw new OdmaRuntimeException("Predefined system property missing",oonfe);
        }
    }

    /**
     * Returns the <i>parent</i> <code>Class</code> that is extended by this <code>Class</code>.<br>
     * 
     * <p>Property <b>Parent</b> (opendma): <b>Reference to Class (opendma)</b><br>
     * [SingleValue] [ReadOnly] [Nullable]<br>
     * Full description follows.</p>
     * 
     * @return the <i>parent</i> <code>Class</code> that is extended by this <code>Class</code>
     */
    public OdmaClass getParent()
    {
        try
        {
            return (OdmaClass)getProperty(OdmaTypes.PROPERTY_PARENT).getReference();
        }
        catch(ClassCastException cce)
        {
            throw new OdmaRuntimeException("Invalid data type of system property",cce);
        }
        catch(OdmaInvalidDataTypeException oidte)
        {
            throw new OdmaRuntimeException("Invalid data type of system property",oidte);
        }
        catch(OdmaObjectNotFoundException oonfe)
        {
            throw new OdmaRuntimeException("Predefined system property missing",oonfe);
        }
    }

    /**
     * Returns the list of <i>aspects</i> that are implemented by this <code>Class</code>.<br>
     * 
     * <p>Property <b>Aspects</b> (opendma): <b>Reference to Class (opendma)</b><br>
     * [MultiValue] [Writable] [Nullable]<br>
     * Full description follows.</p>
     * 
     * @return the list of <i>aspects</i> that are implemented by this <code>Class</code>
     */
    public OdmaClassEnumeration getAspects()
    {
        try
        {
            return (OdmaClassEnumeration)getProperty(OdmaTypes.PROPERTY_ASPECTS).getReferenceEnumeration();
        }
        catch(ClassCastException cce)
        {
            throw new OdmaRuntimeException("Invalid data type of system property",cce);
        }
        catch(OdmaInvalidDataTypeException oidte)
        {
            throw new OdmaRuntimeException("Invalid data type of system property",oidte);
        }
        catch(OdmaObjectNotFoundException oonfe)
        {
            throw new OdmaRuntimeException("Predefined system property missing",oonfe);
        }
    }

    /**
     * Returns the list of <i>properties</i> that are desclared by this <code>Class</code> (does not contain inherited properties)..<br>
     * 
     * <p>Property <b>DeclaredProperties</b> (opendma): <b>Reference to PropertyInfo (opendma)</b><br>
     * [MultiValue] [Writable] [Nullable]<br>
     * Full description follows.</p>
     * 
     * @return the list of <i>properties</i> that are desclared by this <code>Class</code> (does not contain inherited properties).
     */
    public OdmaPropertyInfoEnumeration getDeclaredProperties()
    {
        try
        {
            return (OdmaPropertyInfoEnumeration)getProperty(OdmaTypes.PROPERTY_DECLAREDPROPERTIES).getReferenceEnumeration();
        }
        catch(ClassCastException cce)
        {
            throw new OdmaRuntimeException("Invalid data type of system property",cce);
        }
        catch(OdmaInvalidDataTypeException oidte)
        {
            throw new OdmaRuntimeException("Invalid data type of system property",oidte);
        }
        catch(OdmaObjectNotFoundException oonfe)
        {
            throw new OdmaRuntimeException("Predefined system property missing",oonfe);
        }
    }

    /**
     * Returns the list of <i>properties</i> that are effective for objects of this <code>Class</code>. Contains inherited and declared properties..<br>
     * 
     * <p>Property <b>Properties</b> (opendma): <b>Reference to PropertyInfo (opendma)</b><br>
     * [MultiValue] [ReadOnly] [Nullable]<br>
     * Full description follows.</p>
     * 
     * @return the list of <i>properties</i> that are effective for objects of this <code>Class</code>. Contains inherited and declared properties.
     */
    public OdmaPropertyInfoEnumeration getProperties()
    {
        try
        {
            return (OdmaPropertyInfoEnumeration)getProperty(OdmaTypes.PROPERTY_PROPERTIES).getReferenceEnumeration();
        }
        catch(ClassCastException cce)
        {
            throw new OdmaRuntimeException("Invalid data type of system property",cce);
        }
        catch(OdmaInvalidDataTypeException oidte)
        {
            throw new OdmaRuntimeException("Invalid data type of system property",oidte);
        }
        catch(OdmaObjectNotFoundException oonfe)
        {
            throw new OdmaRuntimeException("Predefined system property missing",oonfe);
        }
    }

    /**
     * Returns wheather this <code>Class</code> describes an Aspect or a valid class object.<br>
     * 
     * <p>Property <b>Aspect</b> (opendma): <b>Boolean</b><br>
     * [SingleValue] [ReadOnly] [Required]<br>
     * Full description follows.</p>
     * 
     * @return wheather this <code>Class</code> describes an Aspect or a valid class object
     */
    public Boolean getAspect()
    {
        try
        {
            return getProperty(OdmaTypes.PROPERTY_ASPECT).getBoolean();
        }
        catch(OdmaInvalidDataTypeException oidte)
        {
            throw new OdmaRuntimeException("Invalid data type of system property",oidte);
        }
        catch(OdmaObjectNotFoundException oonfe)
        {
            throw new OdmaRuntimeException("Predefined system property missing",oonfe);
        }
    }

    /**
     * Returns wheather <code>Object</code>s of this <code>Class</code> can be created or not.<br>
     * 
     * <p>Property <b>Instantiable</b> (opendma): <b>Boolean</b><br>
     * [SingleValue] [Writable] [Required]<br>
     * Full description follows.</p>
     * 
     * @return wheather <code>Object</code>s of this <code>Class</code> can be created or not
     */
    public Boolean getInstantiable()
    {
        try
        {
            return getProperty(OdmaTypes.PROPERTY_INSTANTIABLE).getBoolean();
        }
        catch(OdmaInvalidDataTypeException oidte)
        {
            throw new OdmaRuntimeException("Invalid data type of system property",oidte);
        }
        catch(OdmaObjectNotFoundException oonfe)
        {
            throw new OdmaRuntimeException("Predefined system property missing",oonfe);
        }
    }

    /**
     * Sets wheather <code>Object</code>s of this <code>Class</code> can be created or not.<br>
     * 
     * <p>Property <b>Instantiable</b> (opendma): <b>Boolean</b><br>
     * [SingleValue] [Writable] [Required]<br>
     * Full description follows.</p>
     * 
     * @throws OdmaAccessDeniedException
     *             if this property can not be set by the current user
     */
    public void setInstantiable(Boolean value) throws OdmaAccessDeniedException
    {
        try
        {
            getProperty(OdmaTypes.PROPERTY_INSTANTIABLE).setValue(value);
        }
        catch(OdmaInvalidDataTypeException oidte)
        {
            throw new OdmaRuntimeException("Invalid data type of system property",oidte);
        }
        catch(OdmaObjectNotFoundException oonfe)
        {
            throw new OdmaRuntimeException("Predefined system property missing",oonfe);
        }
    }

    /**
     * Returns wheather this <code>Class</code> should be displayed to end users or not.<br>
     * 
     * <p>Property <b>Hidden</b> (opendma): <b>Boolean</b><br>
     * [SingleValue] [Writable] [Required]<br>
     * Full description follows.</p>
     * 
     * @return wheather this <code>Class</code> should be displayed to end users or not
     */
    public Boolean getHidden()
    {
        try
        {
            return getProperty(OdmaTypes.PROPERTY_HIDDEN).getBoolean();
        }
        catch(OdmaInvalidDataTypeException oidte)
        {
            throw new OdmaRuntimeException("Invalid data type of system property",oidte);
        }
        catch(OdmaObjectNotFoundException oonfe)
        {
            throw new OdmaRuntimeException("Predefined system property missing",oonfe);
        }
    }

    /**
     * Sets wheather this <code>Class</code> should be displayed to end users or not.<br>
     * 
     * <p>Property <b>Hidden</b> (opendma): <b>Boolean</b><br>
     * [SingleValue] [Writable] [Required]<br>
     * Full description follows.</p>
     * 
     * @throws OdmaAccessDeniedException
     *             if this property can not be set by the current user
     */
    public void setHidden(Boolean value) throws OdmaAccessDeniedException
    {
        try
        {
            getProperty(OdmaTypes.PROPERTY_HIDDEN).setValue(value);
        }
        catch(OdmaInvalidDataTypeException oidte)
        {
            throw new OdmaRuntimeException("Invalid data type of system property",oidte);
        }
        catch(OdmaObjectNotFoundException oonfe)
        {
            throw new OdmaRuntimeException("Predefined system property missing",oonfe);
        }
    }

    /**
     * Returns wheather this <code>Class</code> is defined by the system (true) or by users (false).<br>
     * 
     * <p>Property <b>System</b> (opendma): <b>Boolean</b><br>
     * [SingleValue] [Writable] [Required]<br>
     * Full description follows.</p>
     * 
     * @return wheather this <code>Class</code> is defined by the system (true) or by users (false)
     */
    public Boolean getSystem()
    {
        try
        {
            return getProperty(OdmaTypes.PROPERTY_SYSTEM).getBoolean();
        }
        catch(OdmaInvalidDataTypeException oidte)
        {
            throw new OdmaRuntimeException("Invalid data type of system property",oidte);
        }
        catch(OdmaObjectNotFoundException oonfe)
        {
            throw new OdmaRuntimeException("Predefined system property missing",oonfe);
        }
    }

    /**
     * Sets wheather this <code>Class</code> is defined by the system (true) or by users (false).<br>
     * 
     * <p>Property <b>System</b> (opendma): <b>Boolean</b><br>
     * [SingleValue] [Writable] [Required]<br>
     * Full description follows.</p>
     * 
     * @throws OdmaAccessDeniedException
     *             if this property can not be set by the current user
     */
    public void setSystem(Boolean value) throws OdmaAccessDeniedException
    {
        try
        {
            getProperty(OdmaTypes.PROPERTY_SYSTEM).setValue(value);
        }
        catch(OdmaInvalidDataTypeException oidte)
        {
            throw new OdmaRuntimeException("Invalid data type of system property",oidte);
        }
        catch(OdmaObjectNotFoundException oonfe)
        {
            throw new OdmaRuntimeException("Predefined system property missing",oonfe);
        }
    }

    /**
     * Returns wheather objects of this class can be retrieved from a session by their id or not.<br>
     * 
     * <p>Property <b>Retrievable</b> (opendma): <b>Boolean</b><br>
     * [SingleValue] [ReadOnly] [Required]<br>
     * Full description follows.</p>
     * 
     * @return wheather objects of this class can be retrieved from a session by their id or not
     */
    public Boolean getRetrievable()
    {
        try
        {
            return getProperty(OdmaTypes.PROPERTY_RETRIEVABLE).getBoolean();
        }
        catch(OdmaInvalidDataTypeException oidte)
        {
            throw new OdmaRuntimeException("Invalid data type of system property",oidte);
        }
        catch(OdmaObjectNotFoundException oonfe)
        {
            throw new OdmaRuntimeException("Predefined system property missing",oonfe);
        }
    }

    /**
     * Returns wheather objects of this class can be found by a search query or not.<br>
     * 
     * <p>Property <b>Searchable</b> (opendma): <b>Boolean</b><br>
     * [SingleValue] [ReadOnly] [Required]<br>
     * Full description follows.</p>
     * 
     * @return wheather objects of this class can be found by a search query or not
     */
    public Boolean getSearchable()
    {
        try
        {
            return getProperty(OdmaTypes.PROPERTY_SEARCHABLE).getBoolean();
        }
        catch(OdmaInvalidDataTypeException oidte)
        {
            throw new OdmaRuntimeException("Invalid data type of system property",oidte);
        }
        catch(OdmaObjectNotFoundException oonfe)
        {
            throw new OdmaRuntimeException("Predefined system property missing",oonfe);
        }
    }

    /**
     * Returns the list of <code>Class</code>es that extend this class (i.e. that contain a reference to this <code>Class</code> in their <i>parent</i> property).<br>
     * 
     * <p>Property <b>SubClasses</b> (opendma): <b>Reference to Class (opendma)</b><br>
     * [MultiValue] [ReadOnly] [Nullable]<br>
     * Full description follows.</p>
     * 
     * @return the list of <code>Class</code>es that extend this class (i.e. that contain a reference to this <code>Class</code> in their <i>parent</i> property)
     */
    public OdmaClassEnumeration getSubClasses()
    {
        try
        {
            return (OdmaClassEnumeration)getProperty(OdmaTypes.PROPERTY_SUBCLASSES).getReferenceEnumeration();
        }
        catch(ClassCastException cce)
        {
            throw new OdmaRuntimeException("Invalid data type of system property",cce);
        }
        catch(OdmaInvalidDataTypeException oidte)
        {
            throw new OdmaRuntimeException("Invalid data type of system property",oidte);
        }
        catch(OdmaObjectNotFoundException oonfe)
        {
            throw new OdmaRuntimeException("Predefined system property missing",oonfe);
        }
    }

    /**
     * the qualified name of this <code>Class</code><br>
     * <p>Full description follows.</p>
     * 
     * @return the qualified name of this <code>Class</code>
     */
    public OdmaQName getQName()
    {
        return new OdmaQName(getNameQualifier(),getName());
    }

}
