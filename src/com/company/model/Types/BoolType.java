package com.company.model.Types;

import com.company.model.Values.BoolValue;
import com.company.model.Values.Value;

public class BoolType implements Type {
    public boolean equals(Object another){
        if (another instanceof BoolType)
            return true;
        else
            return false;
    }
    public String toString() { return "bool";}

    @Override
    public Value defaultValue() {
        return new BoolValue(true);
    }

    @Override
    public Type deepcopy() {
        return new BoolType();
    }
}
