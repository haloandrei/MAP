package com.company.model.AbstractDataTypes;

import com.company.model.Values.Value;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MyHeap<K extends Number,V> implements MyIHeap<Integer,Value> {
    private HashMap<Integer,Value> internal;
    private Integer nextFreeAddress;
    public MyHeap(){
        this.internal = new HashMap<>();
        nextFreeAddress=1;
        internal.put(0,null);
    }
    public int put(V value){
        internal.put(nextFreeAddress, (Value) value);
        nextFreeAddress++;
        return nextFreeAddress-1;
    }

    @Override
    public boolean isDefined(Integer id) {
        return internal.containsKey(id);
    }

    @Override
    public void update(Integer id, Value value) {
        internal.put(id,value);
    }

    @Override
    public void update(Value value) {
        internal.put(nextFreeAddress,value);
        nextFreeAddress++;
    }


    @Override
    public void remove(Value value) {
        internal.remove(value);
    }

    @Override
    public Integer getCurrentFree() {
        return nextFreeAddress;
    }

    @Override
    public Set<Map.Entry<Integer, Value>> getEntrySet() {
        return internal.entrySet();
    }

    @Override
    public Value getValue(Integer key) {
        return internal.get(key);
    }

    @Override
    public void setContent(Map<Integer, Value> newContent) {
        internal = (HashMap) newContent;
    }

    public String toString(){
        return internal.toString();
    }
}
