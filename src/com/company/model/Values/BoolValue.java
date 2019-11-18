package com.company.model.Values;

import com.company.model.Types.Type;
import com.company.model.Types.BoolType;

public class BoolValue implements Value {
    boolean value;
    public BoolValue(boolean newValue){
        value = newValue;
    }

    @Override
    public Type getType() {
        BoolType e = new BoolType();
        return e;
    }

    public boolean getVal() {
        return value;
    }

    @Override
    public String toString() {
        return "BoolValue{" +
                "value=" + value +
                '}';
    }
}