package com.xaldon.opendma.xmlrepo;

import java.util.Properties;

import org.opendma.api.OdmaQName;
import org.opendma.api.OdmaSession;
import org.opendma.api.OdmaSessionProvider;
import org.opendma.exceptions.OdmaException;
import org.opendma.exceptions.OdmaRuntimeException;

public class XmlRepositorySessionProvider implements OdmaSessionProvider
{

    private String filename;

    private String classpathResource;
    
    private static final Adaptor adaptor = new Adaptor();
    
    public void setFilename(String filename)
    {
        this.filename = filename;
        this.classpathResource = null;
    }
    
    public void setClasspathResource(String classpathResource)
    {
        this.classpathResource = classpathResource;
        this.filename = null;
    }
    
    public OdmaSession getSession()
    {
        Properties prop = new Properties();
        if(filename != null)
        {
            prop.setProperty("filename", filename);
        }
        if(classpathResource != null)
        {
            prop.setProperty("classpathResource", classpathResource);
        }
        try
        {
            return adaptor.connect(prop);
        }
        catch (OdmaException e)
        {
            throw new OdmaRuntimeException(e);
        }
    }

    public OdmaSession getSessionForAccount(String username, String password)
    {
        return getSession();
    }

    public OdmaSession getSessionWithToken(OdmaQName tokenType, String token)
    {
        return getSession();
    }

}
