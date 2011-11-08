package com.xaldon.opendma.xmlrepo;

import org.opendma.AdaptorManager;
import org.opendma.exceptions.OdmaConfigurationException;

public class Adaptor extends NonRegisteringAdaptor
{

    public final static String SYSTEMID = "xmlrepo";
    
    // Register with AdaptorManager
    static
    {
        try
        {
            AdaptorManager.registerAdaptor(new Adaptor(),SYSTEMID);
        }
        catch(OdmaConfigurationException e)
        {
            throw new RuntimeException("Can't register adaptor!",e);
        }
    }
    
    /**
     * Create a new OpenDMA Adaptor
     */
    public Adaptor()
    {
        // required for Class.forName().newInstance()
    }

}
