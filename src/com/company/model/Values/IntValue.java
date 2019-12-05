package com.company.model.Values;

import com.company.model.AbstractDataTypes.MyException;
import com.company.model.Types.Type;
import com.company.model.Types.IntType;

public class IntValue implements Value {
    private int value;
    public IntValue(int newValue){
        value = newValue;
    }

    @Override
    public Type getType() {
        return new IntType();
    }

    @Override
    public Value deepcopy() {
        return new IntValue(value);
    }

    public boolean equals(Object another){
        if (another instanceof IntValue)
            if(((IntValue) another).getVal()==value)
                return true;
        else
            return false;
        else throw new MyException("no same type ==");
    }

    public int getVal() {
        return value;
    }
    public void setValue(int inputV) { value = inputV;}
    @Override
    public String toString() {
        return "IntValue{" +
                "value=" + value +
                '}';
    }
}
