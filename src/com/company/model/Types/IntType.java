package com.company.model.Types;

import com.company.model.Values.IntValue;
import com.company.model.Values.Value;

public class IntType implements Type {
    public boolean equals(Object another){
        if (another instanceof IntType)
            return true;
        else
            return false;
    }
    public String toString() { return "int";}

    @Override
    public Value defaultValue() {
        return new IntValue(0);
    }

    @Override
    public Type deepcopy() {
        return new IntType();
    }

}
