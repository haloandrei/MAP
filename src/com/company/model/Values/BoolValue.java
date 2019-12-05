package com.company.model.Values;

import com.company.model.AbstractDataTypes.MyException;
import com.company.model.Types.Type;
import com.company.model.Types.BoolType;

public class BoolValue implements Value {
    boolean value;
    public BoolValue(boolean newValue){
        value = newValue;
    }

    public boolean equals(Object another){
        if (another instanceof BoolValue)
            if (((BoolValue) another).getVal() == value)
                return true;
            else
                return false;
        else throw new MyException("not same type equal ==");
    }
    @Override
    public Type getType() {
        BoolType e = new BoolType();
        return e;
    }

    @Override
    public Value deepcopy() {
        return new BoolValue(value);
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