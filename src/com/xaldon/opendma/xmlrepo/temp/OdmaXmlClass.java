package com.xaldon.opendma.xmlrepo.temp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.opendma.api.OdmaClass;
import org.opendma.api.OdmaCommonNames;
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
        if(!properties.containsKey(OdmaCommonNames.PROPERTY_NAME))
        {
            throw new IllegalArgumentException("Missing property: "+OdmaCommonNames.PROPERTY_NAME);
        }
        if(!properties.containsKey(OdmaCommonNames.PROPERTY_NAMESPACE))
        {
            if(properties.containsKey(new OdmaQName("opendma","NameQualifier")))
            {
                // handle xml files containing objects of OpenDMA < 0.7.0
                OdmaProperty old = properties.get(new OdmaQName("opendma","NameQualifier"));
                try
                {
                    properties.put(OdmaCommonNames.PROPERTY_NAMESPACE, new OdmaPropertyImpl(OdmaCommonNames.PROPERTY_NAMESPACE,old.getValue(),OdmaType.STRING,old.isMultiValue(),old.isReadOnly()));
                }
                catch (OdmaInvalidDataTypeException e)
                {
                    throw new OdmaXmlRepositoryException("failed converting opendma:NameQualifier to  opendma:Namespace", e);
                }
            }
            else
            {
                throw new IllegalArgumentException("Missing property: "+OdmaCommonNames.PROPERTY_NAMESPACE);
            }
        }
        // class hierarchy
        try
        {
            properties.put(OdmaCommonNames.PROPERTY_SUBCLASSES,new OdmaPropertyImpl(OdmaCommonNames.PROPERTY_SUBCLASSES,sch.getSubClasses(getQName()),OdmaType.REFERENCE,true,true));
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
        ArrayList<OdmaPropertyInfo> props = new ArrayList<OdmaPropertyInfo>();
        // add all properties of the parent
        if(getSuperClass() != null)
        {
            Iterable<OdmaPropertyInfo> parentProps = getSuperClass().getProperties();
            for(OdmaPropertyInfo pi : parentProps)
            {
                OdmaQName propName = pi.getQName();
                props.add(pi);
                uniquePropertyNameMap.put(propName,pi);
                propertyNameInfoMap.put(propName,getSuperClass());
            }
        }
        // add all properties of all aspects
        Iterable<OdmaClass> aspects = getAspects();
        if(aspects != null)
        {
            for(OdmaClass aspect : aspects)
            {
                Iterable<OdmaPropertyInfo> aspectProps = aspect.getProperties();
                for(OdmaPropertyInfo pi : aspectProps)
                {
                    OdmaQName propName = pi.getQName();
                    if(uniquePropertyNameMap.containsKey(propName))
                    {
                        OdmaPropertyInfo parentPi = uniquePropertyNameMap.get(propName);
                        if( (!parentPi.getDataType().equals(pi.getDataType())) || (!parentPi.isMultiValue().equals(pi.isMultiValue())) || ((pi.getDataType() == OdmaType.REFERENCE.getNumericId())&&(!parentPi.getReferenceClass().getQName().equals(pi.getReferenceClass().getQName()))) )
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
        Iterable<OdmaPropertyInfo> declaredProperties = getDeclaredProperties();
        if(declaredProperties != null)
        {
            for(OdmaPropertyInfo pi : declaredProperties)
            {
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
        properties.put(OdmaCommonNames.PROPERTY_PROPERTIES,new OdmaPropertyImpl(OdmaCommonNames.PROPERTY_DECLAREDPROPERTIES,props,OdmaType.REFERENCE,true,true));
    }

    public String toString()
    {
        return getQName().toString();
    }

    // ----- Object specific property access -------------------------------------------------------

    // CHECKTEMPLATE: the following code has most likely been copied from a class template. Make sure to keep this code up to date!
    // The following template code is available as OdmaClassTemplate

    /**
     * Returns the internal (technical) <i>name</i> of this <code>Class</code>.<br>
     * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_NAME).getString()</code>.
     * 
     * <p>Property <b>Name</b> (opendma): <b>String</b><br/>
     * [SingleValue] [Writable] [Required]<br/>
     * Full description follows.</p>
     * 
     * @return the internal (technical) <i>name</i> of this <code>Class</code>
     */
    public String getName() {
        try {
            return getProperty(OdmaCommonNames.PROPERTY_NAME).getString();
        }
        catch(OdmaInvalidDataTypeException oidte) {
            throw new OdmaRuntimeException("Invalid data type of system property",oidte);
        }
        catch(OdmaPropertyNotFoundException oonfe) {
            throw new OdmaRuntimeException("Predefined system property missing",oonfe);
        }
    }

    /**
     * Sets the internal (technical) <i>name</i> of this <code>Class</code>.<br>
     * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_NAME).setValue(value)</code>.
     * 
     * <p>Property <b>Name</b> (opendma): <b>String</b><br/>
     * [SingleValue] [Writable] [Required]<br/>
     * Full description follows.</p>
     * 
     * @param newValue
     *             The new value for the internal (technical) <i>name</i> of this <code>Class</code>
     * 
     * @throws OdmaAccessDeniedException
     *             If this OdmaProperty is read-only or cannot be set by the current user
     */
    public void setName(String newValue) throws OdmaAccessDeniedException {
        try {
            getProperty(OdmaCommonNames.PROPERTY_NAME).setValue(newValue);
        }
        catch(OdmaInvalidDataTypeException oidte) {
            throw new OdmaRuntimeException("Invalid data type of system property",oidte);
        }
        catch(OdmaPropertyNotFoundException oonfe) {
            throw new OdmaRuntimeException("Predefined system property missing",oonfe);
        }
    }

    /**
     * Returns the <i>namespace</i> of this <code>Class</code>.<br>
     * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_NAMESPACE).getString()</code>.
     * 
     * <p>Property <b>Namespace</b> (opendma): <b>String</b><br/>
     * [SingleValue] [Writable] [NotRequired]<br/>
     * Full description follows.</p>
     * 
     * @return the <i>namespace</i> of this <code>Class</code>
     */
    public String getNamespace() {
        try {
            return getProperty(OdmaCommonNames.PROPERTY_NAMESPACE).getString();
        }
        catch(OdmaInvalidDataTypeException oidte) {
            throw new OdmaRuntimeException("Invalid data type of system property",oidte);
        }
        catch(OdmaPropertyNotFoundException oonfe) {
            throw new OdmaRuntimeException("Predefined system property missing",oonfe);
        }
    }

    /**
     * Sets the <i>namespace</i> of this <code>Class</code>.<br>
     * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_NAMESPACE).setValue(value)</code>.
     * 
     * <p>Property <b>Namespace</b> (opendma): <b>String</b><br/>
     * [SingleValue] [Writable] [NotRequired]<br/>
     * Full description follows.</p>
     * 
     * @param newValue
     *             The new value for the <i>namespace</i> of this <code>Class</code>
     * 
     * @throws OdmaAccessDeniedException
     *             If this OdmaProperty is read-only or cannot be set by the current user
     */
    public void setNamespace(String newValue) throws OdmaAccessDeniedException {
        try {
            getProperty(OdmaCommonNames.PROPERTY_NAMESPACE).setValue(newValue);
        }
        catch(OdmaInvalidDataTypeException oidte) {
            throw new OdmaRuntimeException("Invalid data type of system property",oidte);
        }
        catch(OdmaPropertyNotFoundException oonfe) {
            throw new OdmaRuntimeException("Predefined system property missing",oonfe);
        }
    }

    /**
     * Returns the <i>display name</i> of this <code>Class</code> to be displayed to end users.<br>
     * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_DISPLAYNAME).getString()</code>.
     * 
     * <p>Property <b>DisplayName</b> (opendma): <b>String</b><br/>
     * [SingleValue] [Writable] [Required]<br/>
     * Full description follows.</p>
     * 
     * @return the <i>display name</i> of this <code>Class</code> to be displayed to end users
     */
    public String getDisplayName() {
        try {
            return getProperty(OdmaCommonNames.PROPERTY_DISPLAYNAME).getString();
        }
        catch(OdmaInvalidDataTypeException oidte) {
            throw new OdmaRuntimeException("Invalid data type of system property",oidte);
        }
        catch(OdmaPropertyNotFoundException oonfe) {
            throw new OdmaRuntimeException("Predefined system property missing",oonfe);
        }
    }

    /**
     * Sets the <i>display name</i> of this <code>Class</code> to be displayed to end users.<br>
     * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_DISPLAYNAME).setValue(value)</code>.
     * 
     * <p>Property <b>DisplayName</b> (opendma): <b>String</b><br/>
     * [SingleValue] [Writable] [Required]<br/>
     * Full description follows.</p>
     * 
     * @param newValue
     *             The new value for the <i>display name</i> of this <code>Class</code> to be displayed to end users
     * 
     * @throws OdmaAccessDeniedException
     *             If this OdmaProperty is read-only or cannot be set by the current user
     */
    public void setDisplayName(String newValue) throws OdmaAccessDeniedException {
        try {
            getProperty(OdmaCommonNames.PROPERTY_DISPLAYNAME).setValue(newValue);
        }
        catch(OdmaInvalidDataTypeException oidte) {
            throw new OdmaRuntimeException("Invalid data type of system property",oidte);
        }
        catch(OdmaPropertyNotFoundException oonfe) {
            throw new OdmaRuntimeException("Predefined system property missing",oonfe);
        }
    }

    /**
     * Returns the <i>super</i> <code>Class</code> that is extended by this <code>Class</code>.<br>
     * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_SUPERCLASS).getReference()</code>.
     * 
     * <p>Property <b>SuperClass</b> (opendma): <b>Reference to Class (opendma)</b><br/>
     * [SingleValue] [ReadOnly] [NotRequired]<br/>
     * Full description follows.</p>
     * 
     * @return the <i>super</i> <code>Class</code> that is extended by this <code>Class</code>
     */
    public OdmaClass getSuperClass() {
        try {
            return (OdmaClass)getProperty(OdmaCommonNames.PROPERTY_SUPERCLASS).getReference();
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
     * Returns the list of <i>aspects</i> that are implemented by this <code>Class</code>.<br>
     * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_ASPECTS).getReferenceIterable()</code>.
     * 
     * <p>Property <b>Aspects</b> (opendma): <b>Reference to Class (opendma)</b><br/>
     * [MultiValue] [Writable] [NotRequired]<br/>
     * Full description follows.</p>
     * 
     * @return the list of <i>aspects</i> that are implemented by this <code>Class</code>
     */
     @SuppressWarnings("unchecked")
    public Iterable<OdmaClass> getAspects() {
        try {
            return (Iterable<OdmaClass>)getProperty(OdmaCommonNames.PROPERTY_ASPECTS).getReferenceIterable();
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
     * Returns the list of <i>properties</i> that are desclared by this <code>Class</code> (does not contain inherited properties)..<br>
     * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_DECLAREDPROPERTIES).getReferenceIterable()</code>.
     * 
     * <p>Property <b>DeclaredProperties</b> (opendma): <b>Reference to PropertyInfo (opendma)</b><br/>
     * [MultiValue] [Writable] [NotRequired]<br/>
     * Full description follows.</p>
     * 
     * @return the list of <i>properties</i> that are desclared by this <code>Class</code> (does not contain inherited properties).
     */
     @SuppressWarnings("unchecked")
    public Iterable<OdmaPropertyInfo> getDeclaredProperties() {
        try {
            return (Iterable<OdmaPropertyInfo>)getProperty(OdmaCommonNames.PROPERTY_DECLAREDPROPERTIES).getReferenceIterable();
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
     * Returns the list of <i>properties</i> that are effective for objects of this <code>Class</code>. Contains inherited and declared properties..<br>
     * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_PROPERTIES).getReferenceIterable()</code>.
     * 
     * <p>Property <b>Properties</b> (opendma): <b>Reference to PropertyInfo (opendma)</b><br/>
     * [MultiValue] [ReadOnly] [NotRequired]<br/>
     * Full description follows.</p>
     * 
     * @return the list of <i>properties</i> that are effective for objects of this <code>Class</code>. Contains inherited and declared properties.
     */
     @SuppressWarnings("unchecked")
    public Iterable<OdmaPropertyInfo> getProperties() {
        try {
            return (Iterable<OdmaPropertyInfo>)getProperty(OdmaCommonNames.PROPERTY_PROPERTIES).getReferenceIterable();
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
     * Returns whether this <code>Class</code> describes an Aspect or a valid class object.<br>
     * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_ASPECT).getBoolean()</code>.
     * 
     * <p>Property <b>Aspect</b> (opendma): <b>Boolean</b><br/>
     * [SingleValue] [ReadOnly] [Required]<br/>
     * Full description follows.</p>
     * 
     * @return whether this <code>Class</code> describes an Aspect or a valid class object
     */
    public Boolean isAspect() {
        try {
            return getProperty(OdmaCommonNames.PROPERTY_ASPECT).getBoolean();
        }
        catch(OdmaInvalidDataTypeException oidte) {
            throw new OdmaRuntimeException("Invalid data type of system property",oidte);
        }
        catch(OdmaPropertyNotFoundException oonfe) {
            throw new OdmaRuntimeException("Predefined system property missing",oonfe);
        }
    }

    /**
     * Returns whether <code>Object</code>s of this <code>Class</code> can be created or not.<br>
     * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_INSTANTIABLE).getBoolean()</code>.
     * 
     * <p>Property <b>Instantiable</b> (opendma): <b>Boolean</b><br/>
     * [SingleValue] [Writable] [Required]<br/>
     * Full description follows.</p>
     * 
     * @return whether <code>Object</code>s of this <code>Class</code> can be created or not
     */
    public Boolean isInstantiable() {
        try {
            return getProperty(OdmaCommonNames.PROPERTY_INSTANTIABLE).getBoolean();
        }
        catch(OdmaInvalidDataTypeException oidte) {
            throw new OdmaRuntimeException("Invalid data type of system property",oidte);
        }
        catch(OdmaPropertyNotFoundException oonfe) {
            throw new OdmaRuntimeException("Predefined system property missing",oonfe);
        }
    }

    /**
     * Sets whether <code>Object</code>s of this <code>Class</code> can be created or not.<br>
     * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_INSTANTIABLE).setValue(value)</code>.
     * 
     * <p>Property <b>Instantiable</b> (opendma): <b>Boolean</b><br/>
     * [SingleValue] [Writable] [Required]<br/>
     * Full description follows.</p>
     * 
     * @param newValue
     *             The new value for whether <code>Object</code>s of this <code>Class</code> can be created or not
     * 
     * @throws OdmaAccessDeniedException
     *             If this OdmaProperty is read-only or cannot be set by the current user
     */
    public void setInstantiable(Boolean newValue) throws OdmaAccessDeniedException {
        try {
            getProperty(OdmaCommonNames.PROPERTY_INSTANTIABLE).setValue(newValue);
        }
        catch(OdmaInvalidDataTypeException oidte) {
            throw new OdmaRuntimeException("Invalid data type of system property",oidte);
        }
        catch(OdmaPropertyNotFoundException oonfe) {
            throw new OdmaRuntimeException("Predefined system property missing",oonfe);
        }
    }

    /**
     * Returns whether this <code>Class</code> should be displayed to end users or not.<br>
     * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_HIDDEN).getBoolean()</code>.
     * 
     * <p>Property <b>Hidden</b> (opendma): <b>Boolean</b><br/>
     * [SingleValue] [Writable] [Required]<br/>
     * Full description follows.</p>
     * 
     * @return whether this <code>Class</code> should be displayed to end users or not
     */
    public Boolean isHidden() {
        try {
            return getProperty(OdmaCommonNames.PROPERTY_HIDDEN).getBoolean();
        }
        catch(OdmaInvalidDataTypeException oidte) {
            throw new OdmaRuntimeException("Invalid data type of system property",oidte);
        }
        catch(OdmaPropertyNotFoundException oonfe) {
            throw new OdmaRuntimeException("Predefined system property missing",oonfe);
        }
    }

    /**
     * Sets whether this <code>Class</code> should be displayed to end users or not.<br>
     * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_HIDDEN).setValue(value)</code>.
     * 
     * <p>Property <b>Hidden</b> (opendma): <b>Boolean</b><br/>
     * [SingleValue] [Writable] [Required]<br/>
     * Full description follows.</p>
     * 
     * @param newValue
     *             The new value for whether this <code>Class</code> should be displayed to end users or not
     * 
     * @throws OdmaAccessDeniedException
     *             If this OdmaProperty is read-only or cannot be set by the current user
     */
    public void setHidden(Boolean newValue) throws OdmaAccessDeniedException {
        try {
            getProperty(OdmaCommonNames.PROPERTY_HIDDEN).setValue(newValue);
        }
        catch(OdmaInvalidDataTypeException oidte) {
            throw new OdmaRuntimeException("Invalid data type of system property",oidte);
        }
        catch(OdmaPropertyNotFoundException oonfe) {
            throw new OdmaRuntimeException("Predefined system property missing",oonfe);
        }
    }

    /**
     * Returns whether this <code>Class</code> is defined by the system (true) or by users (false).<br>
     * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_SYSTEM).getBoolean()</code>.
     * 
     * <p>Property <b>System</b> (opendma): <b>Boolean</b><br/>
     * [SingleValue] [Writable] [Required]<br/>
     * Full description follows.</p>
     * 
     * @return whether this <code>Class</code> is defined by the system (true) or by users (false)
     */
    public Boolean isSystem() {
        try {
            return getProperty(OdmaCommonNames.PROPERTY_SYSTEM).getBoolean();
        }
        catch(OdmaInvalidDataTypeException oidte) {
            throw new OdmaRuntimeException("Invalid data type of system property",oidte);
        }
        catch(OdmaPropertyNotFoundException oonfe) {
            throw new OdmaRuntimeException("Predefined system property missing",oonfe);
        }
    }

    /**
     * Sets whether this <code>Class</code> is defined by the system (true) or by users (false).<br>
     * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_SYSTEM).setValue(value)</code>.
     * 
     * <p>Property <b>System</b> (opendma): <b>Boolean</b><br/>
     * [SingleValue] [Writable] [Required]<br/>
     * Full description follows.</p>
     * 
     * @param newValue
     *             The new value for whether this <code>Class</code> is defined by the system (true) or by users (false)
     * 
     * @throws OdmaAccessDeniedException
     *             If this OdmaProperty is read-only or cannot be set by the current user
     */
    public void setSystem(Boolean newValue) throws OdmaAccessDeniedException {
        try {
            getProperty(OdmaCommonNames.PROPERTY_SYSTEM).setValue(newValue);
        }
        catch(OdmaInvalidDataTypeException oidte) {
            throw new OdmaRuntimeException("Invalid data type of system property",oidte);
        }
        catch(OdmaPropertyNotFoundException oonfe) {
            throw new OdmaRuntimeException("Predefined system property missing",oonfe);
        }
    }

    /**
     * Returns whether objects of this class can be retrieved from a session by their id or not.<br>
     * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_RETRIEVABLE).getBoolean()</code>.
     * 
     * <p>Property <b>Retrievable</b> (opendma): <b>Boolean</b><br/>
     * [SingleValue] [ReadOnly] [Required]<br/>
     * Full description follows.</p>
     * 
     * @return whether objects of this class can be retrieved from a session by their id or not
     */
    public Boolean isRetrievable() {
        try {
            return getProperty(OdmaCommonNames.PROPERTY_RETRIEVABLE).getBoolean();
        }
        catch(OdmaInvalidDataTypeException oidte) {
            throw new OdmaRuntimeException("Invalid data type of system property",oidte);
        }
        catch(OdmaPropertyNotFoundException oonfe) {
            throw new OdmaRuntimeException("Predefined system property missing",oonfe);
        }
    }

    /**
     * Returns whether objects of this class can be found by a search query or not.<br>
     * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_SEARCHABLE).getBoolean()</code>.
     * 
     * <p>Property <b>Searchable</b> (opendma): <b>Boolean</b><br/>
     * [SingleValue] [ReadOnly] [Required]<br/>
     * Full description follows.</p>
     * 
     * @return whether objects of this class can be found by a search query or not
     */
    public Boolean isSearchable() {
        try {
            return getProperty(OdmaCommonNames.PROPERTY_SEARCHABLE).getBoolean();
        }
        catch(OdmaInvalidDataTypeException oidte) {
            throw new OdmaRuntimeException("Invalid data type of system property",oidte);
        }
        catch(OdmaPropertyNotFoundException oonfe) {
            throw new OdmaRuntimeException("Predefined system property missing",oonfe);
        }
    }

    /**
     * Returns the list of <code>Class</code>es that extend this class (i.e. that contain a reference to this <code>Class</code> in their <code>SuperClass</code> property).<br>
     * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_SUBCLASSES).getReferenceIterable()</code>.
     * 
     * <p>Property <b>SubClasses</b> (opendma): <b>Reference to Class (opendma)</b><br/>
     * [MultiValue] [ReadOnly] [NotRequired]<br/>
     * Full description follows.</p>
     * 
     * @return the list of <code>Class</code>es that extend this class (i.e. that contain a reference to this <code>Class</code> in their <code>SuperClass</code> property)
     */
     @SuppressWarnings("unchecked")
    public Iterable<OdmaClass> getSubClasses() {
        try {
            return (Iterable<OdmaClass>)getProperty(OdmaCommonNames.PROPERTY_SUBCLASSES).getReferenceIterable();
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
     * the qualified name of this <code>Class</code><br>
     * <p>Full description follows.</p>
     * 
     * @return the qualified name of this <code>Class</code>
     */
    public OdmaQName getQName() {
        return new OdmaQName(getNamespace(),getName());
    }

}
