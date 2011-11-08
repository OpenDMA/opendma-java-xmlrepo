package com.xaldon.opendma.xmlrepo.temp;

import org.opendma.OdmaTypes;
import org.opendma.api.OdmaQName;
import org.opendma.exceptions.OdmaInvalidDataTypeException;
import org.opendma.impl.OdmaPropertyImpl;

class UnevaluatedReferenceProperty extends OdmaPropertyImpl
{

    public UnevaluatedReferenceProperty(OdmaQName name, Object value, boolean multivalue, boolean readonly) throws OdmaInvalidDataTypeException
    {
        super(name, value, OdmaTypes.TYPE_ID, multivalue, readonly);
    }
    
}
