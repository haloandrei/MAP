package com.company.model.Types;

import com.company.model.Values.RefValue;
import com.company.model.Values.Value;

public class RefType implements Type{
    private Type inner;
    public RefType(Type inner) {this.inner=inner;}
    public Type getInner() {return inner;}
    public boolean equals(Object another){
        if (another instanceof RefType)
            return inner.equals(((RefType) another).getInner());
        else
            return false;
    }
    public String toString() { return "Ref(" +inner.toString()+")";}
    public Value defaultValue() { return new RefValue(0,inner);}

    @Override
    public Type deepcopy() {
        return new RefType(inner);
    }

}

