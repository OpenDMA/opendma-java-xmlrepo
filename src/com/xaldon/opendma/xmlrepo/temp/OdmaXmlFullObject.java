package com.xaldon.opendma.xmlrepo.temp;

import java.util.Date;
import java.util.Map;

import org.opendma.OdmaTypes;
import org.opendma.api.OdmaAssociation;
import org.opendma.api.OdmaChoiceValue;
import org.opendma.api.OdmaClass;
import org.opendma.api.OdmaContainable;
import org.opendma.api.OdmaContainer;
import org.opendma.api.OdmaContent;
import org.opendma.api.OdmaContentElement;
import org.opendma.api.OdmaDataContentElement;
import org.opendma.api.OdmaDocument;
import org.opendma.api.OdmaFolder;
import org.opendma.api.OdmaGuid;
import org.opendma.api.OdmaId;
import org.opendma.api.OdmaObject;
import org.opendma.api.OdmaProperty;
import org.opendma.api.OdmaPropertyInfo;
import org.opendma.api.OdmaQName;
import org.opendma.api.OdmaReferenceContentElement;
import org.opendma.api.OdmaRepository;
import org.opendma.api.OdmaVersionCollection;
import org.opendma.api.collections.OdmaAssociationEnumeration;
import org.opendma.api.collections.OdmaChoiceValueEnumeration;
import org.opendma.api.collections.OdmaClassEnumeration;
import org.opendma.api.collections.OdmaContainableEnumeration;
import org.opendma.api.collections.OdmaContainerEnumeration;
import org.opendma.api.collections.OdmaContentElementEnumeration;
import org.opendma.api.collections.OdmaDocumentEnumeration;
import org.opendma.api.collections.OdmaFolderEnumeration;
import org.opendma.exceptions.OdmaAccessDeniedException;
import org.opendma.exceptions.OdmaInvalidDataTypeException;
import org.opendma.exceptions.OdmaObjectNotFoundException;
import org.opendma.exceptions.OdmaRuntimeException;

import com.xaldon.opendma.xmlrepo.exceptions.OdmaXmlRepositoryException;

/**
 * Template implementation of the interface <code>{@link OdmaAssociation}</code>.<p>
 * 
 * Full description follows.
 * 
 * @author Stefan Kopf, xaldon Technologies GmbH, the OpenDMA architecture board
 */
public class OdmaXmlFullObject extends OdmaXmlObject implements OdmaAssociation, OdmaChoiceValue, OdmaContainable, OdmaContainer, OdmaContentElement, OdmaDataContentElement, OdmaDocument, OdmaFolder, OdmaObject, OdmaPropertyInfo, OdmaReferenceContentElement, OdmaRepository, OdmaVersionCollection
{

    public OdmaXmlFullObject(Map<OdmaQName, OdmaProperty> properties) throws OdmaXmlRepositoryException
    {
        super(properties);
    }
    
//----- OdmaAssociation

    // =============================================================================================
    // Object specific property access
    // =============================================================================================

    // CHECKTEMPLATE: the following code has most likely been copied from a class template. Make sure to keep this code up to date!
    // The following template code is available as OdmaAssociationTemplate

