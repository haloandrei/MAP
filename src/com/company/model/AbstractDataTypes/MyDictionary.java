package com.company.model.AbstractDataTypes;

import com.company.model.Values.Value;

import java.util.HashMap;


public class MyDictionary<T, T1> implements MyIDictionary<T, T1>{

    private HashMap<T,T1> Dictionary;

    public MyDictionary() {
        Dictionary = new HashMap<>();
    };

    public void addElement(T key, T1 value){
        Dictionary.put(key,value);
    }

    public void clear(){
        Dictionary.clear();
    }

    public Value lookup(String token)
    {
        return (Value) Dictionary.get(token);
    }

    public boolean isDefined(T id) {
        Value val = (Value) Dictionary.get(id);
        if (val == null)
            return false;
        else return true;
    }

    public Value getValue(T id) {
        return (Value)Dictionary.get(id);
    }

    public void update(T id, T1 val) {
        Dictionary.put(id,val);
    }

    @Override
    public String toString() {
        return "MyDictionary{" +
                "Dictionary=" + Dictionary +
                '}';
    }
}
