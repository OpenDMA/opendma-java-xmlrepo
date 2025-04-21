package com.xaldon.opendma.xmlrepo;

import java.util.Properties;

import org.opendma.api.OdmaQName;
import org.opendma.api.OdmaSession;
import org.opendma.api.OdmaSessionProvider;
import org.opendma.exceptions.OdmaException;
import org.opendma.exceptions.OdmaRuntimeException;

public class XmlRepositorySessionProvider implements OdmaSessionProvider
{

    private String url;
    
    private static final NonRegisteringAdaptor adaptor = new NonRegisteringAdaptor();
    
    public void setFilename(String filename)
    {
        this.url = Adaptor.SYSTEMID + ":" + filename;
    }
    
    public OdmaSession getSession()
    {
        Properties prop = new Properties();
        prop.setProperty("url", url);
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
