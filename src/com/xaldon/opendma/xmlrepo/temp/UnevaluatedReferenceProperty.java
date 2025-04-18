package com.xaldon.opendma.xmlrepo.temp;

import org.opendma.api.OdmaQName;
import org.opendma.api.OdmaType;
import org.opendma.exceptions.OdmaInvalidDataTypeException;
import org.opendma.impl.OdmaPropertyImpl;

class UnevaluatedReferenceProperty extends OdmaPropertyImpl
{

    public UnevaluatedReferenceProperty(OdmaQName name, Object value, boolean multivalue, boolean readonly) throws OdmaInvalidDataTypeException
    {
        super(name, value, OdmaType.ID, multivalue, readonly);
    }
    
}
