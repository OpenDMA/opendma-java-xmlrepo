package com.xaldon.opendma.xmlrepo.temp;

import java.util.Map;

import org.opendma.OdmaTypes;
import org.opendma.api.OdmaClass;
import org.opendma.api.OdmaGuid;
import org.opendma.api.OdmaId;
import org.opendma.api.OdmaProperty;
import org.opendma.api.OdmaQName;
import org.opendma.api.OdmaRepository;
import org.opendma.exceptions.OdmaInvalidDataTypeException;
import org.opendma.exceptions.OdmaRuntimeException;
import org.opendma.impl.OdmaPropertyImpl;

import com.xaldon.opendma.xmlrepo.exceptions.OdmaXmlRepositoryException;

public class OdmaXmlObjectData
{
    
    protected OdmaQName className;

    protected Map<OdmaQName, OdmaProperty> properties;
    
    public OdmaXmlObjectData(OdmaQName className, Map<OdmaQName, OdmaProperty> properties)
    {
        this.className = className;
        this.properties = properties;
    }
    
    public OdmaQName getClassName()
    {
        return className;
    }
    
    public Map<OdmaQName, OdmaProperty> getProperties()
    {
        return properties;
    }
    
    public OdmaId getId() throws OdmaXmlRepositoryException
    {
        OdmaProperty objectIdProperty = properties.get(OdmaTypes.PROPERTY_ID);
        if(objectIdProperty == null)
        {
            throw new OdmaXmlRepositoryException("Missing ID property.");
        }
        OdmaId objectId;
        try
        {
            objectId = objectIdProperty.getId();
        }
        catch (OdmaInvalidDataTypeException e)
        {
            throw new OdmaXmlRepositoryException("Invalid dtata type of ID property.",e);
        }
        if(objectId == null)
        {
            throw new OdmaXmlRepositoryException("Missing value of required ID property.");
        }
        return objectId;
    }
    
    public void setSystemProperties(OdmaClass cls, OdmaGuid guid, OdmaRepository repository)
    {
        try
        {
            properties.put(OdmaTypes.PROPERTY_CLASS,new OdmaPropertyImpl(OdmaTypes.PROPERTY_CLASS,cls,OdmaTypes.TYPE_REFERENCE,false,true));
            properties.put(OdmaTypes.PROPERTY_GUID,new OdmaPropertyImpl(OdmaTypes.PROPERTY_GUID,guid,OdmaTypes.TYPE_GUID,false,true));
            properties.put(OdmaTypes.PROPERTY_REPOSITORY,new OdmaPropertyImpl(OdmaTypes.PROPERTY_REPOSITORY,repository,OdmaTypes.TYPE_REFERENCE,false,true));
        }
        catch(OdmaInvalidDataTypeException e)
        {
            throw new OdmaRuntimeException("Implementation error",e);
        }
    }
    
}