    /**
     * Returns the <i>name</i> of this <code>Association</code>.<br>
     * 
     * <p>Property <b>Name</b> (opendma): <b>String</b><br>
     * [SingleValue] [Writable] [Required]<br>
     * Full description follows.</p>
     * 
     * @return the <i>name</i> of this <code>Association</code>
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
     * Sets the <i>name</i> of this <code>Association</code>.<br>
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
     * Returns the <code>Container</code> of this <code>Association</code> in which the containable is said to be contained.<br>
     * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_CONTAINER).getReference()</code>.
     * 
     * <p>Property <b>Container</b> (opendma): <b>Reference to Container (opendma)</b><br>
     * [SingleValue] [Writable] [Required]<br>
     * Full description follows.</p>
     * 
     * @return the <code>Container</code> of this <code>Association</code> in which the containable is said to be contained
     */
    public OdmaContainer getContainer()
    {
        try
        {
            return (OdmaContainer)getProperty(OdmaTypes.PROPERTY_CONTAINER).getReference();
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
     * Sets the <code>Container</code> of this <code>Association</code> in which the containable is said to be contained.<br>
     * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_CONTAINER).setValue(value)</code>.
     * 
     * <p>Property <b>Container</b> (opendma): <b>Reference to Container (opendma)</b><br>
     * [SingleValue] [Writable] [Required]<br>
     * Full description follows.</p>
     * 
     * @throws OdmaAccessDeniedException
     *             if this property can not be set by the current user
     */
    public void setContainer(OdmaContainer value) throws OdmaAccessDeniedException
    {
        try
        {
            getProperty(OdmaTypes.PROPERTY_CONTAINER).setValue(value);
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
     * Returns the <code>Containable</code> of this <code>Association</code> which is said to be contained in the container.<br>
     * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_CONTAINABLE).getReference()</code>.
     * 
     * <p>Property <b>Containable</b> (opendma): <b>Reference to Containable (opendma)</b><br>
     * [SingleValue] [Writable] [Required]<br>
     * Full description follows.</p>
     * 
     * @return the <code>Containable</code> of this <code>Association</code> which is said to be contained in the container
     */
    public OdmaContainable getContainable()
    {
        try
        {
            return (OdmaContainable)getProperty(OdmaTypes.PROPERTY_CONTAINABLE).getReference();
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
     * Sets the <code>Containable</code> of this <code>Association</code> which is said to be contained in the container.<br>
     * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_CONTAINABLE).setValue(value)</code>.
     * 
     * <p>Property <b>Containable</b> (opendma): <b>Reference to Containable (opendma)</b><br>
     * [SingleValue] [Writable] [Required]<br>
     * Full description follows.</p>
     * 
     * @throws OdmaAccessDeniedException
     *             if this property can not be set by the current user
     */
    public void setContainable(OdmaContainable value) throws OdmaAccessDeniedException
    {
        try
        {
            getProperty(OdmaTypes.PROPERTY_CONTAINABLE).setValue(value);
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
     * Returns the date when this <code>Association</code> has been created.<br>
     * 
     * <p>Property <b>CreatedAt</b> (opendma): <b>DateTime</b><br>
     * [SingleValue] [ReadOnly] [Required]<br>
     * Full description follows.</p>
     * 
     * @return the date when this <code>Association</code> has been created
     */
    public Date getCreatedAt()
    {
        try
        {
            return getProperty(OdmaTypes.PROPERTY_CREATEDAT).getDateTime();
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
     * Returns the user who has created this <code>Association</code>.<br>
     * 
     * <p>Property <b>CreatedBy</b> (opendma): <b>String</b><br>
     * [SingleValue] [ReadOnly] [Required]<br>
     * Full description follows.</p>
     * 
     * @return the user who has created this <code>Association</code>
     */
    public String getCreatedBy()
    {
        try
        {
            return getProperty(OdmaTypes.PROPERTY_CREATEDBY).getString();
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
     * Returns the date when this <code>Association</code> has been modified the last time.<br>
     * 
     * <p>Property <b>LastModifiedAt</b> (opendma): <b>DateTime</b><br>
     * [SingleValue] [ReadOnly] [Required]<br>
     * Full description follows.</p>
     * 
     * @return the date when this <code>Association</code> has been modified the last time
     */
    public Date getLastModifiedAt()
    {
        try
        {
            return getProperty(OdmaTypes.PROPERTY_LASTMODIFIEDAT).getDateTime();
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
     * Returns the user who has modified this <code>Association</code> the last time.<br>
     * 
     * <p>Property <b>LastModifiedBy</b> (opendma): <b>String</b><br>
     * [SingleValue] [ReadOnly] [Required]<br>
     * Full description follows.</p>
     * 
     * @return the user who has modified this <code>Association</code> the last time
     */
    public String getLastModifiedBy()
    {
        try
        {
            return getProperty(OdmaTypes.PROPERTY_LASTMODIFIEDBY).getString();
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

//----- OdmaChoiceValue

    // =============================================================================================
    // Object specific property access
    // =============================================================================================

    // CHECKTEMPLATE: the following code has most likely been copied from a class template. Make sure to keep this code up to date!
    // The following template code is available as OdmaChoiceValueTemplate

    /**
     * Returns the <i>display name</i> of this Choice to be displayed to end users.<br>
     * 
     * <p>Property <b>DisplayName</b> (opendma): <b>String</b><br>
     * [SingleValue] [Writable] [Required]<br>
     * Full description follows.</p>
     * 
     * @return the <i>display name</i> of this Choice to be displayed to end users
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
     * Sets the <i>display name</i> of this Choice to be displayed to end users.<br>
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
     * Returns the String value of this choice or null, if the property info this choice is assigned to is not of data type String.<br>
     * 
     * <p>Property <b>StringValue</b> (opendma): <b>String</b><br>
     * [SingleValue] [Writable] [Nullable]<br>
     * Full description follows.</p>
     * 
     * @return the String value of this choice or null, if the property info this choice is assigned to is not of data type String
     */
    public String getStringValue()
    {
        try
        {
            return getProperty(OdmaTypes.PROPERTY_STRINGVALUE).getString();
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
     * Sets the String value of this choice or null, if the property info this choice is assigned to is not of data type String.<br>
     * 
     * <p>Property <b>StringValue</b> (opendma): <b>String</b><br>
     * [SingleValue] [Writable] [Nullable]<br>
     * Full description follows.</p>
     * 
     * @throws OdmaAccessDeniedException
     *             if this property can not be set by the current user
     */
    public void setStringValue(String value) throws OdmaAccessDeniedException
    {
        try
        {
            getProperty(OdmaTypes.PROPERTY_STRINGVALUE).setValue(value);
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
     * Returns the Integer value of this choice or null, if the property info this choice is assigned to is not of data type Integer.<br>
     * 
     * <p>Property <b>IntegerValue</b> (opendma): <b>String</b><br>
     * [SingleValue] [Writable] [Nullable]<br>
     * Full description follows.</p>
     * 
     * @return the Integer value of this choice or null, if the property info this choice is assigned to is not of data type Integer
     */
    public String getIntegerValue()
    {
        try
        {
            return getProperty(OdmaTypes.PROPERTY_INTEGERVALUE).getString();
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
     * Sets the Integer value of this choice or null, if the property info this choice is assigned to is not of data type Integer.<br>
     * 
     * <p>Property <b>IntegerValue</b> (opendma): <b>String</b><br>
     * [SingleValue] [Writable] [Nullable]<br>
     * Full description follows.</p>
     * 
     * @throws OdmaAccessDeniedException
     *             if this property can not be set by the current user
     */
    public void setIntegerValue(String value) throws OdmaAccessDeniedException
    {
        try
        {
            getProperty(OdmaTypes.PROPERTY_INTEGERVALUE).setValue(value);
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
     * Returns the Short value of this choice or null, if the property info this choice is assigned to is not of data type Short.<br>
     * 
     * <p>Property <b>ShortValue</b> (opendma): <b>String</b><br>
     * [SingleValue] [Writable] [Nullable]<br>
     * Full description follows.</p>
     * 
     * @return the Short value of this choice or null, if the property info this choice is assigned to is not of data type Short
     */
    public String getShortValue()
    {
        try
        {
            return getProperty(OdmaTypes.PROPERTY_SHORTVALUE).getString();
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
     * Sets the Short value of this choice or null, if the property info this choice is assigned to is not of data type Short.<br>
     * 
     * <p>Property <b>ShortValue</b> (opendma): <b>String</b><br>
     * [SingleValue] [Writable] [Nullable]<br>
     * Full description follows.</p>
     * 
     * @throws OdmaAccessDeniedException
     *             if this property can not be set by the current user
     */
    public void setShortValue(String value) throws OdmaAccessDeniedException
    {
        try
        {
            getProperty(OdmaTypes.PROPERTY_SHORTVALUE).setValue(value);
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
     * Returns the Long value of this choice or null, if the property info this choice is assigned to is not of data type Long.<br>
     * 
     * <p>Property <b>LongValue</b> (opendma): <b>String</b><br>
     * [SingleValue] [Writable] [Nullable]<br>
     * Full description follows.</p>
     * 
     * @return the Long value of this choice or null, if the property info this choice is assigned to is not of data type Long
     */
    public String getLongValue()
    {
        try
        {
            return getProperty(OdmaTypes.PROPERTY_LONGVALUE).getString();
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
     * Sets the Long value of this choice or null, if the property info this choice is assigned to is not of data type Long.<br>
     * 
     * <p>Property <b>LongValue</b> (opendma): <b>String</b><br>
     * [SingleValue] [Writable] [Nullable]<br>
     * Full description follows.</p>
     * 
     * @throws OdmaAccessDeniedException
     *             if this property can not be set by the current user
     */
    public void setLongValue(String value) throws OdmaAccessDeniedException
    {
        try
        {
            getProperty(OdmaTypes.PROPERTY_LONGVALUE).setValue(value);
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
     * Returns the Float value of this choice or null, if the property info this choice is assigned to is not of data type Float.<br>
     * 
     * <p>Property <b>FloatValue</b> (opendma): <b>String</b><br>
     * [SingleValue] [Writable] [Nullable]<br>
     * Full description follows.</p>
     * 
     * @return the Float value of this choice or null, if the property info this choice is assigned to is not of data type Float
     */
    public String getFloatValue()
    {
        try
        {
            return getProperty(OdmaTypes.PROPERTY_FLOATVALUE).getString();
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
     * Sets the Float value of this choice or null, if the property info this choice is assigned to is not of data type Float.<br>
     * 
     * <p>Property <b>FloatValue</b> (opendma): <b>String</b><br>
     * [SingleValue] [Writable] [Nullable]<br>
     * Full description follows.</p>
     * 
     * @throws OdmaAccessDeniedException
     *             if this property can not be set by the current user
     */
    public void setFloatValue(String value) throws OdmaAccessDeniedException
    {
        try
        {
            getProperty(OdmaTypes.PROPERTY_FLOATVALUE).setValue(value);
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
     * Returns the Double value of this choice or null, if the property info this choice is assigned to is not of data type Double.<br>
     * 
     * <p>Property <b>DoubleValue</b> (opendma): <b>String</b><br>
     * [SingleValue] [Writable] [Nullable]<br>
     * Full description follows.</p>
     * 
     * @return the Double value of this choice or null, if the property info this choice is assigned to is not of data type Double
     */
    public String getDoubleValue()
    {
        try
        {
            return getProperty(OdmaTypes.PROPERTY_DOUBLEVALUE).getString();
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
     * Sets the Double value of this choice or null, if the property info this choice is assigned to is not of data type Double.<br>
     * 
     * <p>Property <b>DoubleValue</b> (opendma): <b>String</b><br>
     * [SingleValue] [Writable] [Nullable]<br>
     * Full description follows.</p>
     * 
     * @throws OdmaAccessDeniedException
     *             if this property can not be set by the current user
     */
    public void setDoubleValue(String value) throws OdmaAccessDeniedException
    {
        try
        {
            getProperty(OdmaTypes.PROPERTY_DOUBLEVALUE).setValue(value);
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
     * Returns the Boolean value of this choice or null, if the property info this choice is assigned to is not of data type Boolean.<br>
     * 
     * <p>Property <b>BooleanValue</b> (opendma): <b>String</b><br>
     * [SingleValue] [Writable] [Nullable]<br>
     * Full description follows.</p>
     * 
     * @return the Boolean value of this choice or null, if the property info this choice is assigned to is not of data type Boolean
     */
    public String getBooleanValue()
    {
        try
        {
            return getProperty(OdmaTypes.PROPERTY_BOOLEANVALUE).getString();
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
     * Sets the Boolean value of this choice or null, if the property info this choice is assigned to is not of data type Boolean.<br>
     * 
     * <p>Property <b>BooleanValue</b> (opendma): <b>String</b><br>
     * [SingleValue] [Writable] [Nullable]<br>
     * Full description follows.</p>
     * 
     * @throws OdmaAccessDeniedException
     *             if this property can not be set by the current user
     */
    public void setBooleanValue(String value) throws OdmaAccessDeniedException
    {
        try
        {
            getProperty(OdmaTypes.PROPERTY_BOOLEANVALUE).setValue(value);
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
     * Returns the DateTime value of this choice or null, if the property info this choice is assigned to is not of data type DateTime.<br>
     * 
     * <p>Property <b>DateTimeValue</b> (opendma): <b>String</b><br>
     * [SingleValue] [Writable] [Nullable]<br>
     * Full description follows.</p>
     * 
     * @return the DateTime value of this choice or null, if the property info this choice is assigned to is not of data type DateTime
     */
    public String getDateTimeValue()
    {
        try
        {
            return getProperty(OdmaTypes.PROPERTY_DATETIMEVALUE).getString();
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
     * Sets the DateTime value of this choice or null, if the property info this choice is assigned to is not of data type DateTime.<br>
     * 
     * <p>Property <b>DateTimeValue</b> (opendma): <b>String</b><br>
     * [SingleValue] [Writable] [Nullable]<br>
     * Full description follows.</p>
     * 
     * @throws OdmaAccessDeniedException
     *             if this property can not be set by the current user
     */
    public void setDateTimeValue(String value) throws OdmaAccessDeniedException
    {
        try
        {
            getProperty(OdmaTypes.PROPERTY_DATETIMEVALUE).setValue(value);
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
     * Returns the BLOB value of this choice or null, if the property info this choice is assigned to is not of data type BLOB.<br>
     * 
     * <p>Property <b>BLOBValue</b> (opendma): <b>String</b><br>
     * [SingleValue] [Writable] [Nullable]<br>
     * Full description follows.</p>
     * 
     * @return the BLOB value of this choice or null, if the property info this choice is assigned to is not of data type BLOB
     */
    public String getBLOBValue()
    {
        try
        {
            return getProperty(OdmaTypes.PROPERTY_BLOBVALUE).getString();
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
     * Sets the BLOB value of this choice or null, if the property info this choice is assigned to is not of data type BLOB.<br>
     * 
     * <p>Property <b>BLOBValue</b> (opendma): <b>String</b><br>
     * [SingleValue] [Writable] [Nullable]<br>
     * Full description follows.</p>
     * 
     * @throws OdmaAccessDeniedException
     *             if this property can not be set by the current user
     */
    public void setBLOBValue(String value) throws OdmaAccessDeniedException
    {
        try
        {
            getProperty(OdmaTypes.PROPERTY_BLOBVALUE).setValue(value);
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
     * Returns the Reference value of this choice or null, if the property info this choice is assigned to is not of data type Reference.<br>
     * 
     * <p>Property <b>ReferenceValue</b> (opendma): <b>String</b><br>
     * [SingleValue] [Writable] [Nullable]<br>
     * Full description follows.</p>
     * 
     * @return the Reference value of this choice or null, if the property info this choice is assigned to is not of data type Reference
     */
    public String getReferenceValue()
    {
        try
        {
            return getProperty(OdmaTypes.PROPERTY_REFERENCEVALUE).getString();
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
     * Sets the Reference value of this choice or null, if the property info this choice is assigned to is not of data type Reference.<br>
     * 
     * <p>Property <b>ReferenceValue</b> (opendma): <b>String</b><br>
     * [SingleValue] [Writable] [Nullable]<br>
     * Full description follows.</p>
     * 
     * @throws OdmaAccessDeniedException
     *             if this property can not be set by the current user
     */
    public void setReferenceValue(String value) throws OdmaAccessDeniedException
    {
        try
        {
            getProperty(OdmaTypes.PROPERTY_REFERENCEVALUE).setValue(value);
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

//----- OdmaContainable

    // =============================================================================================
    // Object specific property access
    // =============================================================================================

    // CHECKTEMPLATE: the following code has most likely been copied from a class template. Make sure to keep this code up to date!
    // The following template code is available as OdmaContainableTemplate

    /**
     * Returns the collection of <code>Container</code>s this <code>Containable</code> is contained in.<br>
     * 
     * <p>Property <b>ContainedIn</b> (opendma): <b>Reference to Container (opendma)</b><br>
     * [MultiValue] [ReadOnly] [Nullable]<br>
     * Full description follows.</p>
     * 
     * @return the collection of <code>Container</code>s this <code>Containable</code> is contained in
     */
    public OdmaContainerEnumeration getContainedIn()
    {
        try
        {
            return (OdmaContainerEnumeration)getProperty(OdmaTypes.PROPERTY_CONTAINEDIN).getReferenceEnumeration();
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
     * Returns the collection of <code>Association</code>s that bind this <code>Containable</code> in the <code>Container</code>s.<br>
     * 
     * <p>Property <b>ContainedInAssociations</b> (opendma): <b>Reference to Association (opendma)</b><br>
     * [MultiValue] [ReadOnly] [Nullable]<br>
     * Full description follows.</p>
     * 
     * @return the collection of <code>Association</code>s that bind this <code>Containable</code> in the <code>Container</code>s
     */
    public OdmaAssociationEnumeration getContainedInAssociations()
    {
        try
        {
            return (OdmaAssociationEnumeration)getProperty(OdmaTypes.PROPERTY_CONTAINEDINASSOCIATIONS).getReferenceEnumeration();
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

//----- OdmaContainer

    // =============================================================================================
    // Object specific property access
    // =============================================================================================

    // CHECKTEMPLATE: the following code has most likely been copied from a class template. Make sure to keep this code up to date!
    // The following template code is available as OdmaContainerTemplate

    /**
     * Returns the <i>title</i> of this <code>Container</code>.<br>
     * 
     * <p>Property <b>Title</b> (opendma): <b>String</b><br>
     * [SingleValue] [Writable] [Nullable]<br>
     * Full description follows.</p>
     * 
     * @return the <i>title</i> of this <code>Container</code>
     */
    public String getTitle()
    {
        try
        {
            return getProperty(OdmaTypes.PROPERTY_TITLE).getString();
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
     * Sets the <i>title</i> of this <code>Container</code>.<br>
     * 
     * <p>Property <b>Title</b> (opendma): <b>String</b><br>
     * [SingleValue] [Writable] [Nullable]<br>
     * Full description follows.</p>
     * 
     * @throws OdmaAccessDeniedException
     *             if this property can not be set by the current user
     */
    public void setTitle(String value) throws OdmaAccessDeniedException
    {
        try
        {
            getProperty(OdmaTypes.PROPERTY_TITLE).setValue(value);
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
     * Returns the collection of all <code>Containable</code> objects that are contained in this <code>Container</code>.<br>
     * 
     * <p>Property <b>Containees</b> (opendma): <b>Reference to Containable (opendma)</b><br>
     * [MultiValue] [ReadOnly] [Required]<br>
     * Full description follows.</p>
     * 
     * @return the collection of all <code>Containable</code> objects that are contained in this <code>Container</code>
     */
    public OdmaContainableEnumeration getContainees()
    {
        try
        {
            return (OdmaContainableEnumeration)getProperty(OdmaTypes.PROPERTY_CONTAINEES).getReferenceEnumeration();
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
     * Returns the collection of all <code>Association</code>s between this <code>Container</code> and its containees.<br>
     * 
     * <p>Property <b>Associations</b> (opendma): <b>Reference to Association (opendma)</b><br>
     * [MultiValue] [ReadOnly] [Nullable]<br>
     * Full description follows.</p>
     * 
     * @return the collection of all <code>Association</code>s between this <code>Container</code> and its containees
     */
    public OdmaAssociationEnumeration getAssociations()
    {
        try
        {
            return (OdmaAssociationEnumeration)getProperty(OdmaTypes.PROPERTY_ASSOCIATIONS).getReferenceEnumeration();
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
     * Returns the date when this <code>Container</code> has been created.<br>
     * 
     * <p>Property <b>CreatedAt</b> (opendma): <b>DateTime</b><br>
     * [SingleValue] [ReadOnly] [Required]<br>
     * Full description follows.</p>
     * 
     * @return the date when this <code>Container</code> has been created
     */
//    public Date getCreatedAt()
//    {
//        try
//        {
//            return getProperty(OdmaTypes.PROPERTY_CREATEDAT).getDateTime();
//        }
//        catch(OdmaInvalidDataTypeException oidte)
//        {
//            throw new OdmaRuntimeException("Invalid data type of system property",oidte);
//        }
//        catch(OdmaObjectNotFoundException oonfe)
//        {
//            throw new OdmaRuntimeException("Predefined system property missing",oonfe);
//        }
//    }

    /**
     * Returns the user who has created this <code>Container</code>.<br>
     * 
     * <p>Property <b>CreatedBy</b> (opendma): <b>String</b><br>
     * [SingleValue] [ReadOnly] [Required]<br>
     * Full description follows.</p>
     * 
     * @return the user who has created this <code>Container</code>
     */
//    public String getCreatedBy()
//    {
//        try
//        {
//            return getProperty(OdmaTypes.PROPERTY_CREATEDBY).getString();
//        }
//        catch(OdmaInvalidDataTypeException oidte)
//        {
//            throw new OdmaRuntimeException("Invalid data type of system property",oidte);
//        }
//        catch(OdmaObjectNotFoundException oonfe)
//        {
//            throw new OdmaRuntimeException("Predefined system property missing",oonfe);
//        }
//    }

    /**
     * Returns the date when this <code>Container</code> has been modified the last time.<br>
     * 
     * <p>Property <b>LastModifiedAt</b> (opendma): <b>DateTime</b><br>
     * [SingleValue] [ReadOnly] [Required]<br>
     * Full description follows.</p>
     * 
     * @return the date when this <code>Container</code> has been modified the last time
     */
//    public Date getLastModifiedAt()
//    {
//        try
//        {
//            return getProperty(OdmaTypes.PROPERTY_LASTMODIFIEDAT).getDateTime();
//        }
//        catch(OdmaInvalidDataTypeException oidte)
//        {
//            throw new OdmaRuntimeException("Invalid data type of system property",oidte);
//        }
//        catch(OdmaObjectNotFoundException oonfe)
//        {
//            throw new OdmaRuntimeException("Predefined system property missing",oonfe);
//        }
//    }

    /**
     * Returns the user who has modified this <code>Container</code> the last time.<br>
     * 
     * <p>Property <b>LastModifiedBy</b> (opendma): <b>String</b><br>
     * [SingleValue] [ReadOnly] [Required]<br>
     * Full description follows.</p>
     * 
     * @return the user who has modified this <code>Container</code> the last time
     */
//    public String getLastModifiedBy()
//    {
//        try
//        {
//            return getProperty(OdmaTypes.PROPERTY_LASTMODIFIEDBY).getString();
//        }
//        catch(OdmaInvalidDataTypeException oidte)
//        {
//            throw new OdmaRuntimeException("Invalid data type of system property",oidte);
//        }
//        catch(OdmaObjectNotFoundException oonfe)
//        {
//            throw new OdmaRuntimeException("Predefined system property missing",oonfe);
//        }
//    }

//----- OdmaContentElement

    // =============================================================================================
    // Object specific property access
    // =============================================================================================

    // CHECKTEMPLATE: the following code has most likely been copied from a class template. Make sure to keep this code up to date!
    // The following template code is available as OdmaContentElementTemplate

    /**
     * Returns the mime type describing how the <code>Content</code> of this <code>ContentElement</code> has to be interpreted.<br>
     * 
     * <p>Property <b>ContentType</b> (opendma): <b>String</b><br>
     * [SingleValue] [Writable] [Nullable]<br>
     * Full description follows.</p>
     * 
     * @return the mime type describing how the <code>Content</code> of this <code>ContentElement</code> has to be interpreted
     */
    public String getContentType()
    {
        try
        {
            return getProperty(OdmaTypes.PROPERTY_CONTENTTYPE).getString();
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
     * Sets the mime type describing how the <code>Content</code> of this <code>ContentElement</code> has to be interpreted.<br>
     * 
     * <p>Property <b>ContentType</b> (opendma): <b>String</b><br>
     * [SingleValue] [Writable] [Nullable]<br>
     * Full description follows.</p>
     * 
     * @throws OdmaAccessDeniedException
     *             if this property can not be set by the current user
     */
    public void setContentType(String value) throws OdmaAccessDeniedException
    {
        try
        {
            getProperty(OdmaTypes.PROPERTY_CONTENTTYPE).setValue(value);
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
     * Returns the position of this element in the list of all content elements of the containing document.<br>
     * 
     * <p>Property <b>Position</b> (opendma): <b>Integer</b><br>
     * [SingleValue] [ReadOnly] [Required]<br>
     * Full description follows.</p>
     * 
     * @return the position of this element in the list of all content elements of the containing document
     */
    public Integer getPosition()
    {
        try
        {
            return getProperty(OdmaTypes.PROPERTY_POSITION).getInteger();
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

// OdmaDataContentElement

    // =============================================================================================
    // Object specific property access
    // =============================================================================================

    // CHECKTEMPLATE: the following code has most likely been copied from a class template. Make sure to keep this code up to date!
    // The following template code is available as OdmaDataContentElementTemplate

    /**
     * Returns the binary content of this <code>ContentElement</code> as octets.<br>
     * 
     * <p>Property <b>Content</b> (opendma): <b>Content</b><br>
     * [SingleValue] [Writable] [Nullable]<br>
     * Full description follows.</p>
     * 
     * @return the binary content of this <code>ContentElement</code> as octets
     */
    public OdmaContent getContent()
    {
        try
        {
            return getProperty(OdmaTypes.PROPERTY_CONTENT).getContent();
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
     * Sets the binary content of this <code>ContentElement</code> as octets.<br>
     * 
     * <p>Property <b>Content</b> (opendma): <b>Content</b><br>
     * [SingleValue] [Writable] [Nullable]<br>
     * Full description follows.</p>
     * 
     * @throws OdmaAccessDeniedException
     *             if this property can not be set by the current user
     */
    public void setContent(OdmaContent value) throws OdmaAccessDeniedException
    {
        try
        {
            getProperty(OdmaTypes.PROPERTY_CONTENT).setValue(value);
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
     * Returns the number of octests the binary content of this <code>ContentElement</code> consists of.<br>
     * 
     * <p>Property <b>Size</b> (opendma): <b>Long</b><br>
     * [SingleValue] [ReadOnly] [Required]<br>
     * Full description follows.</p>
     * 
     * @return the number of octests the binary content of this <code>ContentElement</code> consists of
     */
    public Long getSize()
    {
        try
        {
            return getProperty(OdmaTypes.PROPERTY_SIZE).getLong();
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
     * Returns the optional file name of this <code>ContentElement</code>.<br>
     * 
     * <p>Property <b>FileName</b> (opendma): <b>String</b><br>
     * [SingleValue] [Writable] [Nullable]<br>
     * Full description follows.</p>
     * 
     * @return the optional file name of this <code>ContentElement</code>
     */
    public String getFileName()
    {
        try
        {
            return getProperty(OdmaTypes.PROPERTY_FILENAME).getString();
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
     * Sets the optional file name of this <code>ContentElement</code>.<br>
     * 
     * <p>Property <b>FileName</b> (opendma): <b>String</b><br>
     * [SingleValue] [Writable] [Nullable]<br>
     * Full description follows.</p>
     * 
     * @throws OdmaAccessDeniedException
     *             if this property can not be set by the current user
     */
    public void setFileName(String value) throws OdmaAccessDeniedException
    {
        try
        {
            getProperty(OdmaTypes.PROPERTY_FILENAME).setValue(value);
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

//----- OdmaDocument

    // =============================================================================================
    // Object specific property access
    // =============================================================================================

    // CHECKTEMPLATE: the following code has most likely been copied from a class template. Make sure to keep this code up to date!
    // The following template code is available as OdmaDocumentTemplate

    /**
     * Returns the <i>title</i> of this <code>Document</code>.<br>
     * 
     * <p>Property <b>Title</b> (opendma): <b>String</b><br>
     * [SingleValue] [Writable] [Nullable]<br>
     * Full description follows.</p>
     * 
     * @return the <i>title</i> of this <code>Document</code>
     */
//    public String getTitle()
//    {
//        try
//        {
//            return getProperty(OdmaTypes.PROPERTY_TITLE).getString();
//        }
//        catch(OdmaInvalidDataTypeException oidte)
//        {
//            throw new OdmaRuntimeException("Invalid data type of system property",oidte);
//        }
//        catch(OdmaObjectNotFoundException oonfe)
//        {
//            throw new OdmaRuntimeException("Predefined system property missing",oonfe);
//        }
//    }

    /**
     * Sets the <i>title</i> of this <code>Document</code>.<br>
     * 
     * <p>Property <b>Title</b> (opendma): <b>String</b><br>
     * [SingleValue] [Writable] [Nullable]<br>
     * Full description follows.</p>
     * 
     * @throws OdmaAccessDeniedException
     *             if this property can not be set by the current user
     */
//    public void setTitle(String value) throws OdmaAccessDeniedException
//    {
//        try
//        {
//            getProperty(OdmaTypes.PROPERTY_TITLE).setValue(value);
//        }
//        catch(OdmaInvalidDataTypeException oidte)
//        {
//            throw new OdmaRuntimeException("Invalid data type of system property",oidte);
//        }
//        catch(OdmaObjectNotFoundException oonfe)
//        {
//            throw new OdmaRuntimeException("Predefined system property missing",oonfe);
//        }
//    }

    /**
     * Returns the <i>version string</i> describing this <i>version</i> of this <code>Document</code> (e.g. 1.0, 1.1, 1.2, 2.0).<br>
     * 
     * <p>Property <b>Version</b> (opendma): <b>String</b><br>
     * [SingleValue] [ReadOnly] [Nullable]<br>
     * Full description follows.</p>
     * 
     * @return the <i>version string</i> describing this <i>version</i> of this <code>Document</code> (e.g. 1.0, 1.1, 1.2, 2.0)
     */
    public String getVersion()
    {
        try
        {
            return getProperty(OdmaTypes.PROPERTY_VERSION).getString();
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
     * Returns reference to a <i>VersionCollection</i> object containing the collection of all <i>versions</i> of this <code>Document</code> along with other information.<br>
     * 
     * <p>Property <b>VersionCollection</b> (opendma): <b>Reference to VersionCollection (opendma)</b><br>
     * [SingleValue] [ReadOnly] [Nullable]<br>
     * Full description follows.</p>
     * 
     * @return reference to a <i>VersionCollection</i> object containing the collection of all <i>versions</i> of this <code>Document</code> along with other information
     */
    public OdmaVersionCollection getVersionCollection()
    {
        try
        {
            return (OdmaVersionCollection)getProperty(OdmaTypes.PROPERTY_VERSIONCOLLECTION).getReference();
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
     * Returns the <i>unique object identifier</i> identifying this logical document independent from the specific version inside its <code>Repository</code>.<br>
     * 
     * <p>Property <b>VersionIndependentId</b> (opendma): <b>String</b><br>
     * [SingleValue] [ReadOnly] [Required]<br>
     * Full description follows.</p>
     * 
     * @return the <i>unique object identifier</i> identifying this logical document independent from the specific version inside its <code>Repository</code>
     */
    public OdmaId getVersionIndependentId()
    {
        try
        {
            return getProperty(OdmaTypes.PROPERTY_VERSIONINDEPENDENTID).getId();
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
     * Returns the <i>global unique object identifier</i> globally identifying this logical document independent from the specific version.<br>
     * 
     * <p>Property <b>VersionIndependentGuid</b> (opendma): <b>String</b><br>
     * [SingleValue] [ReadOnly] [Required]<br>
     * Full description follows.</p>
     * 
     * @return the <i>global unique object identifier</i> globally identifying this logical document independent from the specific version
     */
    public OdmaGuid getVersionIndependentGuid()
    {
        try
        {
            return getProperty(OdmaTypes.PROPERTY_VERSIONINDEPENDENTGUID).getGuid();
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
     * Returns the collection of all <code>ContentElement</code>s this <code>Document</code> consists of.<br>
     * 
     * <p>Property <b>ContentElements</b> (opendma): <b>Reference to ContentElement (opendma)</b><br>
     * [MultiValue] [Writable] [Nullable]<br>
     * Full description follows.</p>
     * 
     * @return the collection of all <code>ContentElement</code>s this <code>Document</code> consists of
     */
    public OdmaContentElementEnumeration getContentElements()
    {
        try
        {
            return (OdmaContentElementEnumeration)getProperty(OdmaTypes.PROPERTY_CONTENTELEMENTS).getReferenceEnumeration();
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
     * Returns the combined mime type that has been build over all <code>ContentElement</code>s this <code>Document</code> consists of.<br>
     * 
     * <p>Property <b>CombinedContentType</b> (opendma): <b>String</b><br>
     * [SingleValue] [Writable] [Nullable]<br>
     * Full description follows.</p>
     * 
     * @return the combined mime type that has been build over all <code>ContentElement</code>s this <code>Document</code> consists of
     */
    public String getCombinedContentType()
    {
        try
        {
            return getProperty(OdmaTypes.PROPERTY_COMBINEDCONTENTTYPE).getString();
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
     * Sets the combined mime type that has been build over all <code>ContentElement</code>s this <code>Document</code> consists of.<br>
     * 
     * <p>Property <b>CombinedContentType</b> (opendma): <b>String</b><br>
     * [SingleValue] [Writable] [Nullable]<br>
     * Full description follows.</p>
     * 
     * @throws OdmaAccessDeniedException
     *             if this property can not be set by the current user
     */
    public void setCombinedContentType(String value) throws OdmaAccessDeniedException
    {
        try
        {
            getProperty(OdmaTypes.PROPERTY_COMBINEDCONTENTTYPE).setValue(value);
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
     * Returns the primary <code>ContentElement</code>s that represents this <code>Document</code>.<br>
     * 
     * <p>Property <b>PrimaryContentElement</b> (opendma): <b>Reference to ContentElement (opendma)</b><br>
     * [SingleValue] [Writable] [Nullable]<br>
     * Full description follows.</p>
     * 
     * @return the primary <code>ContentElement</code>s that represents this <code>Document</code>
     */
    public OdmaContentElement getPrimaryContentElement()
    {
        try
        {
            return (OdmaContentElement)getProperty(OdmaTypes.PROPERTY_PRIMARYCONTENTELEMENT).getReference();
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
     * Sets the primary <code>ContentElement</code>s that represents this <code>Document</code>.<br>
     * 
     * <p>Property <b>PrimaryContentElement</b> (opendma): <b>Reference to ContentElement (opendma)</b><br>
     * [SingleValue] [Writable] [Nullable]<br>
     * Full description follows.</p>
     * 
     * @throws OdmaAccessDeniedException
     *             if this property can not be set by the current user
     */
    public void setPrimaryContentElement(OdmaContentElement value) throws OdmaAccessDeniedException
    {
        try
        {
            getProperty(OdmaTypes.PROPERTY_PRIMARYCONTENTELEMENT).setValue(value);
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
     * Returns the date when this version of this <code>Document</code> has been created.<br>
     * 
     * <p>Property <b>CreatedAt</b> (opendma): <b>DateTime</b><br>
     * [SingleValue] [ReadOnly] [Required]<br>
     * Full description follows.</p>
     * 
     * @return the date when this version of this <code>Document</code> has been created
     */
//    public Date getCreatedAt()
//    {
//        try
//        {
//            return getProperty(OdmaTypes.PROPERTY_CREATEDAT).getDateTime();
//        }
//        catch(OdmaInvalidDataTypeException oidte)
//        {
//            throw new OdmaRuntimeException("Invalid data type of system property",oidte);
//        }
//        catch(OdmaObjectNotFoundException oonfe)
//        {
//            throw new OdmaRuntimeException("Predefined system property missing",oonfe);
//        }
//    }

    /**
     * Returns the user who has created this version of this <code>Document</code>.<br>
     * 
     * <p>Property <b>CreatedBy</b> (opendma): <b>String</b><br>
     * [SingleValue] [ReadOnly] [Required]<br>
     * Full description follows.</p>
     * 
     * @return the user who has created this version of this <code>Document</code>
     */
//    public String getCreatedBy()
//    {
//        try
//        {
//            return getProperty(OdmaTypes.PROPERTY_CREATEDBY).getString();
//        }
//        catch(OdmaInvalidDataTypeException oidte)
//        {
//            throw new OdmaRuntimeException("Invalid data type of system property",oidte);
//        }
//        catch(OdmaObjectNotFoundException oonfe)
//        {
//            throw new OdmaRuntimeException("Predefined system property missing",oonfe);
//        }
//    }

    /**
     * Returns the date when this version of this <code>Document</code> has been modified the last time.<br>
     * 
     * <p>Property <b>LastModifiedAt</b> (opendma): <b>DateTime</b><br>
     * [SingleValue] [ReadOnly] [Required]<br>
     * Full description follows.</p>
     * 
     * @return the date when this version of this <code>Document</code> has been modified the last time
     */
//    public Date getLastModifiedAt()
//    {
//        try
//        {
//            return getProperty(OdmaTypes.PROPERTY_LASTMODIFIEDAT).getDateTime();
//        }
//        catch(OdmaInvalidDataTypeException oidte)
//        {
//            throw new OdmaRuntimeException("Invalid data type of system property",oidte);
//        }
//        catch(OdmaObjectNotFoundException oonfe)
//        {
//            throw new OdmaRuntimeException("Predefined system property missing",oonfe);
//        }
//    }

    /**
     * Returns the user who has modified this version of this <code>Document</code> the last time.<br>
     * 
     * <p>Property <b>LastModifiedBy</b> (opendma): <b>String</b><br>
     * [SingleValue] [ReadOnly] [Required]<br>
     * Full description follows.</p>
     * 
     * @return the user who has modified this version of this <code>Document</code> the last time
     */
//    public String getLastModifiedBy()
//    {
//        try
//        {
//            return getProperty(OdmaTypes.PROPERTY_LASTMODIFIEDBY).getString();
//        }
//        catch(OdmaInvalidDataTypeException oidte)
//        {
//            throw new OdmaRuntimeException("Invalid data type of system property",oidte);
//        }
//        catch(OdmaObjectNotFoundException oonfe)
//        {
//            throw new OdmaRuntimeException("Predefined system property missing",oonfe);
//        }
//    }

    /**
     * Returns <code>true</code> if and only if this <code>Document</code> is checked out.<br>
     * 
     * <p>Property <b>CheckedOut</b> (opendma): <b>Boolean</b><br>
     * [SingleValue] [ReadOnly] [Required]<br>
     * Full description follows.</p>
     * 
     * @return <code>true</code> if and only if this <code>Document</code> is checked out
     */
    public Boolean getCheckedOut()
    {
        try
        {
            return getProperty(OdmaTypes.PROPERTY_CHECKEDOUT).getBoolean();
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
     * Returns the date when this <code>Document</code> has been checked out.<br>
     * 
     * <p>Property <b>CheckedOutAt</b> (opendma): <b>DateTime</b><br>
     * [SingleValue] [ReadOnly] [Nullable]<br>
     * Full description follows.</p>
     * 
     * @return the date when this <code>Document</code> has been checked out
     */
    public Date getCheckedOutAt()
    {
        try
        {
            return getProperty(OdmaTypes.PROPERTY_CHECKEDOUTAT).getDateTime();
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
     * Returns the user who has checked out this <code>Document</code>.<br>
     * 
     * <p>Property <b>CheckedOutBy</b> (opendma): <b>String</b><br>
     * [SingleValue] [ReadOnly] [Required]<br>
     * Full description follows.</p>
     * 
     * @return the user who has checked out this <code>Document</code>
     */
    public String getCheckedOutBy()
    {
        try
        {
            return getProperty(OdmaTypes.PROPERTY_CHECKEDOUTBY).getString();
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

//----- OdmaFolder

    // =============================================================================================
    // Object specific property access
    // =============================================================================================

    // CHECKTEMPLATE: the following code has most likely been copied from a class template. Make sure to keep this code up to date!
    // The following template code is available as OdmaFolderTemplate

    /**
     * Returns the <code>Folder</code> this <code>Folder</code> is a sub folder of.<br>
     * 
     * <p>Property <b>Parent</b> (opendma): <b>Reference to Folder (opendma)</b><br>
     * [SingleValue] [Writable] [Nullable]<br>
     * Full description follows.</p>
     * 
     * @return the <code>Folder</code> this <code>Folder</code> is a sub folder of
     */
    public OdmaFolder getParent()
    {
        try
        {
            return (OdmaFolder)getProperty(OdmaTypes.PROPERTY_PARENT).getReference();
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
     * Sets the <code>Folder</code> this <code>Folder</code> is a sub folder of.<br>
     * 
     * <p>Property <b>Parent</b> (opendma): <b>Reference to Folder (opendma)</b><br>
     * [SingleValue] [Writable] [Nullable]<br>
     * Full description follows.</p>
     * 
     * @throws OdmaAccessDeniedException
     *             if this property can not be set by the current user
     */
    public void setParent(OdmaFolder value) throws OdmaAccessDeniedException
    {
        try
        {
            getProperty(OdmaTypes.PROPERTY_PARENT).setValue(value);
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
     * Returns the collection of <code>Folder</code>s which have this <code>Folder</code> in their parent ptoperty.<br>
     * 
     * <p>Property <b>SubFolders</b> (opendma): <b>Reference to Folder (opendma)</b><br>
     * [MultiValue] [ReadOnly] [Nullable]<br>
     * Full description follows.</p>
     * 
     * @return the collection of <code>Folder</code>s which have this <code>Folder</code> in their parent ptoperty
     */
    public OdmaFolderEnumeration getSubFolders()
    {
        try
        {
            return (OdmaFolderEnumeration)getProperty(OdmaTypes.PROPERTY_SUBFOLDERS).getReferenceEnumeration();
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

//----- OdmaPropertyInfo

    // =============================================================================================
    // Object specific property access
    // =============================================================================================

    // CHECKTEMPLATE: the following code has most likely been copied from a class template. Make sure to keep this code up to date!
    // The following template code is available as OdmaPropertyInfoTemplate

    /**
     * Returns the internal (technical) <i>name</i> of this <code>PropertyInfo</code>.<br>
     * 
     * <p>Property <b>Name</b> (opendma): <b>String</b><br>
     * [SingleValue] [Writable] [Required]<br>
     * Full description follows.</p>
     * 
     * @return the internal (technical) <i>name</i> of this <code>PropertyInfo</code>
     */
//    public String getName()
//    {
//        try
//        {
//            return getProperty(OdmaTypes.PROPERTY_NAME).getString();
//        }
//        catch(OdmaInvalidDataTypeException oidte)
//        {
//            throw new OdmaRuntimeException("Invalid data type of system property",oidte);
//        }
//        catch(OdmaObjectNotFoundException oonfe)
//        {
//            throw new OdmaRuntimeException("Predefined system property missing",oonfe);
//        }
//    }

    /**
     * Sets the internal (technical) <i>name</i> of this <code>PropertyInfo</code>.<br>
     * 
     * <p>Property <b>Name</b> (opendma): <b>String</b><br>
     * [SingleValue] [Writable] [Required]<br>
     * Full description follows.</p>
     * 
     * @throws OdmaAccessDeniedException
     *             if this property can not be set by the current user
     */
//    public void setName(String value) throws OdmaAccessDeniedException
//    {
//        try
//        {
//            getProperty(OdmaTypes.PROPERTY_NAME).setValue(value);
//        }
//        catch(OdmaInvalidDataTypeException oidte)
//        {
//            throw new OdmaRuntimeException("Invalid data type of system property",oidte);
//        }
//        catch(OdmaObjectNotFoundException oonfe)
//        {
//            throw new OdmaRuntimeException("Predefined system property missing",oonfe);
//        }
//    }

    /**
     * Returns the name <i>qualifier</i> of this <code>PropertyInfo</code>.<br>
     * 
     * <p>Property <b>NameQualifier</b> (opendma): <b>String</b><br>
     * [SingleValue] [Writable] [Nullable]<br>
     * Full description follows.</p>
     * 
     * @return the name <i>qualifier</i> of this <code>PropertyInfo</code>
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
     * Sets the name <i>qualifier</i> of this <code>PropertyInfo</code>.<br>
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
     * Returns the <i>display name</i> of this <code>PropertyInfo</code> to be displayed to end users.<br>
     * 
     * <p>Property <b>DisplayName</b> (opendma): <b>String</b><br>
     * [SingleValue] [Writable] [Required]<br>
     * Full description follows.</p>
     * 
     * @return the <i>display name</i> of this <code>PropertyInfo</code> to be displayed to end users
     */
//    public String getDisplayName()
//    {
//        try
//        {
//            return getProperty(OdmaTypes.PROPERTY_DISPLAYNAME).getString();
//        }
//        catch(OdmaInvalidDataTypeException oidte)
//        {
//            throw new OdmaRuntimeException("Invalid data type of system property",oidte);
//        }
//        catch(OdmaObjectNotFoundException oonfe)
//        {
//            throw new OdmaRuntimeException("Predefined system property missing",oonfe);
//        }
//    }

    /**
     * Sets the <i>display name</i> of this <code>PropertyInfo</code> to be displayed to end users.<br>
     * 
     * <p>Property <b>DisplayName</b> (opendma): <b>String</b><br>
     * [SingleValue] [Writable] [Required]<br>
     * Full description follows.</p>
     * 
     * @throws OdmaAccessDeniedException
     *             if this property can not be set by the current user
     */
//    public void setDisplayName(String value) throws OdmaAccessDeniedException
//    {
//        try
//        {
//            getProperty(OdmaTypes.PROPERTY_DISPLAYNAME).setValue(value);
//        }
//        catch(OdmaInvalidDataTypeException oidte)
//        {
//            throw new OdmaRuntimeException("Invalid data type of system property",oidte);
//        }
//        catch(OdmaObjectNotFoundException oonfe)
//        {
//            throw new OdmaRuntimeException("Predefined system property missing",oonfe);
//        }
//    }

    /**
     * Returns the numeric ID of the data type described by this <code>PropertyInfo</code>.<br>
     * 
     * <p>Property <b>DataType</b> (opendma): <b>Integer</b><br>
     * [SingleValue] [Writable] [Required]<br>
     * Full description follows.</p>
     * 
     * @return the numeric ID of the data type described by this <code>PropertyInfo</code>
     */
    public Integer getDataType()
    {
        try
        {
            return getProperty(OdmaTypes.PROPERTY_DATATYPE).getInteger();
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
     * Sets the numeric ID of the data type described by this <code>PropertyInfo</code>.<br>
     * 
     * <p>Property <b>DataType</b> (opendma): <b>Integer</b><br>
     * [SingleValue] [Writable] [Required]<br>
     * Full description follows.</p>
     * 
     * @throws OdmaAccessDeniedException
     *             if this property can not be set by the current user
     */
    public void setDataType(Integer value) throws OdmaAccessDeniedException
    {
        try
        {
            getProperty(OdmaTypes.PROPERTY_DATATYPE).setValue(value);
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
     * Returns the required <code>Class</code> of the object referenced by this property if this <code>PropertyInfo</code>.<br>
     * 
     * <p>Property <b>ReferenceClass</b> (opendma): <b>Reference to Class (opendma)</b><br>
     * [SingleValue] [Writable] [Nullable]<br>
     * Full description follows.</p>
     * 
     * @return the required <code>Class</code> of the object referenced by this property if this <code>PropertyInfo</code>
     */
    public OdmaClass getReferenceClass()
    {
        try
        {
            return (OdmaClass)getProperty(OdmaTypes.PROPERTY_REFERENCECLASS).getReference();
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
     * Sets the required <code>Class</code> of the object referenced by this property if this <code>PropertyInfo</code>.<br>
     * 
     * <p>Property <b>ReferenceClass</b> (opendma): <b>Reference to Class (opendma)</b><br>
     * [SingleValue] [Writable] [Nullable]<br>
     * Full description follows.</p>
     * 
     * @throws OdmaAccessDeniedException
     *             if this property can not be set by the current user
     */
    public void setReferenceClass(OdmaClass value) throws OdmaAccessDeniedException
    {
        try
        {
            getProperty(OdmaTypes.PROPERTY_REFERENCECLASS).setValue(value);
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
     * <p>Property <b>MultiValue</b> (opendma): <b>Boolean</b><br>
     * [SingleValue] [Writable] [Required]<br>
     * Full description follows.</p>
     * 
     * @return wheather <code>Object</code>s of this <code>Class</code> can be created or not
     */
    public Boolean getMultiValue()
    {
        try
        {
            return getProperty(OdmaTypes.PROPERTY_MULTIVALUE).getBoolean();
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
     * <p>Property <b>MultiValue</b> (opendma): <b>Boolean</b><br>
     * [SingleValue] [Writable] [Required]<br>
     * Full description follows.</p>
     * 
     * @throws OdmaAccessDeniedException
     *             if this property can not be set by the current user
     */
    public void setMultiValue(Boolean value) throws OdmaAccessDeniedException
    {
        try
        {
            getProperty(OdmaTypes.PROPERTY_MULTIVALUE).setValue(value);
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
     * <p>Property <b>Required</b> (opendma): <b>Boolean</b><br>
     * [SingleValue] [Writable] [Required]<br>
     * Full description follows.</p>
     * 
     * @return wheather <code>Object</code>s of this <code>Class</code> can be created or not
     */
    public Boolean getRequired()
    {
        try
        {
            return getProperty(OdmaTypes.PROPERTY_REQUIRED).getBoolean();
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
     * <p>Property <b>Required</b> (opendma): <b>Boolean</b><br>
     * [SingleValue] [Writable] [Required]<br>
     * Full description follows.</p>
     * 
     * @throws OdmaAccessDeniedException
     *             if this property can not be set by the current user
     */
    public void setRequired(Boolean value) throws OdmaAccessDeniedException
    {
        try
        {
            getProperty(OdmaTypes.PROPERTY_REQUIRED).setValue(value);
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
     * <p>Property <b>ReadOnly</b> (opendma): <b>Boolean</b><br>
     * [SingleValue] [Writable] [Required]<br>
     * Full description follows.</p>
     * 
     * @return wheather this <code>Class</code> should be displayed to end users or not
     */
    public Boolean getReadOnly()
    {
        try
        {
            return getProperty(OdmaTypes.PROPERTY_READONLY).getBoolean();
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
     * <p>Property <b>ReadOnly</b> (opendma): <b>Boolean</b><br>
     * [SingleValue] [Writable] [Required]<br>
     * Full description follows.</p>
     * 
     * @throws OdmaAccessDeniedException
     *             if this property can not be set by the current user
     */
    public void setReadOnly(Boolean value) throws OdmaAccessDeniedException
    {
        try
        {
            getProperty(OdmaTypes.PROPERTY_READONLY).setValue(value);
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
     * Returns set of possible choices the values of this property is limited to or null if there are no constraints for the value of this property.<br>
     * 
     * <p>Property <b>Choices</b> (opendma): <b>Reference to ChoiceValue (opendma)</b><br>
     * [MultiValue] [Writable] [Nullable]<br>
     * Full description follows.</p>
     * 
     * @return set of possible choices the values of this property is limited to or null if there are no constraints for the value of this property
     */
    public OdmaChoiceValueEnumeration getChoices()
    {
        try
        {
            return (OdmaChoiceValueEnumeration)getProperty(OdmaTypes.PROPERTY_CHOICES).getReferenceEnumeration();
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

//----- OdmaReferenceContentElement

    // =============================================================================================
    // Object specific property access
    // =============================================================================================

    // CHECKTEMPLATE: the following code has most likely been copied from a class template. Make sure to keep this code up to date!
    // The following template code is available as OdmaReferenceContentElementTemplate

    /**
     * Returns the URI where the content is stored.<br>
     * 
     * <p>Property <b>Location</b> (opendma): <b>String</b><br>
     * [SingleValue] [Writable] [Nullable]<br>
     * Full description follows.</p>
     * 
     * @return the URI where the content is stored
     */
    public String getLocation()
    {
        try
        {
            return getProperty(OdmaTypes.PROPERTY_LOCATION).getString();
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
     * Sets the URI where the content is stored.<br>
     * 
     * <p>Property <b>Location</b> (opendma): <b>String</b><br>
     * [SingleValue] [Writable] [Nullable]<br>
     * Full description follows.</p>
     * 
     * @throws OdmaAccessDeniedException
     *             if this property can not be set by the current user
     */
    public void setLocation(String value) throws OdmaAccessDeniedException
    {
        try
        {
            getProperty(OdmaTypes.PROPERTY_LOCATION).setValue(value);
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

//----- OdmaRepository

    // =============================================================================================
    // Object specific property access
    // =============================================================================================

    // CHECKTEMPLATE: the following code has most likely been copied from a class template. Make sure to keep this code up to date!
    // The following template code is available as OdmaRepositoryTemplate

    /**
     * Returns the internal (technical) <i>name</i> of this <code>Repository</code>.<br>
     * 
     * <p>Property <b>Name</b> (opendma): <b>String</b><br>
     * [SingleValue] [Writable] [Required]<br>
     * Full description follows.</p>
     * 
     * @return the internal (technical) <i>name</i> of this <code>Repository</code>
     */
//    public String getName()
//    {
//        try
//        {
//            return getProperty(OdmaTypes.PROPERTY_NAME).getString();
//        }
//        catch(OdmaInvalidDataTypeException oidte)
//        {
//            throw new OdmaRuntimeException("Invalid data type of system property",oidte);
//        }
//        catch(OdmaObjectNotFoundException oonfe)
//        {
//            throw new OdmaRuntimeException("Predefined system property missing",oonfe);
//        }
//    }

    /**
     * Sets the internal (technical) <i>name</i> of this <code>Repository</code>.<br>
     * 
     * <p>Property <b>Name</b> (opendma): <b>String</b><br>
     * [SingleValue] [Writable] [Required]<br>
     * Full description follows.</p>
     * 
     * @throws OdmaAccessDeniedException
     *             if this property can not be set by the current user
     */
//    public void setName(String value) throws OdmaAccessDeniedException
//    {
//        try
//        {
//            getProperty(OdmaTypes.PROPERTY_NAME).setValue(value);
//        }
//        catch(OdmaInvalidDataTypeException oidte)
//        {
//            throw new OdmaRuntimeException("Invalid data type of system property",oidte);
//        }
//        catch(OdmaObjectNotFoundException oonfe)
//        {
//            throw new OdmaRuntimeException("Predefined system property missing",oonfe);
//        }
//    }

    /**
     * Returns the <i>display name</i> of this <code>Repository</code> to be displayed to end users.<br>
     * 
     * <p>Property <b>DisplayName</b> (opendma): <b>String</b><br>
     * [SingleValue] [Writable] [Required]<br>
     * Full description follows.</p>
     * 
     * @return the <i>display name</i> of this <code>Repository</code> to be displayed to end users
     */
//    public String getDisplayName()
//    {
//        try
//        {
//            return getProperty(OdmaTypes.PROPERTY_DISPLAYNAME).getString();
//        }
//        catch(OdmaInvalidDataTypeException oidte)
//        {
//            throw new OdmaRuntimeException("Invalid data type of system property",oidte);
//        }
//        catch(OdmaObjectNotFoundException oonfe)
//        {
//            throw new OdmaRuntimeException("Predefined system property missing",oonfe);
//        }
//    }

    /**
     * Sets the <i>display name</i> of this <code>Repository</code> to be displayed to end users.<br>
     * 
     * <p>Property <b>DisplayName</b> (opendma): <b>String</b><br>
     * [SingleValue] [Writable] [Required]<br>
     * Full description follows.</p>
     * 
     * @throws OdmaAccessDeniedException
     *             if this property can not be set by the current user
     */
//    public void setDisplayName(String value) throws OdmaAccessDeniedException
//    {
//        try
//        {
//            getProperty(OdmaTypes.PROPERTY_DISPLAYNAME).setValue(value);
//        }
//        catch(OdmaInvalidDataTypeException oidte)
//        {
//            throw new OdmaRuntimeException("Invalid data type of system property",oidte);
//        }
//        catch(OdmaObjectNotFoundException oonfe)
//        {
//            throw new OdmaRuntimeException("Predefined system property missing",oonfe);
//        }
//    }

    /**
     * Returns the <i>root</i> <code>Class</code> of the class hierarchy in this <code>Repository</code>.<br>
     * 
     * <p>Property <b>RootClass</b> (opendma): <b>Reference to Class (opendma)</b><br>
     * [SingleValue] [ReadOnly] [Required]<br>
     * Full description follows.</p>
     * 
     * @return the <i>root</i> <code>Class</code> of the class hierarchy in this <code>Repository</code>
     */
    public OdmaClass getRootClass()
    {
        try
        {
            return (OdmaClass)getProperty(OdmaTypes.PROPERTY_ROOTCLASS).getReference();
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
     * Returns the list of <code>Class</code>es that represent an <i>Aspect</i> and that do not inherit another aspect.<br>
     * 
     * <p>Property <b>RootAspects</b> (opendma): <b>Reference to Class (opendma)</b><br>
     * [MultiValue] [ReadOnly] [Nullable]<br>
     * Full description follows.</p>
     * 
     * @return the list of <code>Class</code>es that represent an <i>Aspect</i> and that do not inherit another aspect
     */
    public OdmaClassEnumeration getRootAspects()
    {
        try
        {
            return (OdmaClassEnumeration)getProperty(OdmaTypes.PROPERTY_ROOTASPECTS).getReferenceEnumeration();
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
     * Returns the <i>root</i> <code>Folder</code> of a dedicated folder tree in this <code>Repository</code> (if any).<br>
     * 
     * <p>Property <b>RootFolder</b> (opendma): <b>Reference to Folder (opendma)</b><br>
     * [SingleValue] [ReadOnly] [Nullable]<br>
     * Full description follows.</p>
     * 
     * @return the <i>root</i> <code>Folder</code> of a dedicated folder tree in this <code>Repository</code> (if any)
     */
    public OdmaFolder getRootFolder()
    {
        try
        {
            return (OdmaFolder)getProperty(OdmaTypes.PROPERTY_ROOTFOLDER).getReference();
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

//----- OdmaVersionCollection

    // =============================================================================================
    // Object specific property access
    // =============================================================================================

    // CHECKTEMPLATE: the following code has most likely been copied from a class template. Make sure to keep this code up to date!
    // The following template code is available as OdmaVersionCollectionTemplate

    /**
     * Returns collection of all versions of the <code>Document</code>.<br>
     * 
     * <p>Property <b>Versions</b> (opendma): <b>Reference to Document (opendma)</b><br>
     * [MultiValue] [ReadOnly] [Required]<br>
     * Full description follows.</p>
     * 
     * @return collection of all versions of the <code>Document</code>
     */
    public OdmaDocumentEnumeration getVersions()
    {
        try
        {
            return (OdmaDocumentEnumeration)getProperty(OdmaTypes.PROPERTY_VERSIONS).getReferenceEnumeration();
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
     * Returns the latest version of this <code>Document</code>.<br>
     * 
     * <p>Property <b>Latest</b> (opendma): <b>Reference to Document (opendma)</b><br>
     * [SingleValue] [ReadOnly] [Required]<br>
     * Full description follows.</p>
     * 
     * @return the latest version of this <code>Document</code>
     */
    public OdmaDocument getLatest()
    {
        try
        {
            return (OdmaDocument)getProperty(OdmaTypes.PROPERTY_LATEST).getReference();
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
     * Returns the last released version of this <code>Document</code>.<br>
     * 
     * <p>Property <b>Released</b> (opendma): <b>Reference to Document (opendma)</b><br>
     * [SingleValue] [ReadOnly] [Required]<br>
     * Full description follows.</p>
     * 
     * @return the last released version of this <code>Document</code>
     */
    public OdmaDocument getReleased()
    {
        try
        {
            return (OdmaDocument)getProperty(OdmaTypes.PROPERTY_RELEASED).getReference();
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
     * Returns the version of this <code>Document</code> currently beeing worked on during a checkout. Only valid if and only if the corresponding <code>Document</code> is checked out..<br>
     * 
     * <p>Property <b>InProgress</b> (opendma): <b>Reference to Document (opendma)</b><br>
     * [SingleValue] [ReadOnly] [Required]<br>
     * Full description follows.</p>
     * 
     * @return the version of this <code>Document</code> currently beeing worked on during a checkout. Only valid if and only if the corresponding <code>Document</code> is checked out.
     */
    public OdmaDocument getInProgress()
    {
        try
        {
            return (OdmaDocument)getProperty(OdmaTypes.PROPERTY_INPROGRESS).getReference();
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
     * Returns the date when this <code>Document</code> has been created.<br>
     * 
     * <p>Property <b>CreatedAt</b> (opendma): <b>DateTime</b><br>
     * [SingleValue] [ReadOnly] [Required]<br>
     * Full description follows.</p>
     * 
     * @return the date when this <code>Document</code> has been created
     */
//    public Date getCreatedAt()
//    {
//        try
//        {
//            return getProperty(OdmaTypes.PROPERTY_CREATEDAT).getDateTime();
//        }
//        catch(OdmaInvalidDataTypeException oidte)
//        {
//            throw new OdmaRuntimeException("Invalid data type of system property",oidte);
//        }
//        catch(OdmaObjectNotFoundException oonfe)
//        {
//            throw new OdmaRuntimeException("Predefined system property missing",oonfe);
//        }
//    }

    /**
     * Returns the user who has created this <code>Document</code>.<br>
     * 
     * <p>Property <b>CreatedBy</b> (opendma): <b>String</b><br>
     * [SingleValue] [ReadOnly] [Required]<br>
     * Full description follows.</p>
     * 
     * @return the user who has created this <code>Document</code>
     */
//    public String getCreatedBy()
//    {
//        try
//        {
//            return getProperty(OdmaTypes.PROPERTY_CREATEDBY).getString();
//        }
//        catch(OdmaInvalidDataTypeException oidte)
//        {
//            throw new OdmaRuntimeException("Invalid data type of system property",oidte);
//        }
//        catch(OdmaObjectNotFoundException oonfe)
//        {
//            throw new OdmaRuntimeException("Predefined system property missing",oonfe);
//        }
//    }

}
