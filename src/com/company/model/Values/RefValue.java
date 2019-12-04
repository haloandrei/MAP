package com.company.model.Values;

import com.company.model.Types.RefType;
import com.company.model.Types.Type;

public class RefValue implements Value{
    private int address;
    private Type locationType;
    public RefValue(int addressIn, Type locationTypeIn){
        address = addressIn;
        locationType = locationTypeIn;
    }
    public int getAddr() {return address;}
    public Type getType() { return new RefType(locationType);}
}

