package com.xaldon.opendma.xmlrepo;

import java.util.Properties;

import org.opendma.OdmaSession;
import org.opendma.api.OdmaId;
import org.opendma.api.OdmaObject;
import org.opendma.api.OdmaQName;
import org.opendma.api.OdmaRepository;
import org.opendma.api.OdmaSearchResult;
import org.opendma.exceptions.OdmaAccessDeniedException;
import org.opendma.exceptions.OdmaException;
import org.opendma.exceptions.OdmaObjectNotFoundException;
import org.opendma.exceptions.OdmaQuerySyntaxException;
import org.opendma.exceptions.OdmaSearchException;

import com.xaldon.opendma.xmlrepo.temp.XmlRepositoryManager;

public class XmlRepositorySession implements OdmaSession
{

    public final static String URLPREFIX = Adaptor.SYSTEMID+":";
    
    public final static int URLPREFIXLEN = URLPREFIX.length();
    
    protected XmlRepositoryManager repoManager;
    
    protected OdmaRepository repo;
    
    protected OdmaId repoId;
    
    protected OdmaId[] repoList;
    
    protected XmlRepositorySession(Properties info) throws OdmaException
    {
        // get connection arguments
        String user = info.getProperty("user");
        String password = info.getProperty("password");
        String url = info.getProperty("url");
        String enforceRequiredStr = info.getProperty("enforceRequired");
        // check url and get connectionUri
        if(!url.startsWith(URLPREFIX))
        {
            throw new OdmaException("Invalid schema in url. Expected \""+URLPREFIX+"\"");
        }
        String resourceName = url.substring(URLPREFIXLEN);
        repoManager = new XmlRepositoryManager(NonRegisteringAdaptor.getResourceAsStream(resourceName),user,password,((enforceRequiredStr!=null)&&enforceRequiredStr.equalsIgnoreCase("true")));
        repo = repoManager.getRepository();
        repoId = repo.getId();
        repoList = new OdmaId[]{ repoId };
    }

    public OdmaId[] getRepositoryIds()
    {
        return repoList;
    }

    public OdmaRepository getRepository(OdmaId repositoryId) throws OdmaObjectNotFoundException, OdmaAccessDeniedException
    {
        if(repoId.equals(repositoryId))
        {
            return repo;
        }
        throw new OdmaObjectNotFoundException(repositoryId);
    }

    public OdmaObject getObject(OdmaId repositoryId, OdmaId objectId, OdmaQName className, OdmaQName[] propertyNames) throws OdmaObjectNotFoundException, OdmaAccessDeniedException
    {
        if(repoId.equals(repositoryId))
        {
            return repoManager.getObject(objectId);
        }
        throw new OdmaObjectNotFoundException(repositoryId);
    }

    public OdmaSearchResult search(OdmaId repositoryId, String query) throws OdmaObjectNotFoundException, OdmaAccessDeniedException, OdmaQuerySyntaxException, OdmaSearchException
    {
        // TODO Auto-generated method stub
        return null;
    }

    public void close()
    {
        repo = null;
        repoId = null;
        repoList = new OdmaId[]{ };
    }

}
