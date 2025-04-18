package com.xaldon.opendma.xmlrepo;

import java.io.InputStream;
import java.util.Properties;

import org.opendma.Adaptor;
import org.opendma.api.OdmaSession;
import org.opendma.exceptions.OdmaException;

import com.xaldon.opendma.xmlrepo.exceptions.OdmaXmlRepositoryException;

public class NonRegisteringAdaptor implements Adaptor
{

    public OdmaSession connect(Properties info) throws OdmaException
    {
        try
        {
            XmlRepositorySession session = new XmlRepositorySession(info);
            return session;
        }
        catch(OdmaException odmae)
        {
            throw odmae;
        }
        catch(Exception e)
        {
            throw new OdmaException(e.getLocalizedMessage(),e);
        }
    }

    public static InputStream getResourceAsStream(String resource) throws OdmaXmlRepositoryException
    {
        String stripped = resource.startsWith("/") ? resource.substring(1) : resource;
        InputStream stream = null;
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        if(classLoader!=null)
        {
            stream = classLoader.getResourceAsStream(stripped);
        }
        if(stream == null)
        {
            stream = NonRegisteringAdaptor.class.getResourceAsStream(resource);
        }
        if(stream == null)
        {
            stream = NonRegisteringAdaptor.class.getClassLoader().getResourceAsStream(stripped);
        }
        if(stream == null)
        {
            throw new OdmaXmlRepositoryException("Can not load resource " + resource);
        }
        return stream;
    }

}
