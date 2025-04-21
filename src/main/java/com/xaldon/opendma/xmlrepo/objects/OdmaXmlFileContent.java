package com.xaldon.opendma.xmlrepo.objects;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.opendma.api.OdmaContent;
import org.opendma.exceptions.OdmaRuntimeException;

import com.xaldon.opendma.xmlrepo.exceptions.OdmaXmlRepositoryException;

public class OdmaXmlFileContent implements OdmaContent
{

    protected File file;
    
    public OdmaXmlFileContent(String filename) throws OdmaXmlRepositoryException
    {
        file = new File(filename);
        if( (!file.exists()) || (!file.isFile()) )
        {
            throw new OdmaXmlRepositoryException("External file does not exist: "+filename);
        }
    }

    public long getSize()
    {
        return file.length();
    }

    public InputStream getStream()
    {
        try
        {
            return new FileInputStream(file);
        }
        catch(FileNotFoundException e)
        {
            throw new OdmaRuntimeException("Error creating stream from file");
        }
    }

}
