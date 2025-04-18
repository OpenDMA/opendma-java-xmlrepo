package com.xaldon.opendma.xmlrepo.temp;

import java.util.Map;

import org.opendma.api.OdmaCommonNames;
import org.opendma.api.OdmaFolder;
import org.opendma.api.OdmaProperty;
import org.opendma.api.OdmaQName;
import org.opendma.exceptions.OdmaAccessDeniedException;
import org.opendma.exceptions.OdmaInvalidDataTypeException;
import org.opendma.exceptions.OdmaPropertyNotFoundException;
import org.opendma.exceptions.OdmaRuntimeException;

import com.xaldon.opendma.xmlrepo.exceptions.OdmaXmlRepositoryException;

/**
 * Template implementation of the interface <code>{@link OdmaFolder}</code>.<p>
 * 
 * Full description follows.
 * 
 * @author Stefan Kopf, xaldon Technologies GmbH, the OpenDMA architecture board
 */
public class OdmaXmlFolder extends OdmaXmlContainer implements OdmaFolder
{
    
    public OdmaXmlFolder(Map<OdmaQName, OdmaProperty> properties) throws OdmaXmlRepositoryException
    {
        super(properties);
    }

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

}
