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

    public int getAddress() {
        return address;
    }

    public Type getLocationType() {
        return locationType;
    }

    public void setAddress(int address) {
        this.address = address;
    }

    public void setLocationType(Type locationType) {
        this.locationType = locationType;
    }

    @Override
    public Type getType() {
        return new RefType(locationType);
    }
    @Override
    public Value deepcopy() {
        return new RefValue(address, locationType.deepcopy());
    }

    @Override
    public String toString(){
        return "( " + Integer.toString(this.address) + ", " + locationType.toString() + " )";
    }

}

