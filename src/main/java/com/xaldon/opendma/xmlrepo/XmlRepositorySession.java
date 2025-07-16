package com.xaldon.opendma.xmlrepo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.opendma.api.OdmaGuid;
import org.opendma.api.OdmaId;
import org.opendma.api.OdmaObject;
import org.opendma.api.OdmaQName;
import org.opendma.api.OdmaRepository;
import org.opendma.api.OdmaSearchResult;
import org.opendma.api.OdmaSession;
import org.opendma.exceptions.OdmaException;
import org.opendma.exceptions.OdmaObjectNotFoundException;
import org.opendma.exceptions.OdmaQuerySyntaxException;

import com.xaldon.opendma.xmlrepo.objects.XmlRepositoryManager;

public class XmlRepositorySession implements OdmaSession
{

    public final static String URLPREFIX = Adaptor.SYSTEMID+":";
    
    public final static int URLPREFIXLEN = URLPREFIX.length();
    
    protected XmlRepositoryManager repoManager;
    
    protected OdmaRepository repo;
    
    protected OdmaId repoId;
    
    protected ArrayList<OdmaId> repoList;
    
    protected XmlRepositorySession(Properties info) throws OdmaException
    {
        String filename = info.getProperty("filename");
        String classpathResource = info.getProperty("classpathResource");
        boolean enforceRequired = "true".equalsIgnoreCase(info.getProperty("enforceRequired"));
        try
        {
            InputStream is;
            if(filename != null)
            {
                File file = new File(filename);
                if(!file.exists())
                {
                    throw new OdmaException("File does not exist: "+file.getAbsolutePath());
                }
                is = new FileInputStream(file);
            }
            else if(classpathResource != null)
            {
                is = Adaptor.getResourceAsStream(classpathResource);
            }
            else
            {
                throw new OdmaException("Missinmg `filename` or `classpathResource` session argument for XML Repository");
            }
            try
            {
                repoManager = new XmlRepositoryManager(is, enforceRequired);
            }
            finally
            {
                try
                {
                    is.close();
                } catch (IOException e) { }
            }
        }
        catch(IOException ioe)
        {
            throw new OdmaException("Error reading file: "+filename, ioe);
        }
        repo = repoManager.getRepository();
        repoId = repo.getGuid().getRepositoryId();
        repoList = new ArrayList<OdmaId>(1);
        repoList.add(repoId);
    }

    public List<OdmaId> getRepositoryIds()
    {
        return repoList;
    }

    public OdmaRepository getRepository(OdmaId repositoryId) throws OdmaObjectNotFoundException
    {
        if(repoId.equals(repositoryId))
        {
            return repo;
        }
        throw new OdmaObjectNotFoundException(new OdmaGuid(repositoryId, repositoryId));
    }

    public OdmaObject getObject(OdmaId repositoryId, OdmaId objectId, OdmaQName[] propertyNames) throws OdmaObjectNotFoundException
    {
        if(repoId.equals(repositoryId))
        {
            return repoManager.getObject(objectId);
        }
        throw new OdmaObjectNotFoundException(new OdmaGuid(objectId, repositoryId));
    }

    public OdmaSearchResult search(OdmaId repositoryId, OdmaQName queryLanguage, String query) throws OdmaObjectNotFoundException, OdmaQuerySyntaxException
    {
    	throw new OdmaQuerySyntaxException("Unsupported query language: "+queryLanguage);
    }

    public void close()
    {
        repo = null;
        repoId = null;
        repoList.clear();
    }

}
