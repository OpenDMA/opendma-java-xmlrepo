package com.xaldon.opendma.xmlrepo.temp;

import java.util.Map;

import org.opendma.OdmaTypes;
import org.opendma.api.OdmaFolder;
import org.opendma.api.OdmaProperty;
import org.opendma.api.OdmaQName;
import org.opendma.api.collections.OdmaFolderEnumeration;
import org.opendma.exceptions.OdmaAccessDeniedException;
import org.opendma.exceptions.OdmaInvalidDataTypeException;
import org.opendma.exceptions.OdmaObjectNotFoundException;
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

}
