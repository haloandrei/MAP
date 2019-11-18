package com.company.model.Values;

import com.company.model.Types.Type;
import com.company.model.Types.IntType;

public class IntValue implements Value {
    int value;
    public IntValue(int newValue){
        value = newValue;
    }

    @Override
    public Type getType() {
        IntType e = new IntType();
        return e;
    }

    public int getVal() {
        return value;
    }

    @Override
    public String toString() {
        return "IntValue{" +
                "value=" + value +
                '}';
    }
}
