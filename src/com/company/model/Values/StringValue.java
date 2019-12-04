package com.company.model.Values;

import com.company.model.AbstractDataTypes.MyException;
import com.company.model.Types.IntType;
import com.company.model.Types.StringType;
import com.company.model.Types.Type;

public class StringValue implements Value {
    private String value;
    public StringValue(String newValue){
        value = newValue;
    }

    public boolean equals(Object another){
        if (another instanceof StringValue)
            if(((StringValue) another).getVal()==value)
                return true;
            else
                return false;
        else throw new MyException("no same type ==");
    }


    @Override
    public Type getType() {
        StringType e = new StringType();
        return e;
    }

    public String getVal() {
        return value;
    }

    @Override
    public String toString() {
        return "StringValue{" +
                "value=" + value +
                '}';
    }
}
