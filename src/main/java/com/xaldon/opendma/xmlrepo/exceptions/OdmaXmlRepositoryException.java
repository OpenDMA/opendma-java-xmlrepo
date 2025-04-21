package com.xaldon.opendma.xmlrepo.exceptions;

import org.opendma.exceptions.OdmaException;


public class OdmaXmlRepositoryException extends OdmaException
{

    private static final long serialVersionUID = -8276386996736975763L;

    /**
     * Create a new OdmaXmlRepositoryException
     */
    public OdmaXmlRepositoryException()
    {
        super();
    }

    /**
     * Create a new OdmaXmlRepositoryException
     * 
     * @param message the detailed message
     */
    public OdmaXmlRepositoryException(String message)
    {
        super(message);
    }

    /**
     * Create a new OdmaXmlRepositoryException
     * 
     * @param cause the cause
     */
    public OdmaXmlRepositoryException(Throwable cause)
    {
        super(cause);
    }

    /**
     * Create a new OdmaXmlRepositoryException
     * 
     * @param message the detailed message
     * @param cause the cause
     */
    public OdmaXmlRepositoryException(String message, Throwable cause)
    {
        super(message, cause);
    }
    
}
