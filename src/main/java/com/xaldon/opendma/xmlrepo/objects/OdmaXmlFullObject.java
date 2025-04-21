package com.xaldon.opendma.xmlrepo.objects;

import java.util.Date;
import java.util.Map;

import org.opendma.api.OdmaAssociation;
import org.opendma.api.OdmaChoiceValue;
import org.opendma.api.OdmaClass;
import org.opendma.api.OdmaCommonNames;
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
import org.opendma.exceptions.OdmaAccessDeniedException;
import org.opendma.exceptions.OdmaInvalidDataTypeException;
import org.opendma.exceptions.OdmaPropertyNotFoundException;
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

    // ----- Object specific property access -------------------------------------------------------

    // CHECKTEMPLATE: the following code has most likely been copied from a class template. Make sure to keep this code up to date!
    // The following template code is available as OdmaAssociationTemplate

    /**
     * Returns the <i>name</i> of this <code>Association</code>.<br>
     * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_NAME).getString()</code>.
     * 
     * <p>Property <b>Name</b> (opendma): <b>String</b><br/>
     * [SingleValue] [Writable] [Required]<br/>
     * Full description follows.</p>
     * 
     * @return the <i>name</i> of this <code>Association</code>
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
     * Sets the <i>name</i> of this <code>Association</code>.<br>
     * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_NAME).setValue(value)</code>.
     * 
     * <p>Property <b>Name</b> (opendma): <b>String</b><br/>
     * [SingleValue] [Writable] [Required]<br/>
     * Full description follows.</p>
     * 
     * @param newValue
     *             The new value for the <i>name</i> of this <code>Association</code>
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
     * Returns the <code>Container</code> of this <code>Association</code> in which the containable is said to be contained.<br>
     * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_CONTAINER).getReference()</code>.
     * 
     * <p>Property <b>Container</b> (opendma): <b>Reference to Container (opendma)</b><br/>
     * [SingleValue] [Writable] [Required]<br/>
     * Full description follows.</p>
     * 
     * @return the <code>Container</code> of this <code>Association</code> in which the containable is said to be contained
     */
    public OdmaContainer getContainer() {
        try {
            return (OdmaContainer)getProperty(OdmaCommonNames.PROPERTY_CONTAINER).getReference();
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
     * Sets the <code>Container</code> of this <code>Association</code> in which the containable is said to be contained.<br>
     * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_CONTAINER).setValue(value)</code>.
     * 
     * <p>Property <b>Container</b> (opendma): <b>Reference to Container (opendma)</b><br/>
     * [SingleValue] [Writable] [Required]<br/>
     * Full description follows.</p>
     * 
     * @param newValue
     *             The new value for the <code>Container</code> of this <code>Association</code> in which the containable is said to be contained
     * 
     * @throws OdmaAccessDeniedException
     *             If this OdmaProperty is read-only or cannot be set by the current user
     */
    public void setContainer(OdmaContainer newValue) throws OdmaAccessDeniedException {
        try {
            getProperty(OdmaCommonNames.PROPERTY_CONTAINER).setValue(newValue);
        }
        catch(OdmaInvalidDataTypeException oidte) {
            throw new OdmaRuntimeException("Invalid data type of system property",oidte);
        }
        catch(OdmaPropertyNotFoundException oonfe) {
            throw new OdmaRuntimeException("Predefined system property missing",oonfe);
        }
    }

    /**
     * Returns the <code>Containable</code> of this <code>Association</code> which is said to be contained in the container.<br>
     * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_CONTAINABLE).getReference()</code>.
     * 
     * <p>Property <b>Containable</b> (opendma): <b>Reference to Containable (opendma)</b><br/>
     * [SingleValue] [Writable] [Required]<br/>
     * Full description follows.</p>
     * 
     * @return the <code>Containable</code> of this <code>Association</code> which is said to be contained in the container
     */
    public OdmaContainable getContainable() {
        try {
            return (OdmaContainable)getProperty(OdmaCommonNames.PROPERTY_CONTAINABLE).getReference();
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
     * Sets the <code>Containable</code> of this <code>Association</code> which is said to be contained in the container.<br>
     * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_CONTAINABLE).setValue(value)</code>.
     * 
     * <p>Property <b>Containable</b> (opendma): <b>Reference to Containable (opendma)</b><br/>
     * [SingleValue] [Writable] [Required]<br/>
     * Full description follows.</p>
     * 
     * @param newValue
     *             The new value for the <code>Containable</code> of this <code>Association</code> which is said to be contained in the container
     * 
     * @throws OdmaAccessDeniedException
     *             If this OdmaProperty is read-only or cannot be set by the current user
     */
    public void setContainable(OdmaContainable newValue) throws OdmaAccessDeniedException {
        try {
            getProperty(OdmaCommonNames.PROPERTY_CONTAINABLE).setValue(newValue);
        }
        catch(OdmaInvalidDataTypeException oidte) {
            throw new OdmaRuntimeException("Invalid data type of system property",oidte);
        }
        catch(OdmaPropertyNotFoundException oonfe) {
            throw new OdmaRuntimeException("Predefined system property missing",oonfe);
        }
    }

    /**
     * Returns the date when this <code>Association</code> has been created.<br>
     * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_CREATEDAT).getDateTime()</code>.
     * 
     * <p>Property <b>CreatedAt</b> (opendma): <b>DateTime</b><br/>
     * [SingleValue] [ReadOnly] [Required]<br/>
     * Full description follows.</p>
     * 
     * @return the date when this <code>Association</code> has been created
     */
    public Date getCreatedAt() {
        try {
            return getProperty(OdmaCommonNames.PROPERTY_CREATEDAT).getDateTime();
        }
        catch(OdmaInvalidDataTypeException oidte) {
            throw new OdmaRuntimeException("Invalid data type of system property",oidte);
        }
        catch(OdmaPropertyNotFoundException oonfe) {
            throw new OdmaRuntimeException("Predefined system property missing",oonfe);
        }
    }

    /**
     * Returns the user who has created this <code>Association</code>.<br>
     * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_CREATEDBY).getString()</code>.
     * 
     * <p>Property <b>CreatedBy</b> (opendma): <b>String</b><br/>
     * [SingleValue] [ReadOnly] [Required]<br/>
     * Full description follows.</p>
     * 
     * @return the user who has created this <code>Association</code>
     */
    public String getCreatedBy() {
        try {
            return getProperty(OdmaCommonNames.PROPERTY_CREATEDBY).getString();
        }
        catch(OdmaInvalidDataTypeException oidte) {
            throw new OdmaRuntimeException("Invalid data type of system property",oidte);
        }
        catch(OdmaPropertyNotFoundException oonfe) {
            throw new OdmaRuntimeException("Predefined system property missing",oonfe);
        }
    }

    /**
     * Returns the date when this <code>Association</code> has been modified the last time.<br>
     * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_LASTMODIFIEDAT).getDateTime()</code>.
     * 
     * <p>Property <b>LastModifiedAt</b> (opendma): <b>DateTime</b><br/>
     * [SingleValue] [ReadOnly] [Required]<br/>
     * Full description follows.</p>
     * 
     * @return the date when this <code>Association</code> has been modified the last time
     */
    public Date getLastModifiedAt() {
        try {
            return getProperty(OdmaCommonNames.PROPERTY_LASTMODIFIEDAT).getDateTime();
        }
        catch(OdmaInvalidDataTypeException oidte) {
            throw new OdmaRuntimeException("Invalid data type of system property",oidte);
        }
        catch(OdmaPropertyNotFoundException oonfe) {
            throw new OdmaRuntimeException("Predefined system property missing",oonfe);
        }
    }

    /**
     * Returns the user who has modified this <code>Association</code> the last time.<br>
     * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_LASTMODIFIEDBY).getString()</code>.
     * 
     * <p>Property <b>LastModifiedBy</b> (opendma): <b>String</b><br/>
     * [SingleValue] [ReadOnly] [Required]<br/>
     * Full description follows.</p>
     * 
     * @return the user who has modified this <code>Association</code> the last time
     */
    public String getLastModifiedBy() {
        try {
            return getProperty(OdmaCommonNames.PROPERTY_LASTMODIFIEDBY).getString();
        }
        catch(OdmaInvalidDataTypeException oidte) {
            throw new OdmaRuntimeException("Invalid data type of system property",oidte);
        }
        catch(OdmaPropertyNotFoundException oonfe) {
            throw new OdmaRuntimeException("Predefined system property missing",oonfe);
        }
    }

//----- OdmaChoiceValue

    // ----- Object specific property access -------------------------------------------------------

    // CHECKTEMPLATE: the following code has most likely been copied from a class template. Make sure to keep this code up to date!
    // The following template code is available as OdmaChoiceValueTemplate

    /**
     * Returns the <i>display name</i> of this Choice to be displayed to end users.<br>
     * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_DISPLAYNAME).getString()</code>.
     * 
     * <p>Property <b>DisplayName</b> (opendma): <b>String</b><br/>
     * [SingleValue] [Writable] [Required]<br/>
     * Full description follows.</p>
     * 
     * @return the <i>display name</i> of this Choice to be displayed to end users
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
     * Sets the <i>display name</i> of this Choice to be displayed to end users.<br>
     * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_DISPLAYNAME).setValue(value)</code>.
     * 
     * <p>Property <b>DisplayName</b> (opendma): <b>String</b><br/>
     * [SingleValue] [Writable] [Required]<br/>
     * Full description follows.</p>
     * 
     * @param newValue
     *             The new value for the <i>display name</i> of this Choice to be displayed to end users
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
     * Returns the String value of this choice or null, if the property info this choice is assigned to is not of data type String.<br>
     * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_STRINGVALUE).getString()</code>.
     * 
     * <p>Property <b>StringValue</b> (opendma): <b>String</b><br/>
     * [SingleValue] [Writable] [NotRequired]<br/>
     * Full description follows.</p>
     * 
     * @return the String value of this choice or null, if the property info this choice is assigned to is not of data type String
     */
    public String getStringValue() {
        try {
            return getProperty(OdmaCommonNames.PROPERTY_STRINGVALUE).getString();
        }
        catch(OdmaInvalidDataTypeException oidte) {
            throw new OdmaRuntimeException("Invalid data type of system property",oidte);
        }
        catch(OdmaPropertyNotFoundException oonfe) {
            throw new OdmaRuntimeException("Predefined system property missing",oonfe);
        }
    }

    /**
     * Sets the String value of this choice or null, if the property info this choice is assigned to is not of data type String.<br>
     * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_STRINGVALUE).setValue(value)</code>.
     * 
     * <p>Property <b>StringValue</b> (opendma): <b>String</b><br/>
     * [SingleValue] [Writable] [NotRequired]<br/>
     * Full description follows.</p>
     * 
     * @param newValue
     *             The new value for the String value of this choice or null, if the property info this choice is assigned to is not of data type String
     * 
     * @throws OdmaAccessDeniedException
     *             If this OdmaProperty is read-only or cannot be set by the current user
     */
    public void setStringValue(String newValue) throws OdmaAccessDeniedException {
        try {
            getProperty(OdmaCommonNames.PROPERTY_STRINGVALUE).setValue(newValue);
        }
        catch(OdmaInvalidDataTypeException oidte) {
            throw new OdmaRuntimeException("Invalid data type of system property",oidte);
        }
        catch(OdmaPropertyNotFoundException oonfe) {
            throw new OdmaRuntimeException("Predefined system property missing",oonfe);
        }
    }

    /**
     * Returns the Integer value of this choice or null, if the property info this choice is assigned to is not of data type Integer.<br>
     * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_INTEGERVALUE).getString()</code>.
     * 
     * <p>Property <b>IntegerValue</b> (opendma): <b>String</b><br/>
     * [SingleValue] [Writable] [NotRequired]<br/>
     * Full description follows.</p>
     * 
     * @return the Integer value of this choice or null, if the property info this choice is assigned to is not of data type Integer
     */
    public String getIntegerValue() {
        try {
            return getProperty(OdmaCommonNames.PROPERTY_INTEGERVALUE).getString();
        }
        catch(OdmaInvalidDataTypeException oidte) {
            throw new OdmaRuntimeException("Invalid data type of system property",oidte);
        }
        catch(OdmaPropertyNotFoundException oonfe) {
            throw new OdmaRuntimeException("Predefined system property missing",oonfe);
        }
    }

    /**
     * Sets the Integer value of this choice or null, if the property info this choice is assigned to is not of data type Integer.<br>
     * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_INTEGERVALUE).setValue(value)</code>.
     * 
     * <p>Property <b>IntegerValue</b> (opendma): <b>String</b><br/>
     * [SingleValue] [Writable] [NotRequired]<br/>
     * Full description follows.</p>
     * 
     * @param newValue
     *             The new value for the Integer value of this choice or null, if the property info this choice is assigned to is not of data type Integer
     * 
     * @throws OdmaAccessDeniedException
     *             If this OdmaProperty is read-only or cannot be set by the current user
     */
    public void setIntegerValue(String newValue) throws OdmaAccessDeniedException {
        try {
            getProperty(OdmaCommonNames.PROPERTY_INTEGERVALUE).setValue(newValue);
        }
        catch(OdmaInvalidDataTypeException oidte) {
            throw new OdmaRuntimeException("Invalid data type of system property",oidte);
        }
        catch(OdmaPropertyNotFoundException oonfe) {
            throw new OdmaRuntimeException("Predefined system property missing",oonfe);
        }
    }

    /**
     * Returns the Short value of this choice or null, if the property info this choice is assigned to is not of data type Short.<br>
     * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_SHORTVALUE).getString()</code>.
     * 
     * <p>Property <b>ShortValue</b> (opendma): <b>String</b><br/>
     * [SingleValue] [Writable] [NotRequired]<br/>
     * Full description follows.</p>
     * 
     * @return the Short value of this choice or null, if the property info this choice is assigned to is not of data type Short
     */
    public String getShortValue() {
        try {
            return getProperty(OdmaCommonNames.PROPERTY_SHORTVALUE).getString();
        }
        catch(OdmaInvalidDataTypeException oidte) {
            throw new OdmaRuntimeException("Invalid data type of system property",oidte);
        }
        catch(OdmaPropertyNotFoundException oonfe) {
            throw new OdmaRuntimeException("Predefined system property missing",oonfe);
        }
    }

    /**
     * Sets the Short value of this choice or null, if the property info this choice is assigned to is not of data type Short.<br>
     * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_SHORTVALUE).setValue(value)</code>.
     * 
     * <p>Property <b>ShortValue</b> (opendma): <b>String</b><br/>
     * [SingleValue] [Writable] [NotRequired]<br/>
     * Full description follows.</p>
     * 
     * @param newValue
     *             The new value for the Short value of this choice or null, if the property info this choice is assigned to is not of data type Short
     * 
     * @throws OdmaAccessDeniedException
     *             If this OdmaProperty is read-only or cannot be set by the current user
     */
    public void setShortValue(String newValue) throws OdmaAccessDeniedException {
        try {
            getProperty(OdmaCommonNames.PROPERTY_SHORTVALUE).setValue(newValue);
        }
        catch(OdmaInvalidDataTypeException oidte) {
            throw new OdmaRuntimeException("Invalid data type of system property",oidte);
        }
        catch(OdmaPropertyNotFoundException oonfe) {
            throw new OdmaRuntimeException("Predefined system property missing",oonfe);
        }
    }

    /**
     * Returns the Long value of this choice or null, if the property info this choice is assigned to is not of data type Long.<br>
     * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_LONGVALUE).getString()</code>.
     * 
     * <p>Property <b>LongValue</b> (opendma): <b>String</b><br/>
     * [SingleValue] [Writable] [NotRequired]<br/>
     * Full description follows.</p>
     * 
     * @return the Long value of this choice or null, if the property info this choice is assigned to is not of data type Long
     */
    public String getLongValue() {
        try {
            return getProperty(OdmaCommonNames.PROPERTY_LONGVALUE).getString();
        }
        catch(OdmaInvalidDataTypeException oidte) {
            throw new OdmaRuntimeException("Invalid data type of system property",oidte);
        }
        catch(OdmaPropertyNotFoundException oonfe) {
            throw new OdmaRuntimeException("Predefined system property missing",oonfe);
        }
    }

    /**
     * Sets the Long value of this choice or null, if the property info this choice is assigned to is not of data type Long.<br>
     * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_LONGVALUE).setValue(value)</code>.
     * 
     * <p>Property <b>LongValue</b> (opendma): <b>String</b><br/>
     * [SingleValue] [Writable] [NotRequired]<br/>
     * Full description follows.</p>
     * 
     * @param newValue
     *             The new value for the Long value of this choice or null, if the property info this choice is assigned to is not of data type Long
     * 
     * @throws OdmaAccessDeniedException
     *             If this OdmaProperty is read-only or cannot be set by the current user
     */
    public void setLongValue(String newValue) throws OdmaAccessDeniedException {
        try {
            getProperty(OdmaCommonNames.PROPERTY_LONGVALUE).setValue(newValue);
        }
        catch(OdmaInvalidDataTypeException oidte) {
            throw new OdmaRuntimeException("Invalid data type of system property",oidte);
        }
        catch(OdmaPropertyNotFoundException oonfe) {
            throw new OdmaRuntimeException("Predefined system property missing",oonfe);
        }
    }

    /**
     * Returns the Float value of this choice or null, if the property info this choice is assigned to is not of data type Float.<br>
     * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_FLOATVALUE).getString()</code>.
     * 
     * <p>Property <b>FloatValue</b> (opendma): <b>String</b><br/>
     * [SingleValue] [Writable] [NotRequired]<br/>
     * Full description follows.</p>
     * 
     * @return the Float value of this choice or null, if the property info this choice is assigned to is not of data type Float
     */
    public String getFloatValue() {
        try {
            return getProperty(OdmaCommonNames.PROPERTY_FLOATVALUE).getString();
        }
        catch(OdmaInvalidDataTypeException oidte) {
            throw new OdmaRuntimeException("Invalid data type of system property",oidte);
        }
        catch(OdmaPropertyNotFoundException oonfe) {
            throw new OdmaRuntimeException("Predefined system property missing",oonfe);
        }
    }

    /**
     * Sets the Float value of this choice or null, if the property info this choice is assigned to is not of data type Float.<br>
     * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_FLOATVALUE).setValue(value)</code>.
     * 
     * <p>Property <b>FloatValue</b> (opendma): <b>String</b><br/>
     * [SingleValue] [Writable] [NotRequired]<br/>
     * Full description follows.</p>
     * 
     * @param newValue
     *             The new value for the Float value of this choice or null, if the property info this choice is assigned to is not of data type Float
     * 
     * @throws OdmaAccessDeniedException
     *             If this OdmaProperty is read-only or cannot be set by the current user
     */
    public void setFloatValue(String newValue) throws OdmaAccessDeniedException {
        try {
            getProperty(OdmaCommonNames.PROPERTY_FLOATVALUE).setValue(newValue);
        }
        catch(OdmaInvalidDataTypeException oidte) {
            throw new OdmaRuntimeException("Invalid data type of system property",oidte);
        }
        catch(OdmaPropertyNotFoundException oonfe) {
            throw new OdmaRuntimeException("Predefined system property missing",oonfe);
        }
    }

    /**
     * Returns the Double value of this choice or null, if the property info this choice is assigned to is not of data type Double.<br>
     * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_DOUBLEVALUE).getString()</code>.
     * 
     * <p>Property <b>DoubleValue</b> (opendma): <b>String</b><br/>
     * [SingleValue] [Writable] [NotRequired]<br/>
     * Full description follows.</p>
     * 
     * @return the Double value of this choice or null, if the property info this choice is assigned to is not of data type Double
     */
    public String getDoubleValue() {
        try {
            return getProperty(OdmaCommonNames.PROPERTY_DOUBLEVALUE).getString();
        }
        catch(OdmaInvalidDataTypeException oidte) {
            throw new OdmaRuntimeException("Invalid data type of system property",oidte);
        }
        catch(OdmaPropertyNotFoundException oonfe) {
            throw new OdmaRuntimeException("Predefined system property missing",oonfe);
        }
    }

    /**
     * Sets the Double value of this choice or null, if the property info this choice is assigned to is not of data type Double.<br>
     * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_DOUBLEVALUE).setValue(value)</code>.
     * 
     * <p>Property <b>DoubleValue</b> (opendma): <b>String</b><br/>
     * [SingleValue] [Writable] [NotRequired]<br/>
     * Full description follows.</p>
     * 
     * @param newValue
     *             The new value for the Double value of this choice or null, if the property info this choice is assigned to is not of data type Double
     * 
     * @throws OdmaAccessDeniedException
     *             If this OdmaProperty is read-only or cannot be set by the current user
     */
    public void setDoubleValue(String newValue) throws OdmaAccessDeniedException {
        try {
            getProperty(OdmaCommonNames.PROPERTY_DOUBLEVALUE).setValue(newValue);
        }
        catch(OdmaInvalidDataTypeException oidte) {
            throw new OdmaRuntimeException("Invalid data type of system property",oidte);
        }
        catch(OdmaPropertyNotFoundException oonfe) {
            throw new OdmaRuntimeException("Predefined system property missing",oonfe);
        }
    }

    /**
     * Returns the Boolean value of this choice or null, if the property info this choice is assigned to is not of data type Boolean.<br>
     * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_BOOLEANVALUE).getString()</code>.
     * 
     * <p>Property <b>BooleanValue</b> (opendma): <b>String</b><br/>
     * [SingleValue] [Writable] [NotRequired]<br/>
     * Full description follows.</p>
     * 
     * @return the Boolean value of this choice or null, if the property info this choice is assigned to is not of data type Boolean
     */
    public String getBooleanValue() {
        try {
            return getProperty(OdmaCommonNames.PROPERTY_BOOLEANVALUE).getString();
        }
        catch(OdmaInvalidDataTypeException oidte) {
            throw new OdmaRuntimeException("Invalid data type of system property",oidte);
        }
        catch(OdmaPropertyNotFoundException oonfe) {
            throw new OdmaRuntimeException("Predefined system property missing",oonfe);
        }
    }

    /**
     * Sets the Boolean value of this choice or null, if the property info this choice is assigned to is not of data type Boolean.<br>
     * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_BOOLEANVALUE).setValue(value)</code>.
     * 
     * <p>Property <b>BooleanValue</b> (opendma): <b>String</b><br/>
     * [SingleValue] [Writable] [NotRequired]<br/>
     * Full description follows.</p>
     * 
     * @param newValue
     *             The new value for the Boolean value of this choice or null, if the property info this choice is assigned to is not of data type Boolean
     * 
     * @throws OdmaAccessDeniedException
     *             If this OdmaProperty is read-only or cannot be set by the current user
     */
    public void setBooleanValue(String newValue) throws OdmaAccessDeniedException {
        try {
            getProperty(OdmaCommonNames.PROPERTY_BOOLEANVALUE).setValue(newValue);
        }
        catch(OdmaInvalidDataTypeException oidte) {
            throw new OdmaRuntimeException("Invalid data type of system property",oidte);
        }
        catch(OdmaPropertyNotFoundException oonfe) {
            throw new OdmaRuntimeException("Predefined system property missing",oonfe);
        }
    }

    /**
     * Returns the DateTime value of this choice or null, if the property info this choice is assigned to is not of data type DateTime.<br>
     * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_DATETIMEVALUE).getString()</code>.
     * 
     * <p>Property <b>DateTimeValue</b> (opendma): <b>String</b><br/>
     * [SingleValue] [Writable] [NotRequired]<br/>
     * Full description follows.</p>
     * 
     * @return the DateTime value of this choice or null, if the property info this choice is assigned to is not of data type DateTime
     */
    public String getDateTimeValue() {
        try {
            return getProperty(OdmaCommonNames.PROPERTY_DATETIMEVALUE).getString();
        }
        catch(OdmaInvalidDataTypeException oidte) {
            throw new OdmaRuntimeException("Invalid data type of system property",oidte);
        }
        catch(OdmaPropertyNotFoundException oonfe) {
            throw new OdmaRuntimeException("Predefined system property missing",oonfe);
        }
    }

    /**
     * Sets the DateTime value of this choice or null, if the property info this choice is assigned to is not of data type DateTime.<br>
     * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_DATETIMEVALUE).setValue(value)</code>.
     * 
     * <p>Property <b>DateTimeValue</b> (opendma): <b>String</b><br/>
     * [SingleValue] [Writable] [NotRequired]<br/>
     * Full description follows.</p>
     * 
     * @param newValue
     *             The new value for the DateTime value of this choice or null, if the property info this choice is assigned to is not of data type DateTime
     * 
     * @throws OdmaAccessDeniedException
     *             If this OdmaProperty is read-only or cannot be set by the current user
     */
    public void setDateTimeValue(String newValue) throws OdmaAccessDeniedException {
        try {
            getProperty(OdmaCommonNames.PROPERTY_DATETIMEVALUE).setValue(newValue);
        }
        catch(OdmaInvalidDataTypeException oidte) {
            throw new OdmaRuntimeException("Invalid data type of system property",oidte);
        }
        catch(OdmaPropertyNotFoundException oonfe) {
            throw new OdmaRuntimeException("Predefined system property missing",oonfe);
        }
    }

    /**
     * Returns the BLOB value of this choice or null, if the property info this choice is assigned to is not of data type BLOB.<br>
     * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_BLOBVALUE).getString()</code>.
     * 
     * <p>Property <b>BLOBValue</b> (opendma): <b>String</b><br/>
     * [SingleValue] [Writable] [NotRequired]<br/>
     * Full description follows.</p>
     * 
     * @return the BLOB value of this choice or null, if the property info this choice is assigned to is not of data type BLOB
     */
    public String getBLOBValue() {
        try {
            return getProperty(OdmaCommonNames.PROPERTY_BLOBVALUE).getString();
        }
        catch(OdmaInvalidDataTypeException oidte) {
            throw new OdmaRuntimeException("Invalid data type of system property",oidte);
        }
        catch(OdmaPropertyNotFoundException oonfe) {
            throw new OdmaRuntimeException("Predefined system property missing",oonfe);
        }
    }

    /**
     * Sets the BLOB value of this choice or null, if the property info this choice is assigned to is not of data type BLOB.<br>
     * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_BLOBVALUE).setValue(value)</code>.
     * 
     * <p>Property <b>BLOBValue</b> (opendma): <b>String</b><br/>
     * [SingleValue] [Writable] [NotRequired]<br/>
     * Full description follows.</p>
     * 
     * @param newValue
     *             The new value for the BLOB value of this choice or null, if the property info this choice is assigned to is not of data type BLOB
     * 
     * @throws OdmaAccessDeniedException
     *             If this OdmaProperty is read-only or cannot be set by the current user
     */
    public void setBLOBValue(String newValue) throws OdmaAccessDeniedException {
        try {
            getProperty(OdmaCommonNames.PROPERTY_BLOBVALUE).setValue(newValue);
        }
        catch(OdmaInvalidDataTypeException oidte) {
            throw new OdmaRuntimeException("Invalid data type of system property",oidte);
        }
        catch(OdmaPropertyNotFoundException oonfe) {
            throw new OdmaRuntimeException("Predefined system property missing",oonfe);
        }
    }

    /**
     * Returns the Reference value of this choice or null, if the property info this choice is assigned to is not of data type Reference.<br>
     * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_REFERENCEVALUE).getString()</code>.
     * 
     * <p>Property <b>ReferenceValue</b> (opendma): <b>String</b><br/>
     * [SingleValue] [Writable] [NotRequired]<br/>
     * Full description follows.</p>
     * 
     * @return the Reference value of this choice or null, if the property info this choice is assigned to is not of data type Reference
     */
    public String getReferenceValue() {
        try {
            return getProperty(OdmaCommonNames.PROPERTY_REFERENCEVALUE).getString();
        }
        catch(OdmaInvalidDataTypeException oidte) {
            throw new OdmaRuntimeException("Invalid data type of system property",oidte);
        }
        catch(OdmaPropertyNotFoundException oonfe) {
            throw new OdmaRuntimeException("Predefined system property missing",oonfe);
        }
    }

    /**
     * Sets the Reference value of this choice or null, if the property info this choice is assigned to is not of data type Reference.<br>
     * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_REFERENCEVALUE).setValue(value)</code>.
     * 
     * <p>Property <b>ReferenceValue</b> (opendma): <b>String</b><br/>
     * [SingleValue] [Writable] [NotRequired]<br/>
     * Full description follows.</p>
     * 
     * @param newValue
     *             The new value for the Reference value of this choice or null, if the property info this choice is assigned to is not of data type Reference
     * 
     * @throws OdmaAccessDeniedException
     *             If this OdmaProperty is read-only or cannot be set by the current user
     */
    public void setReferenceValue(String newValue) throws OdmaAccessDeniedException {
        try {
            getProperty(OdmaCommonNames.PROPERTY_REFERENCEVALUE).setValue(newValue);
        }
        catch(OdmaInvalidDataTypeException oidte) {
            throw new OdmaRuntimeException("Invalid data type of system property",oidte);
        }
        catch(OdmaPropertyNotFoundException oonfe) {
            throw new OdmaRuntimeException("Predefined system property missing",oonfe);
        }
    }

//----- OdmaContainable

    // ----- Object specific property access -------------------------------------------------------

    // CHECKTEMPLATE: the following code has most likely been copied from a class template. Make sure to keep this code up to date!
    // The following template code is available as OdmaContainableTemplate

    /**
     * Returns the collection of <code>Container</code>s this <code>Containable</code> is contained in.<br>
     * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_CONTAINEDIN).getReferenceIterable()</code>.
     * 
     * <p>Property <b>ContainedIn</b> (opendma): <b>Reference to Container (opendma)</b><br/>
     * [MultiValue] [ReadOnly] [NotRequired]<br/>
     * Full description follows.</p>
     * 
     * @return the collection of <code>Container</code>s this <code>Containable</code> is contained in
     */
     @SuppressWarnings("unchecked")
    public Iterable<OdmaContainer> getContainedIn() {
        try {
            return (Iterable<OdmaContainer>)getProperty(OdmaCommonNames.PROPERTY_CONTAINEDIN).getReferenceIterable();
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
     * Returns the collection of <code>Association</code>s that bind this <code>Containable</code> in the <code>Container</code>s.<br>
     * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_CONTAINEDINASSOCIATIONS).getReferenceIterable()</code>.
     * 
     * <p>Property <b>ContainedInAssociations</b> (opendma): <b>Reference to Association (opendma)</b><br/>
     * [MultiValue] [ReadOnly] [NotRequired]<br/>
     * Full description follows.</p>
     * 
     * @return the collection of <code>Association</code>s that bind this <code>Containable</code> in the <code>Container</code>s
     */
     @SuppressWarnings("unchecked")
    public Iterable<OdmaAssociation> getContainedInAssociations() {
        try {
            return (Iterable<OdmaAssociation>)getProperty(OdmaCommonNames.PROPERTY_CONTAINEDINASSOCIATIONS).getReferenceIterable();
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

//----- OdmaContainer

     // ----- Object specific property access -------------------------------------------------------

     // CHECKTEMPLATE: the following code has most likely been copied from a class template. Make sure to keep this code up to date!
     // The following template code is available as OdmaContainerTemplate

     /**
      * Returns the <i>title</i> of this <code>Container</code>.<br>
      * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_TITLE).getString()</code>.
      * 
      * <p>Property <b>Title</b> (opendma): <b>String</b><br/>
      * [SingleValue] [Writable] [NotRequired]<br/>
      * Full description follows.</p>
      * 
      * @return the <i>title</i> of this <code>Container</code>
      */
     public String getTitle() {
         try {
             return getProperty(OdmaCommonNames.PROPERTY_TITLE).getString();
         }
         catch(OdmaInvalidDataTypeException oidte) {
             throw new OdmaRuntimeException("Invalid data type of system property",oidte);
         }
         catch(OdmaPropertyNotFoundException oonfe) {
             throw new OdmaRuntimeException("Predefined system property missing",oonfe);
         }
     }

     /**
      * Sets the <i>title</i> of this <code>Container</code>.<br>
      * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_TITLE).setValue(value)</code>.
      * 
      * <p>Property <b>Title</b> (opendma): <b>String</b><br/>
      * [SingleValue] [Writable] [NotRequired]<br/>
      * Full description follows.</p>
      * 
      * @param newValue
      *             The new value for the <i>title</i> of this <code>Container</code>
      * 
      * @throws OdmaAccessDeniedException
      *             If this OdmaProperty is read-only or cannot be set by the current user
      */
     public void setTitle(String newValue) throws OdmaAccessDeniedException {
         try {
             getProperty(OdmaCommonNames.PROPERTY_TITLE).setValue(newValue);
         }
         catch(OdmaInvalidDataTypeException oidte) {
             throw new OdmaRuntimeException("Invalid data type of system property",oidte);
         }
         catch(OdmaPropertyNotFoundException oonfe) {
             throw new OdmaRuntimeException("Predefined system property missing",oonfe);
         }
     }

     /**
      * Returns the collection of all <code>Containable</code> objects that are contained in this <code>Container</code>.<br>
      * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_CONTAINEES).getReferenceIterable()</code>.
      * 
      * <p>Property <b>Containees</b> (opendma): <b>Reference to Containable (opendma)</b><br/>
      * [MultiValue] [ReadOnly] [Required]<br/>
      * Full description follows.</p>
      * 
      * @return the collection of all <code>Containable</code> objects that are contained in this <code>Container</code>
      */
      @SuppressWarnings("unchecked")
     public Iterable<OdmaContainable> getContainees() {
         try {
             return (Iterable<OdmaContainable>)getProperty(OdmaCommonNames.PROPERTY_CONTAINEES).getReferenceIterable();
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
      * Returns the collection of all <code>Association</code>s between this <code>Container</code> and its containees.<br>
      * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_ASSOCIATIONS).getReferenceIterable()</code>.
      * 
      * <p>Property <b>Associations</b> (opendma): <b>Reference to Association (opendma)</b><br/>
      * [MultiValue] [ReadOnly] [NotRequired]<br/>
      * Full description follows.</p>
      * 
      * @return the collection of all <code>Association</code>s between this <code>Container</code> and its containees
      */
      @SuppressWarnings("unchecked")
     public Iterable<OdmaAssociation> getAssociations() {
         try {
             return (Iterable<OdmaAssociation>)getProperty(OdmaCommonNames.PROPERTY_ASSOCIATIONS).getReferenceIterable();
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
      * Returns the date when this <code>Container</code> has been created.<br>
      * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_CREATEDAT).getDateTime()</code>.
      * 
      * <p>Property <b>CreatedAt</b> (opendma): <b>DateTime</b><br/>
      * [SingleValue] [ReadOnly] [Required]<br/>
      * Full description follows.</p>
      * 
      * @return the date when this <code>Container</code> has been created
      */
//     public Date getCreatedAt() {
//         try {
//             return getProperty(OdmaCommonNames.PROPERTY_CREATEDAT).getDateTime();
//         }
//         catch(OdmaInvalidDataTypeException oidte) {
//             throw new OdmaRuntimeException("Invalid data type of system property",oidte);
//         }
//         catch(OdmaPropertyNotFoundException oonfe) {
//             throw new OdmaRuntimeException("Predefined system property missing",oonfe);
//         }
//     }

     /**
      * Returns the user who has created this <code>Container</code>.<br>
      * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_CREATEDBY).getString()</code>.
      * 
      * <p>Property <b>CreatedBy</b> (opendma): <b>String</b><br/>
      * [SingleValue] [ReadOnly] [Required]<br/>
      * Full description follows.</p>
      * 
      * @return the user who has created this <code>Container</code>
      */
//     public String getCreatedBy() {
//         try {
//             return getProperty(OdmaCommonNames.PROPERTY_CREATEDBY).getString();
//         }
//         catch(OdmaInvalidDataTypeException oidte) {
//             throw new OdmaRuntimeException("Invalid data type of system property",oidte);
//         }
//         catch(OdmaPropertyNotFoundException oonfe) {
//             throw new OdmaRuntimeException("Predefined system property missing",oonfe);
//         }
//     }

     /**
      * Returns the date when this <code>Container</code> has been modified the last time.<br>
      * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_LASTMODIFIEDAT).getDateTime()</code>.
      * 
      * <p>Property <b>LastModifiedAt</b> (opendma): <b>DateTime</b><br/>
      * [SingleValue] [ReadOnly] [Required]<br/>
      * Full description follows.</p>
      * 
      * @return the date when this <code>Container</code> has been modified the last time
      */
//     public Date getLastModifiedAt() {
//         try {
//             return getProperty(OdmaCommonNames.PROPERTY_LASTMODIFIEDAT).getDateTime();
//         }
//         catch(OdmaInvalidDataTypeException oidte) {
//             throw new OdmaRuntimeException("Invalid data type of system property",oidte);
//         }
//         catch(OdmaPropertyNotFoundException oonfe) {
//             throw new OdmaRuntimeException("Predefined system property missing",oonfe);
//         }
//     }

     /**
      * Returns the user who has modified this <code>Container</code> the last time.<br>
      * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_LASTMODIFIEDBY).getString()</code>.
      * 
      * <p>Property <b>LastModifiedBy</b> (opendma): <b>String</b><br/>
      * [SingleValue] [ReadOnly] [Required]<br/>
      * Full description follows.</p>
      * 
      * @return the user who has modified this <code>Container</code> the last time
      */
//     public String getLastModifiedBy() {
//         try {
//             return getProperty(OdmaCommonNames.PROPERTY_LASTMODIFIEDBY).getString();
//         }
//         catch(OdmaInvalidDataTypeException oidte) {
//             throw new OdmaRuntimeException("Invalid data type of system property",oidte);
//         }
//         catch(OdmaPropertyNotFoundException oonfe) {
//             throw new OdmaRuntimeException("Predefined system property missing",oonfe);
//         }
//     }

//----- OdmaContentElement

     // ----- Object specific property access -------------------------------------------------------

     // CHECKTEMPLATE: the following code has most likely been copied from a class template. Make sure to keep this code up to date!
     // The following template code is available as OdmaContentElementTemplate

     /**
      * Returns the mime type describing how the <code>Content</code> of this <code>ContentElement</code> has to be interpreted.<br>
      * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_CONTENTTYPE).getString()</code>.
      * 
      * <p>Property <b>ContentType</b> (opendma): <b>String</b><br/>
      * [SingleValue] [Writable] [NotRequired]<br/>
      * Full description follows.</p>
      * 
      * @return the mime type describing how the <code>Content</code> of this <code>ContentElement</code> has to be interpreted
      */
     public String getContentType() {
         try {
             return getProperty(OdmaCommonNames.PROPERTY_CONTENTTYPE).getString();
         }
         catch(OdmaInvalidDataTypeException oidte) {
             throw new OdmaRuntimeException("Invalid data type of system property",oidte);
         }
         catch(OdmaPropertyNotFoundException oonfe) {
             throw new OdmaRuntimeException("Predefined system property missing",oonfe);
         }
     }

     /**
      * Sets the mime type describing how the <code>Content</code> of this <code>ContentElement</code> has to be interpreted.<br>
      * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_CONTENTTYPE).setValue(value)</code>.
      * 
      * <p>Property <b>ContentType</b> (opendma): <b>String</b><br/>
      * [SingleValue] [Writable] [NotRequired]<br/>
      * Full description follows.</p>
      * 
      * @param newValue
      *             The new value for the mime type describing how the <code>Content</code> of this <code>ContentElement</code> has to be interpreted
      * 
      * @throws OdmaAccessDeniedException
      *             If this OdmaProperty is read-only or cannot be set by the current user
      */
     public void setContentType(String newValue) throws OdmaAccessDeniedException {
         try {
             getProperty(OdmaCommonNames.PROPERTY_CONTENTTYPE).setValue(newValue);
         }
         catch(OdmaInvalidDataTypeException oidte) {
             throw new OdmaRuntimeException("Invalid data type of system property",oidte);
         }
         catch(OdmaPropertyNotFoundException oonfe) {
             throw new OdmaRuntimeException("Predefined system property missing",oonfe);
         }
     }

     /**
      * Returns the position of this element in the list of all content elements of the containing document.<br>
      * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_POSITION).getInteger()</code>.
      * 
      * <p>Property <b>Position</b> (opendma): <b>Integer</b><br/>
      * [SingleValue] [ReadOnly] [Required]<br/>
      * Full description follows.</p>
      * 
      * @return the position of this element in the list of all content elements of the containing document
      */
     public Integer getPosition() {
         try {
             return getProperty(OdmaCommonNames.PROPERTY_POSITION).getInteger();
         }
         catch(OdmaInvalidDataTypeException oidte) {
             throw new OdmaRuntimeException("Invalid data type of system property",oidte);
         }
         catch(OdmaPropertyNotFoundException oonfe) {
             throw new OdmaRuntimeException("Predefined system property missing",oonfe);
         }
     }

// OdmaDataContentElement

     // ----- Object specific property access -------------------------------------------------------

     // CHECKTEMPLATE: the following code has most likely been copied from a class template. Make sure to keep this code up to date!
     // The following template code is available as OdmaDataContentElementTemplate

     /**
      * Returns the binary content of this <code>ContentElement</code> as octets.<br>
      * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_CONTENT).getContent()</code>.
      * 
      * <p>Property <b>Content</b> (opendma): <b>Content</b><br/>
      * [SingleValue] [Writable] [NotRequired]<br/>
      * Full description follows.</p>
      * 
      * @return the binary content of this <code>ContentElement</code> as octets
      */
     public OdmaContent getContent() {
         try {
             return getProperty(OdmaCommonNames.PROPERTY_CONTENT).getContent();
         }
         catch(OdmaInvalidDataTypeException oidte) {
             throw new OdmaRuntimeException("Invalid data type of system property",oidte);
         }
         catch(OdmaPropertyNotFoundException oonfe) {
             throw new OdmaRuntimeException("Predefined system property missing",oonfe);
         }
     }

     /**
      * Sets the binary content of this <code>ContentElement</code> as octets.<br>
      * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_CONTENT).setValue(value)</code>.
      * 
      * <p>Property <b>Content</b> (opendma): <b>Content</b><br/>
      * [SingleValue] [Writable] [NotRequired]<br/>
      * Full description follows.</p>
      * 
      * @param newValue
      *             The new value for the binary content of this <code>ContentElement</code> as octets
      * 
      * @throws OdmaAccessDeniedException
      *             If this OdmaProperty is read-only or cannot be set by the current user
      */
     public void setContent(OdmaContent newValue) throws OdmaAccessDeniedException {
         try {
             getProperty(OdmaCommonNames.PROPERTY_CONTENT).setValue(newValue);
         }
         catch(OdmaInvalidDataTypeException oidte) {
             throw new OdmaRuntimeException("Invalid data type of system property",oidte);
         }
         catch(OdmaPropertyNotFoundException oonfe) {
             throw new OdmaRuntimeException("Predefined system property missing",oonfe);
         }
     }

     /**
      * Returns the number of octests the binary content of this <code>ContentElement</code> consists of.<br>
      * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_SIZE).getLong()</code>.
      * 
      * <p>Property <b>Size</b> (opendma): <b>Long</b><br/>
      * [SingleValue] [ReadOnly] [Required]<br/>
      * Full description follows.</p>
      * 
      * @return the number of octests the binary content of this <code>ContentElement</code> consists of
      */
     public Long getSize() {
         try {
             return getProperty(OdmaCommonNames.PROPERTY_SIZE).getLong();
         }
         catch(OdmaInvalidDataTypeException oidte) {
             throw new OdmaRuntimeException("Invalid data type of system property",oidte);
         }
         catch(OdmaPropertyNotFoundException oonfe) {
             throw new OdmaRuntimeException("Predefined system property missing",oonfe);
         }
     }

     /**
      * Returns the optional file name of this <code>ContentElement</code>.<br>
      * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_FILENAME).getString()</code>.
      * 
      * <p>Property <b>FileName</b> (opendma): <b>String</b><br/>
      * [SingleValue] [Writable] [NotRequired]<br/>
      * Full description follows.</p>
      * 
      * @return the optional file name of this <code>ContentElement</code>
      */
     public String getFileName() {
         try {
             return getProperty(OdmaCommonNames.PROPERTY_FILENAME).getString();
         }
         catch(OdmaInvalidDataTypeException oidte) {
             throw new OdmaRuntimeException("Invalid data type of system property",oidte);
         }
         catch(OdmaPropertyNotFoundException oonfe) {
             throw new OdmaRuntimeException("Predefined system property missing",oonfe);
         }
     }

     /**
      * Sets the optional file name of this <code>ContentElement</code>.<br>
      * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_FILENAME).setValue(value)</code>.
      * 
      * <p>Property <b>FileName</b> (opendma): <b>String</b><br/>
      * [SingleValue] [Writable] [NotRequired]<br/>
      * Full description follows.</p>
      * 
      * @param newValue
      *             The new value for the optional file name of this <code>ContentElement</code>
      * 
      * @throws OdmaAccessDeniedException
      *             If this OdmaProperty is read-only or cannot be set by the current user
      */
     public void setFileName(String newValue) throws OdmaAccessDeniedException {
         try {
             getProperty(OdmaCommonNames.PROPERTY_FILENAME).setValue(newValue);
         }
         catch(OdmaInvalidDataTypeException oidte) {
             throw new OdmaRuntimeException("Invalid data type of system property",oidte);
         }
         catch(OdmaPropertyNotFoundException oonfe) {
             throw new OdmaRuntimeException("Predefined system property missing",oonfe);
         }
     }

//----- OdmaDocument

     // ----- Object specific property access -------------------------------------------------------

     // CHECKTEMPLATE: the following code has most likely been copied from a class template. Make sure to keep this code up to date!
     // The following template code is available as OdmaDocumentTemplate

     /**
      * Returns the <i>title</i> of this <code>Document</code>.<br>
      * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_TITLE).getString()</code>.
      * 
      * <p>Property <b>Title</b> (opendma): <b>String</b><br/>
      * [SingleValue] [Writable] [NotRequired]<br/>
      * Full description follows.</p>
      * 
      * @return the <i>title</i> of this <code>Document</code>
      */
//     public String getTitle() {
//         try {
//             return getProperty(OdmaCommonNames.PROPERTY_TITLE).getString();
//         }
//         catch(OdmaInvalidDataTypeException oidte) {
//             throw new OdmaRuntimeException("Invalid data type of system property",oidte);
//         }
//         catch(OdmaPropertyNotFoundException oonfe) {
//             throw new OdmaRuntimeException("Predefined system property missing",oonfe);
//         }
//     }

     /**
      * Sets the <i>title</i> of this <code>Document</code>.<br>
      * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_TITLE).setValue(value)</code>.
      * 
      * <p>Property <b>Title</b> (opendma): <b>String</b><br/>
      * [SingleValue] [Writable] [NotRequired]<br/>
      * Full description follows.</p>
      * 
      * @param newValue
      *             The new value for the <i>title</i> of this <code>Document</code>
      * 
      * @throws OdmaAccessDeniedException
      *             If this OdmaProperty is read-only or cannot be set by the current user
      */
//     public void setTitle(String newValue) throws OdmaAccessDeniedException {
//         try {
//             getProperty(OdmaCommonNames.PROPERTY_TITLE).setValue(newValue);
//         }
//         catch(OdmaInvalidDataTypeException oidte) {
//             throw new OdmaRuntimeException("Invalid data type of system property",oidte);
//         }
//         catch(OdmaPropertyNotFoundException oonfe) {
//             throw new OdmaRuntimeException("Predefined system property missing",oonfe);
//         }
//     }

     /**
      * Returns the <i>version string</i> describing this <i>version</i> of this <code>Document</code> (e.g. 1.0, 1.1, 1.2, 2.0).<br>
      * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_VERSION).getString()</code>.
      * 
      * <p>Property <b>Version</b> (opendma): <b>String</b><br/>
      * [SingleValue] [ReadOnly] [NotRequired]<br/>
      * Full description follows.</p>
      * 
      * @return the <i>version string</i> describing this <i>version</i> of this <code>Document</code> (e.g. 1.0, 1.1, 1.2, 2.0)
      */
     public String getVersion() {
         try {
             return getProperty(OdmaCommonNames.PROPERTY_VERSION).getString();
         }
         catch(OdmaInvalidDataTypeException oidte) {
             throw new OdmaRuntimeException("Invalid data type of system property",oidte);
         }
         catch(OdmaPropertyNotFoundException oonfe) {
             throw new OdmaRuntimeException("Predefined system property missing",oonfe);
         }
     }

     /**
      * Returns reference to a <i>VersionCollection</i> object containing the collection of all <i>versions</i> of this <code>Document</code> along with other information.<br>
      * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_VERSIONCOLLECTION).getReference()</code>.
      * 
      * <p>Property <b>VersionCollection</b> (opendma): <b>Reference to VersionCollection (opendma)</b><br/>
      * [SingleValue] [ReadOnly] [NotRequired]<br/>
      * Full description follows.</p>
      * 
      * @return reference to a <i>VersionCollection</i> object containing the collection of all <i>versions</i> of this <code>Document</code> along with other information
      */
     public OdmaVersionCollection getVersionCollection() {
         try {
             return (OdmaVersionCollection)getProperty(OdmaCommonNames.PROPERTY_VERSIONCOLLECTION).getReference();
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
      * Returns the <i>unique object identifier</i> identifying this logical document independent from the specific version inside its <code>Repository</code>.<br>
      * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_VERSIONINDEPENDENTID).getId()</code>.
      * 
      * <p>Property <b>VersionIndependentId</b> (opendma): <b>String</b><br/>
      * [SingleValue] [ReadOnly] [Required]<br/>
      * Full description follows.</p>
      * 
      * @return the <i>unique object identifier</i> identifying this logical document independent from the specific version inside its <code>Repository</code>
      */
     public OdmaId getVersionIndependentId() {
         try {
             return getProperty(OdmaCommonNames.PROPERTY_VERSIONINDEPENDENTID).getId();
         }
         catch(OdmaInvalidDataTypeException oidte) {
             throw new OdmaRuntimeException("Invalid data type of system property",oidte);
         }
         catch(OdmaPropertyNotFoundException oonfe) {
             throw new OdmaRuntimeException("Predefined system property missing",oonfe);
         }
     }

     /**
      * Returns the <i>global unique object identifier</i> globally identifying this logical document independent from the specific version.<br>
      * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_VERSIONINDEPENDENTGUID).getGuid()</code>.
      * 
      * <p>Property <b>VersionIndependentGuid</b> (opendma): <b>String</b><br/>
      * [SingleValue] [ReadOnly] [Required]<br/>
      * Full description follows.</p>
      * 
      * @return the <i>global unique object identifier</i> globally identifying this logical document independent from the specific version
      */
     public OdmaGuid getVersionIndependentGuid() {
         try {
             return getProperty(OdmaCommonNames.PROPERTY_VERSIONINDEPENDENTGUID).getGuid();
         }
         catch(OdmaInvalidDataTypeException oidte) {
             throw new OdmaRuntimeException("Invalid data type of system property",oidte);
         }
         catch(OdmaPropertyNotFoundException oonfe) {
             throw new OdmaRuntimeException("Predefined system property missing",oonfe);
         }
     }

     /**
      * Returns the collection of all <code>ContentElement</code>s this <code>Document</code> consists of.<br>
      * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_CONTENTELEMENTS).getReferenceIterable()</code>.
      * 
      * <p>Property <b>ContentElements</b> (opendma): <b>Reference to ContentElement (opendma)</b><br/>
      * [MultiValue] [Writable] [NotRequired]<br/>
      * Full description follows.</p>
      * 
      * @return the collection of all <code>ContentElement</code>s this <code>Document</code> consists of
      */
      @SuppressWarnings("unchecked")
     public Iterable<OdmaContentElement> getContentElements() {
         try {
             return (Iterable<OdmaContentElement>)getProperty(OdmaCommonNames.PROPERTY_CONTENTELEMENTS).getReferenceIterable();
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
      * Returns the combined mime type that has been build over all <code>ContentElement</code>s this <code>Document</code> consists of.<br>
      * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_COMBINEDCONTENTTYPE).getString()</code>.
      * 
      * <p>Property <b>CombinedContentType</b> (opendma): <b>String</b><br/>
      * [SingleValue] [Writable] [NotRequired]<br/>
      * Full description follows.</p>
      * 
      * @return the combined mime type that has been build over all <code>ContentElement</code>s this <code>Document</code> consists of
      */
     public String getCombinedContentType() {
         try {
             return getProperty(OdmaCommonNames.PROPERTY_COMBINEDCONTENTTYPE).getString();
         }
         catch(OdmaInvalidDataTypeException oidte) {
             throw new OdmaRuntimeException("Invalid data type of system property",oidte);
         }
         catch(OdmaPropertyNotFoundException oonfe) {
             throw new OdmaRuntimeException("Predefined system property missing",oonfe);
         }
     }

     /**
      * Sets the combined mime type that has been build over all <code>ContentElement</code>s this <code>Document</code> consists of.<br>
      * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_COMBINEDCONTENTTYPE).setValue(value)</code>.
      * 
      * <p>Property <b>CombinedContentType</b> (opendma): <b>String</b><br/>
      * [SingleValue] [Writable] [NotRequired]<br/>
      * Full description follows.</p>
      * 
      * @param newValue
      *             The new value for the combined mime type that has been build over all <code>ContentElement</code>s this <code>Document</code> consists of
      * 
      * @throws OdmaAccessDeniedException
      *             If this OdmaProperty is read-only or cannot be set by the current user
      */
     public void setCombinedContentType(String newValue) throws OdmaAccessDeniedException {
         try {
             getProperty(OdmaCommonNames.PROPERTY_COMBINEDCONTENTTYPE).setValue(newValue);
         }
         catch(OdmaInvalidDataTypeException oidte) {
             throw new OdmaRuntimeException("Invalid data type of system property",oidte);
         }
         catch(OdmaPropertyNotFoundException oonfe) {
             throw new OdmaRuntimeException("Predefined system property missing",oonfe);
         }
     }

     /**
      * Returns the primary <code>ContentElement</code>s that represents this <code>Document</code>.<br>
      * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_PRIMARYCONTENTELEMENT).getReference()</code>.
      * 
      * <p>Property <b>PrimaryContentElement</b> (opendma): <b>Reference to ContentElement (opendma)</b><br/>
      * [SingleValue] [Writable] [NotRequired]<br/>
      * Full description follows.</p>
      * 
      * @return the primary <code>ContentElement</code>s that represents this <code>Document</code>
      */
     public OdmaContentElement getPrimaryContentElement() {
         try {
             return (OdmaContentElement)getProperty(OdmaCommonNames.PROPERTY_PRIMARYCONTENTELEMENT).getReference();
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
      * Sets the primary <code>ContentElement</code>s that represents this <code>Document</code>.<br>
      * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_PRIMARYCONTENTELEMENT).setValue(value)</code>.
      * 
      * <p>Property <b>PrimaryContentElement</b> (opendma): <b>Reference to ContentElement (opendma)</b><br/>
      * [SingleValue] [Writable] [NotRequired]<br/>
      * Full description follows.</p>
      * 
      * @param newValue
      *             The new value for the primary <code>ContentElement</code>s that represents this <code>Document</code>
      * 
      * @throws OdmaAccessDeniedException
      *             If this OdmaProperty is read-only or cannot be set by the current user
      */
     public void setPrimaryContentElement(OdmaContentElement newValue) throws OdmaAccessDeniedException {
         try {
             getProperty(OdmaCommonNames.PROPERTY_PRIMARYCONTENTELEMENT).setValue(newValue);
         }
         catch(OdmaInvalidDataTypeException oidte) {
             throw new OdmaRuntimeException("Invalid data type of system property",oidte);
         }
         catch(OdmaPropertyNotFoundException oonfe) {
             throw new OdmaRuntimeException("Predefined system property missing",oonfe);
         }
     }

     /**
      * Returns the date when this version of this <code>Document</code> has been created.<br>
      * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_CREATEDAT).getDateTime()</code>.
      * 
      * <p>Property <b>CreatedAt</b> (opendma): <b>DateTime</b><br/>
      * [SingleValue] [ReadOnly] [Required]<br/>
      * Full description follows.</p>
      * 
      * @return the date when this version of this <code>Document</code> has been created
      */
//     public Date getCreatedAt() {
//         try {
//             return getProperty(OdmaCommonNames.PROPERTY_CREATEDAT).getDateTime();
//         }
//         catch(OdmaInvalidDataTypeException oidte) {
//             throw new OdmaRuntimeException("Invalid data type of system property",oidte);
//         }
//         catch(OdmaPropertyNotFoundException oonfe) {
//             throw new OdmaRuntimeException("Predefined system property missing",oonfe);
//         }
//     }

     /**
      * Returns the user who has created this version of this <code>Document</code>.<br>
      * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_CREATEDBY).getString()</code>.
      * 
      * <p>Property <b>CreatedBy</b> (opendma): <b>String</b><br/>
      * [SingleValue] [ReadOnly] [Required]<br/>
      * Full description follows.</p>
      * 
      * @return the user who has created this version of this <code>Document</code>
      */
//     public String getCreatedBy() {
//         try {
//             return getProperty(OdmaCommonNames.PROPERTY_CREATEDBY).getString();
//         }
//         catch(OdmaInvalidDataTypeException oidte) {
//             throw new OdmaRuntimeException("Invalid data type of system property",oidte);
//         }
//         catch(OdmaPropertyNotFoundException oonfe) {
//             throw new OdmaRuntimeException("Predefined system property missing",oonfe);
//         }
//     }

     /**
      * Returns the date when this version of this <code>Document</code> has been modified the last time.<br>
      * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_LASTMODIFIEDAT).getDateTime()</code>.
      * 
      * <p>Property <b>LastModifiedAt</b> (opendma): <b>DateTime</b><br/>
      * [SingleValue] [ReadOnly] [Required]<br/>
      * Full description follows.</p>
      * 
      * @return the date when this version of this <code>Document</code> has been modified the last time
      */
//     public Date getLastModifiedAt() {
//         try {
//             return getProperty(OdmaCommonNames.PROPERTY_LASTMODIFIEDAT).getDateTime();
//         }
//         catch(OdmaInvalidDataTypeException oidte) {
//             throw new OdmaRuntimeException("Invalid data type of system property",oidte);
//         }
//         catch(OdmaPropertyNotFoundException oonfe) {
//             throw new OdmaRuntimeException("Predefined system property missing",oonfe);
//         }
//     }

     /**
      * Returns the user who has modified this version of this <code>Document</code> the last time.<br>
      * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_LASTMODIFIEDBY).getString()</code>.
      * 
      * <p>Property <b>LastModifiedBy</b> (opendma): <b>String</b><br/>
      * [SingleValue] [ReadOnly] [Required]<br/>
      * Full description follows.</p>
      * 
      * @return the user who has modified this version of this <code>Document</code> the last time
      */
//     public String getLastModifiedBy() {
//         try {
//             return getProperty(OdmaCommonNames.PROPERTY_LASTMODIFIEDBY).getString();
//         }
//         catch(OdmaInvalidDataTypeException oidte) {
//             throw new OdmaRuntimeException("Invalid data type of system property",oidte);
//         }
//         catch(OdmaPropertyNotFoundException oonfe) {
//             throw new OdmaRuntimeException("Predefined system property missing",oonfe);
//         }
//     }

     /**
      * Returns <code>true</code> if and only if this <code>Document</code> is checked out.<br>
      * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_CHECKEDOUT).getBoolean()</code>.
      * 
      * <p>Property <b>CheckedOut</b> (opendma): <b>Boolean</b><br/>
      * [SingleValue] [ReadOnly] [Required]<br/>
      * Full description follows.</p>
      * 
      * @return <code>true</code> if and only if this <code>Document</code> is checked out
      */
     public Boolean isCheckedOut() {
         try {
             return getProperty(OdmaCommonNames.PROPERTY_CHECKEDOUT).getBoolean();
         }
         catch(OdmaInvalidDataTypeException oidte) {
             throw new OdmaRuntimeException("Invalid data type of system property",oidte);
         }
         catch(OdmaPropertyNotFoundException oonfe) {
             throw new OdmaRuntimeException("Predefined system property missing",oonfe);
         }
     }

     /**
      * Returns the date when this <code>Document</code> has been checked out.<br>
      * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_CHECKEDOUTAT).getDateTime()</code>.
      * 
      * <p>Property <b>CheckedOutAt</b> (opendma): <b>DateTime</b><br/>
      * [SingleValue] [ReadOnly] [NotRequired]<br/>
      * Full description follows.</p>
      * 
      * @return the date when this <code>Document</code> has been checked out
      */
     public Date getCheckedOutAt() {
         try {
             return getProperty(OdmaCommonNames.PROPERTY_CHECKEDOUTAT).getDateTime();
         }
         catch(OdmaInvalidDataTypeException oidte) {
             throw new OdmaRuntimeException("Invalid data type of system property",oidte);
         }
         catch(OdmaPropertyNotFoundException oonfe) {
             throw new OdmaRuntimeException("Predefined system property missing",oonfe);
         }
     }

     /**
      * Returns the user who has checked out this <code>Document</code>.<br>
      * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_CHECKEDOUTBY).getString()</code>.
      * 
      * <p>Property <b>CheckedOutBy</b> (opendma): <b>String</b><br/>
      * [SingleValue] [ReadOnly] [Required]<br/>
      * Full description follows.</p>
      * 
      * @return the user who has checked out this <code>Document</code>
      */
     public String getCheckedOutBy() {
         try {
             return getProperty(OdmaCommonNames.PROPERTY_CHECKEDOUTBY).getString();
         }
         catch(OdmaInvalidDataTypeException oidte) {
             throw new OdmaRuntimeException("Invalid data type of system property",oidte);
         }
         catch(OdmaPropertyNotFoundException oonfe) {
             throw new OdmaRuntimeException("Predefined system property missing",oonfe);
         }
     }

//----- OdmaFolder

     // ----- Object specific property access -------------------------------------------------------

     // CHECKTEMPLATE: the following code has most likely been copied from a class template. Make sure to keep this code up to date!
     // The following template code is available as OdmaFolderTemplate

     /**
      * Returns the <code>Folder</code> this <code>Folder</code> is a sub folder of.<br>
      * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_PARENT).getReference()</code>.
      * 
      * <p>Property <b>Parent</b> (opendma): <b>Reference to Folder (opendma)</b><br/>
      * [SingleValue] [Writable] [NotRequired]<br/>
      * Full description follows.</p>
      * 
      * @return the <code>Folder</code> this <code>Folder</code> is a sub folder of
      */
     public OdmaFolder getParent() {
         try {
             return (OdmaFolder)getProperty(OdmaCommonNames.PROPERTY_PARENT).getReference();
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
      * Sets the <code>Folder</code> this <code>Folder</code> is a sub folder of.<br>
      * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_PARENT).setValue(value)</code>.
      * 
      * <p>Property <b>Parent</b> (opendma): <b>Reference to Folder (opendma)</b><br/>
      * [SingleValue] [Writable] [NotRequired]<br/>
      * Full description follows.</p>
      * 
      * @param newValue
      *             The new value for the <code>Folder</code> this <code>Folder</code> is a sub folder of
      * 
      * @throws OdmaAccessDeniedException
      *             If this OdmaProperty is read-only or cannot be set by the current user
      */
     public void setParent(OdmaFolder newValue) throws OdmaAccessDeniedException {
         try {
             getProperty(OdmaCommonNames.PROPERTY_PARENT).setValue(newValue);
         }
         catch(OdmaInvalidDataTypeException oidte) {
             throw new OdmaRuntimeException("Invalid data type of system property",oidte);
         }
         catch(OdmaPropertyNotFoundException oonfe) {
             throw new OdmaRuntimeException("Predefined system property missing",oonfe);
         }
     }

     /**
      * Returns the collection of <code>Folder</code>s which have this <code>Folder</code> in their parent property.<br>
      * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_SUBFOLDERS).getReferenceIterable()</code>.
      * 
      * <p>Property <b>SubFolders</b> (opendma): <b>Reference to Folder (opendma)</b><br/>
      * [MultiValue] [ReadOnly] [NotRequired]<br/>
      * Full description follows.</p>
      * 
      * @return the collection of <code>Folder</code>s which have this <code>Folder</code> in their parent property
      */
      @SuppressWarnings("unchecked")
     public Iterable<OdmaFolder> getSubFolders() {
         try {
             return (Iterable<OdmaFolder>)getProperty(OdmaCommonNames.PROPERTY_SUBFOLDERS).getReferenceIterable();
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

//----- OdmaPropertyInfo

      // ----- Object specific property access -------------------------------------------------------

      // CHECKTEMPLATE: the following code has most likely been copied from a class template. Make sure to keep this code up to date!
      // The following template code is available as OdmaPropertyInfoTemplate

      /**
       * Returns the internal (technical) <i>name</i> of this <code>PropertyInfo</code>.<br>
       * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_NAME).getString()</code>.
       * 
       * <p>Property <b>Name</b> (opendma): <b>String</b><br/>
       * [SingleValue] [Writable] [Required]<br/>
       * Full description follows.</p>
       * 
       * @return the internal (technical) <i>name</i> of this <code>PropertyInfo</code>
       */
//      public String getName() {
//          try {
//              return getProperty(OdmaCommonNames.PROPERTY_NAME).getString();
//          }
//          catch(OdmaInvalidDataTypeException oidte) {
//              throw new OdmaRuntimeException("Invalid data type of system property",oidte);
//          }
//          catch(OdmaPropertyNotFoundException oonfe) {
//              throw new OdmaRuntimeException("Predefined system property missing",oonfe);
//          }
//      }

      /**
       * Sets the internal (technical) <i>name</i> of this <code>PropertyInfo</code>.<br>
       * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_NAME).setValue(value)</code>.
       * 
       * <p>Property <b>Name</b> (opendma): <b>String</b><br/>
       * [SingleValue] [Writable] [Required]<br/>
       * Full description follows.</p>
       * 
       * @param newValue
       *             The new value for the internal (technical) <i>name</i> of this <code>PropertyInfo</code>
       * 
       * @throws OdmaAccessDeniedException
       *             If this OdmaProperty is read-only or cannot be set by the current user
       */
//      public void setName(String newValue) throws OdmaAccessDeniedException {
//          try {
//              getProperty(OdmaCommonNames.PROPERTY_NAME).setValue(newValue);
//          }
//          catch(OdmaInvalidDataTypeException oidte) {
//              throw new OdmaRuntimeException("Invalid data type of system property",oidte);
//          }
//          catch(OdmaPropertyNotFoundException oonfe) {
//              throw new OdmaRuntimeException("Predefined system property missing",oonfe);
//          }
//      }

      /**
       * Returns the <i>namespace</i> of this <code>PropertyInfo</code>.<br>
       * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_NAMESPACE).getString()</code>.
       * 
       * <p>Property <b>Namespace</b> (opendma): <b>String</b><br/>
       * [SingleValue] [Writable] [NotRequired]<br/>
       * Full description follows.</p>
       * 
       * @return the <i>namespace</i> of this <code>PropertyInfo</code>
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
       * Sets the <i>namespace</i> of this <code>PropertyInfo</code>.<br>
       * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_NAMESPACE).setValue(value)</code>.
       * 
       * <p>Property <b>Namespace</b> (opendma): <b>String</b><br/>
       * [SingleValue] [Writable] [NotRequired]<br/>
       * Full description follows.</p>
       * 
       * @param newValue
       *             The new value for the <i>namespace</i> of this <code>PropertyInfo</code>
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
       * Returns the <i>display name</i> of this <code>PropertyInfo</code> to be displayed to end users.<br>
       * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_DISPLAYNAME).getString()</code>.
       * 
       * <p>Property <b>DisplayName</b> (opendma): <b>String</b><br/>
       * [SingleValue] [Writable] [Required]<br/>
       * Full description follows.</p>
       * 
       * @return the <i>display name</i> of this <code>PropertyInfo</code> to be displayed to end users
       */
//      public String getDisplayName() {
//          try {
//              return getProperty(OdmaCommonNames.PROPERTY_DISPLAYNAME).getString();
//          }
//          catch(OdmaInvalidDataTypeException oidte) {
//              throw new OdmaRuntimeException("Invalid data type of system property",oidte);
//          }
//          catch(OdmaPropertyNotFoundException oonfe) {
//              throw new OdmaRuntimeException("Predefined system property missing",oonfe);
//          }
//      }

      /**
       * Sets the <i>display name</i> of this <code>PropertyInfo</code> to be displayed to end users.<br>
       * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_DISPLAYNAME).setValue(value)</code>.
       * 
       * <p>Property <b>DisplayName</b> (opendma): <b>String</b><br/>
       * [SingleValue] [Writable] [Required]<br/>
       * Full description follows.</p>
       * 
       * @param newValue
       *             The new value for the <i>display name</i> of this <code>PropertyInfo</code> to be displayed to end users
       * 
       * @throws OdmaAccessDeniedException
       *             If this OdmaProperty is read-only or cannot be set by the current user
       */
//      public void setDisplayName(String newValue) throws OdmaAccessDeniedException {
//          try {
//              getProperty(OdmaCommonNames.PROPERTY_DISPLAYNAME).setValue(newValue);
//          }
//          catch(OdmaInvalidDataTypeException oidte) {
//              throw new OdmaRuntimeException("Invalid data type of system property",oidte);
//          }
//          catch(OdmaPropertyNotFoundException oonfe) {
//              throw new OdmaRuntimeException("Predefined system property missing",oonfe);
//          }
//      }

      /**
       * Returns the numeric ID of the data type described by this <code>PropertyInfo</code>.<br>
       * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_DATATYPE).getInteger()</code>.
       * 
       * <p>Property <b>DataType</b> (opendma): <b>Integer</b><br/>
       * [SingleValue] [Writable] [Required]<br/>
       * Full description follows.</p>
       * 
       * @return the numeric ID of the data type described by this <code>PropertyInfo</code>
       */
      public Integer getDataType() {
          try {
              return getProperty(OdmaCommonNames.PROPERTY_DATATYPE).getInteger();
          }
          catch(OdmaInvalidDataTypeException oidte) {
              throw new OdmaRuntimeException("Invalid data type of system property",oidte);
          }
          catch(OdmaPropertyNotFoundException oonfe) {
              throw new OdmaRuntimeException("Predefined system property missing",oonfe);
          }
      }

      /**
       * Sets the numeric ID of the data type described by this <code>PropertyInfo</code>.<br>
       * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_DATATYPE).setValue(value)</code>.
       * 
       * <p>Property <b>DataType</b> (opendma): <b>Integer</b><br/>
       * [SingleValue] [Writable] [Required]<br/>
       * Full description follows.</p>
       * 
       * @param newValue
       *             The new value for the numeric ID of the data type described by this <code>PropertyInfo</code>
       * 
       * @throws OdmaAccessDeniedException
       *             If this OdmaProperty is read-only or cannot be set by the current user
       */
      public void setDataType(Integer newValue) throws OdmaAccessDeniedException {
          try {
              getProperty(OdmaCommonNames.PROPERTY_DATATYPE).setValue(newValue);
          }
          catch(OdmaInvalidDataTypeException oidte) {
              throw new OdmaRuntimeException("Invalid data type of system property",oidte);
          }
          catch(OdmaPropertyNotFoundException oonfe) {
              throw new OdmaRuntimeException("Predefined system property missing",oonfe);
          }
      }

      /**
       * Returns the required <code>Class</code> of the object referenced by this property if this <code>PropertyInfo</code>.<br>
       * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_REFERENCECLASS).getReference()</code>.
       * 
       * <p>Property <b>ReferenceClass</b> (opendma): <b>Reference to Class (opendma)</b><br/>
       * [SingleValue] [Writable] [NotRequired]<br/>
       * Full description follows.</p>
       * 
       * @return the required <code>Class</code> of the object referenced by this property if this <code>PropertyInfo</code>
       */
      public OdmaClass getReferenceClass() {
          try {
              return (OdmaClass)getProperty(OdmaCommonNames.PROPERTY_REFERENCECLASS).getReference();
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
       * Sets the required <code>Class</code> of the object referenced by this property if this <code>PropertyInfo</code>.<br>
       * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_REFERENCECLASS).setValue(value)</code>.
       * 
       * <p>Property <b>ReferenceClass</b> (opendma): <b>Reference to Class (opendma)</b><br/>
       * [SingleValue] [Writable] [NotRequired]<br/>
       * Full description follows.</p>
       * 
       * @param newValue
       *             The new value for the required <code>Class</code> of the object referenced by this property if this <code>PropertyInfo</code>
       * 
       * @throws OdmaAccessDeniedException
       *             If this OdmaProperty is read-only or cannot be set by the current user
       */
      public void setReferenceClass(OdmaClass newValue) throws OdmaAccessDeniedException {
          try {
              getProperty(OdmaCommonNames.PROPERTY_REFERENCECLASS).setValue(newValue);
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
       * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_MULTIVALUE).getBoolean()</code>.
       * 
       * <p>Property <b>MultiValue</b> (opendma): <b>Boolean</b><br/>
       * [SingleValue] [Writable] [Required]<br/>
       * Full description follows.</p>
       * 
       * @return whether <code>Object</code>s of this <code>Class</code> can be created or not
       */
      public Boolean isMultiValue() {
          try {
              return getProperty(OdmaCommonNames.PROPERTY_MULTIVALUE).getBoolean();
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
       * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_MULTIVALUE).setValue(value)</code>.
       * 
       * <p>Property <b>MultiValue</b> (opendma): <b>Boolean</b><br/>
       * [SingleValue] [Writable] [Required]<br/>
       * Full description follows.</p>
       * 
       * @param newValue
       *             The new value for whether <code>Object</code>s of this <code>Class</code> can be created or not
       * 
       * @throws OdmaAccessDeniedException
       *             If this OdmaProperty is read-only or cannot be set by the current user
       */
      public void setMultiValue(Boolean newValue) throws OdmaAccessDeniedException {
          try {
              getProperty(OdmaCommonNames.PROPERTY_MULTIVALUE).setValue(newValue);
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
       * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_REQUIRED).getBoolean()</code>.
       * 
       * <p>Property <b>Required</b> (opendma): <b>Boolean</b><br/>
       * [SingleValue] [Writable] [Required]<br/>
       * Full description follows.</p>
       * 
       * @return whether <code>Object</code>s of this <code>Class</code> can be created or not
       */
      public Boolean isRequired() {
          try {
              return getProperty(OdmaCommonNames.PROPERTY_REQUIRED).getBoolean();
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
       * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_REQUIRED).setValue(value)</code>.
       * 
       * <p>Property <b>Required</b> (opendma): <b>Boolean</b><br/>
       * [SingleValue] [Writable] [Required]<br/>
       * Full description follows.</p>
       * 
       * @param newValue
       *             The new value for whether <code>Object</code>s of this <code>Class</code> can be created or not
       * 
       * @throws OdmaAccessDeniedException
       *             If this OdmaProperty is read-only or cannot be set by the current user
       */
      public void setRequired(Boolean newValue) throws OdmaAccessDeniedException {
          try {
              getProperty(OdmaCommonNames.PROPERTY_REQUIRED).setValue(newValue);
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
       * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_READONLY).getBoolean()</code>.
       * 
       * <p>Property <b>ReadOnly</b> (opendma): <b>Boolean</b><br/>
       * [SingleValue] [Writable] [Required]<br/>
       * Full description follows.</p>
       * 
       * @return whether this <code>Class</code> should be displayed to end users or not
       */
      public Boolean isReadOnly() {
          try {
              return getProperty(OdmaCommonNames.PROPERTY_READONLY).getBoolean();
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
       * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_READONLY).setValue(value)</code>.
       * 
       * <p>Property <b>ReadOnly</b> (opendma): <b>Boolean</b><br/>
       * [SingleValue] [Writable] [Required]<br/>
       * Full description follows.</p>
       * 
       * @param newValue
       *             The new value for whether this <code>Class</code> should be displayed to end users or not
       * 
       * @throws OdmaAccessDeniedException
       *             If this OdmaProperty is read-only or cannot be set by the current user
       */
      public void setReadOnly(Boolean newValue) throws OdmaAccessDeniedException {
          try {
              getProperty(OdmaCommonNames.PROPERTY_READONLY).setValue(newValue);
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
       * Returns set of possible choices the values of this property is limited to or null if there are no constraints for the value of this property.<br>
       * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_CHOICES).getReferenceIterable()</code>.
       * 
       * <p>Property <b>Choices</b> (opendma): <b>Reference to ChoiceValue (opendma)</b><br/>
       * [MultiValue] [Writable] [NotRequired]<br/>
       * Full description follows.</p>
       * 
       * @return set of possible choices the values of this property is limited to or null if there are no constraints for the value of this property
       */
       @SuppressWarnings("unchecked")
      public Iterable<OdmaChoiceValue> getChoices() {
          try {
              return (Iterable<OdmaChoiceValue>)getProperty(OdmaCommonNames.PROPERTY_CHOICES).getReferenceIterable();
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

//----- OdmaReferenceContentElement

      // ----- Object specific property access -------------------------------------------------------

      // CHECKTEMPLATE: the following code has most likely been copied from a class template. Make sure to keep this code up to date!
      // The following template code is available as OdmaReferenceContentElementTemplate

      /**
       * Returns the URI where the content is stored.<br>
       * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_LOCATION).getString()</code>.
       * 
       * <p>Property <b>Location</b> (opendma): <b>String</b><br/>
       * [SingleValue] [Writable] [NotRequired]<br/>
       * Full description follows.</p>
       * 
       * @return the URI where the content is stored
       */
      public String getLocation() {
          try {
              return getProperty(OdmaCommonNames.PROPERTY_LOCATION).getString();
          }
          catch(OdmaInvalidDataTypeException oidte) {
              throw new OdmaRuntimeException("Invalid data type of system property",oidte);
          }
          catch(OdmaPropertyNotFoundException oonfe) {
              throw new OdmaRuntimeException("Predefined system property missing",oonfe);
          }
      }

      /**
       * Sets the URI where the content is stored.<br>
       * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_LOCATION).setValue(value)</code>.
       * 
       * <p>Property <b>Location</b> (opendma): <b>String</b><br/>
       * [SingleValue] [Writable] [NotRequired]<br/>
       * Full description follows.</p>
       * 
       * @param newValue
       *             The new value for the URI where the content is stored
       * 
       * @throws OdmaAccessDeniedException
       *             If this OdmaProperty is read-only or cannot be set by the current user
       */
      public void setLocation(String newValue) throws OdmaAccessDeniedException {
          try {
              getProperty(OdmaCommonNames.PROPERTY_LOCATION).setValue(newValue);
          }
          catch(OdmaInvalidDataTypeException oidte) {
              throw new OdmaRuntimeException("Invalid data type of system property",oidte);
          }
          catch(OdmaPropertyNotFoundException oonfe) {
              throw new OdmaRuntimeException("Predefined system property missing",oonfe);
          }
      }

//----- OdmaRepository

      // ----- Object specific property access -------------------------------------------------------

      // CHECKTEMPLATE: the following code has most likely been copied from a class template. Make sure to keep this code up to date!
      // The following template code is available as OdmaRepositoryTemplate

      /**
       * Returns the internal (technical) <i>name</i> of this <code>Repository</code>.<br>
       * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_NAME).getString()</code>.
       * 
       * <p>Property <b>Name</b> (opendma): <b>String</b><br/>
       * [SingleValue] [Writable] [Required]<br/>
       * Full description follows.</p>
       * 
       * @return the internal (technical) <i>name</i> of this <code>Repository</code>
       */
//      public String getName() {
//          try {
//              return getProperty(OdmaCommonNames.PROPERTY_NAME).getString();
//          }
//          catch(OdmaInvalidDataTypeException oidte) {
//              throw new OdmaRuntimeException("Invalid data type of system property",oidte);
//          }
//          catch(OdmaPropertyNotFoundException oonfe) {
//              throw new OdmaRuntimeException("Predefined system property missing",oonfe);
//          }
//      }

      /**
       * Sets the internal (technical) <i>name</i> of this <code>Repository</code>.<br>
       * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_NAME).setValue(value)</code>.
       * 
       * <p>Property <b>Name</b> (opendma): <b>String</b><br/>
       * [SingleValue] [Writable] [Required]<br/>
       * Full description follows.</p>
       * 
       * @param newValue
       *             The new value for the internal (technical) <i>name</i> of this <code>Repository</code>
       * 
       * @throws OdmaAccessDeniedException
       *             If this OdmaProperty is read-only or cannot be set by the current user
       */
//      public void setName(String newValue) throws OdmaAccessDeniedException {
//          try {
//              getProperty(OdmaCommonNames.PROPERTY_NAME).setValue(newValue);
//          }
//          catch(OdmaInvalidDataTypeException oidte) {
//              throw new OdmaRuntimeException("Invalid data type of system property",oidte);
//          }
//          catch(OdmaPropertyNotFoundException oonfe) {
//              throw new OdmaRuntimeException("Predefined system property missing",oonfe);
//          }
//      }

      /**
       * Returns the <i>display name</i> of this <code>Repository</code> to be displayed to end users.<br>
       * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_DISPLAYNAME).getString()</code>.
       * 
       * <p>Property <b>DisplayName</b> (opendma): <b>String</b><br/>
       * [SingleValue] [Writable] [Required]<br/>
       * Full description follows.</p>
       * 
       * @return the <i>display name</i> of this <code>Repository</code> to be displayed to end users
       */
//      public String getDisplayName() {
//          try {
//              return getProperty(OdmaCommonNames.PROPERTY_DISPLAYNAME).getString();
//          }
//          catch(OdmaInvalidDataTypeException oidte) {
//              throw new OdmaRuntimeException("Invalid data type of system property",oidte);
//          }
//          catch(OdmaPropertyNotFoundException oonfe) {
//              throw new OdmaRuntimeException("Predefined system property missing",oonfe);
//          }
//      }

      /**
       * Sets the <i>display name</i> of this <code>Repository</code> to be displayed to end users.<br>
       * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_DISPLAYNAME).setValue(value)</code>.
       * 
       * <p>Property <b>DisplayName</b> (opendma): <b>String</b><br/>
       * [SingleValue] [Writable] [Required]<br/>
       * Full description follows.</p>
       * 
       * @param newValue
       *             The new value for the <i>display name</i> of this <code>Repository</code> to be displayed to end users
       * 
       * @throws OdmaAccessDeniedException
       *             If this OdmaProperty is read-only or cannot be set by the current user
       */
//      public void setDisplayName(String newValue) throws OdmaAccessDeniedException {
//          try {
//              getProperty(OdmaCommonNames.PROPERTY_DISPLAYNAME).setValue(newValue);
//          }
//          catch(OdmaInvalidDataTypeException oidte) {
//              throw new OdmaRuntimeException("Invalid data type of system property",oidte);
//          }
//          catch(OdmaPropertyNotFoundException oonfe) {
//              throw new OdmaRuntimeException("Predefined system property missing",oonfe);
//          }
//      }

      /**
       * Returns the <i>root</i> <code>Class</code> of the class hierarchy in this <code>Repository</code>.<br>
       * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_ROOTCLASS).getReference()</code>.
       * 
       * <p>Property <b>RootClass</b> (opendma): <b>Reference to Class (opendma)</b><br/>
       * [SingleValue] [ReadOnly] [Required]<br/>
       * Full description follows.</p>
       * 
       * @return the <i>root</i> <code>Class</code> of the class hierarchy in this <code>Repository</code>
       */
      public OdmaClass getRootClass() {
          try {
              return (OdmaClass)getProperty(OdmaCommonNames.PROPERTY_ROOTCLASS).getReference();
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
       * Returns the list of <code>Class</code>es that represent an <i>Aspect</i> and that do not inherit another aspect.<br>
       * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_ROOTASPECTS).getReferenceIterable()</code>.
       * 
       * <p>Property <b>RootAspects</b> (opendma): <b>Reference to Class (opendma)</b><br/>
       * [MultiValue] [ReadOnly] [NotRequired]<br/>
       * Full description follows.</p>
       * 
       * @return the list of <code>Class</code>es that represent an <i>Aspect</i> and that do not inherit another aspect
       */
       @SuppressWarnings("unchecked")
      public Iterable<OdmaClass> getRootAspects() {
          try {
              return (Iterable<OdmaClass>)getProperty(OdmaCommonNames.PROPERTY_ROOTASPECTS).getReferenceIterable();
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
       * Returns the <i>root</i> <code>Folder</code> of a dedicated folder tree in this <code>Repository</code> (if any).<br>
       * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_ROOTFOLDER).getReference()</code>.
       * 
       * <p>Property <b>RootFolder</b> (opendma): <b>Reference to Folder (opendma)</b><br/>
       * [SingleValue] [ReadOnly] [NotRequired]<br/>
       * Full description follows.</p>
       * 
       * @return the <i>root</i> <code>Folder</code> of a dedicated folder tree in this <code>Repository</code> (if any)
       */
      public OdmaFolder getRootFolder() {
          try {
              return (OdmaFolder)getProperty(OdmaCommonNames.PROPERTY_ROOTFOLDER).getReference();
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

//----- OdmaVersionCollection

      // ----- Object specific property access -------------------------------------------------------

      // CHECKTEMPLATE: the following code has most likely been copied from a class template. Make sure to keep this code up to date!
      // The following template code is available as OdmaVersionCollectionTemplate

      /**
       * Returns collection of all versions of the <code>Document</code>.<br>
       * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_VERSIONS).getReferenceIterable()</code>.
       * 
       * <p>Property <b>Versions</b> (opendma): <b>Reference to Document (opendma)</b><br/>
       * [MultiValue] [ReadOnly] [Required]<br/>
       * Full description follows.</p>
       * 
       * @return collection of all versions of the <code>Document</code>
       */
       @SuppressWarnings("unchecked")
      public Iterable<OdmaDocument> getVersions() {
          try {
              return (Iterable<OdmaDocument>)getProperty(OdmaCommonNames.PROPERTY_VERSIONS).getReferenceIterable();
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
       * Returns the latest version of this <code>Document</code>.<br>
       * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_LATEST).getReference()</code>.
       * 
       * <p>Property <b>Latest</b> (opendma): <b>Reference to Document (opendma)</b><br/>
       * [SingleValue] [ReadOnly] [Required]<br/>
       * Full description follows.</p>
       * 
       * @return the latest version of this <code>Document</code>
       */
      public OdmaDocument getLatest() {
          try {
              return (OdmaDocument)getProperty(OdmaCommonNames.PROPERTY_LATEST).getReference();
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
       * Returns the last released version of this <code>Document</code>.<br>
       * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_RELEASED).getReference()</code>.
       * 
       * <p>Property <b>Released</b> (opendma): <b>Reference to Document (opendma)</b><br/>
       * [SingleValue] [ReadOnly] [Required]<br/>
       * Full description follows.</p>
       * 
       * @return the last released version of this <code>Document</code>
       */
      public OdmaDocument getReleased() {
          try {
              return (OdmaDocument)getProperty(OdmaCommonNames.PROPERTY_RELEASED).getReference();
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
       * Returns the version of this <code>Document</code> currently beeing worked on during a checkout. Only valid if and only if the corresponding <code>Document</code> is checked out..<br>
       * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_INPROGRESS).getReference()</code>.
       * 
       * <p>Property <b>InProgress</b> (opendma): <b>Reference to Document (opendma)</b><br/>
       * [SingleValue] [ReadOnly] [Required]<br/>
       * Full description follows.</p>
       * 
       * @return the version of this <code>Document</code> currently beeing worked on during a checkout. Only valid if and only if the corresponding <code>Document</code> is checked out.
       */
      public OdmaDocument getInProgress() {
          try {
              return (OdmaDocument)getProperty(OdmaCommonNames.PROPERTY_INPROGRESS).getReference();
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
       * Returns the date when this <code>Document</code> has been created.<br>
       * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_CREATEDAT).getDateTime()</code>.
       * 
       * <p>Property <b>CreatedAt</b> (opendma): <b>DateTime</b><br/>
       * [SingleValue] [ReadOnly] [Required]<br/>
       * Full description follows.</p>
       * 
       * @return the date when this <code>Document</code> has been created
       */
//      public Date getCreatedAt() {
//          try {
//              return getProperty(OdmaCommonNames.PROPERTY_CREATEDAT).getDateTime();
//          }
//          catch(OdmaInvalidDataTypeException oidte) {
//              throw new OdmaRuntimeException("Invalid data type of system property",oidte);
//          }
//          catch(OdmaPropertyNotFoundException oonfe) {
//              throw new OdmaRuntimeException("Predefined system property missing",oonfe);
//          }
//      }

      /**
       * Returns the user who has created this <code>Document</code>.<br>
       * Shortcut for <code>getProperty(OdmaTypes.PROPERTY_CREATEDBY).getString()</code>.
       * 
       * <p>Property <b>CreatedBy</b> (opendma): <b>String</b><br/>
       * [SingleValue] [ReadOnly] [Required]<br/>
       * Full description follows.</p>
       * 
       * @return the user who has created this <code>Document</code>
       */
//      public String getCreatedBy() {
//          try {
//              return getProperty(OdmaCommonNames.PROPERTY_CREATEDBY).getString();
//          }
//          catch(OdmaInvalidDataTypeException oidte) {
//              throw new OdmaRuntimeException("Invalid data type of system property",oidte);
//          }
//          catch(OdmaPropertyNotFoundException oonfe) {
//              throw new OdmaRuntimeException("Predefined system property missing",oonfe);
//          }
//      }

}
