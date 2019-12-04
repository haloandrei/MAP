package com.company.model.Types;

import com.company.model.Values.StringValue;
import com.company.model.Values.Value;

public class StringType implements Type {
    public boolean equals(Object another){
        if (another instanceof StringType)
            return true;
        else
            return false;
    }
    public String toString() { return "string";}

    @Override
    public Value defaultValue() {
        return new StringValue("");
    }
}
