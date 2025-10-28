package com.xaldon.opendma.xmlrepo;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

import org.opendma.api.OdmaAdaptor;
import org.opendma.api.OdmaQName;
import org.opendma.api.OdmaSession;
import org.opendma.exceptions.OdmaException;

import com.xaldon.opendma.xmlrepo.exceptions.OdmaXmlRepositoryException;

public class Adaptor implements OdmaAdaptor
{

    public final static String SYSTEMID = "xmlrepo";
    
    private final List<OdmaQName> supportedTokenTypes;
    
    public Adaptor() {
        supportedTokenTypes = Collections.unmodifiableList(new ArrayList<OdmaQName>(0));
    }

    @Override
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
            stream = Adaptor.class.getResourceAsStream(resource);
        }
        if(stream == null)
        {
            stream = Adaptor.class.getClassLoader().getResourceAsStream(stripped);
        }
        if(stream == null)
        {
            throw new OdmaXmlRepositoryException("Can not load resource " + resource);
        }
        return stream;
    }
    
    @Override
    public String getSystemId()
    {
        return SYSTEMID;
    }

    @Override
    public List<OdmaQName> getSupportedTokenTypes() {
        return supportedTokenTypes;
    }

}
