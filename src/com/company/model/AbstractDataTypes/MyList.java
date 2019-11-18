package com.company.model.AbstractDataTypes;

import java.util.*;

public class MyList<T> implements MyIList<T> {
    private List<T> list;

    public MyList() {
        list = new ArrayList<T>();
    }
    public boolean add(T elem){
        return list.add(elem);

    }
    public T remove (int index){
        return list.remove(index);
    }
    public boolean isEmpty(){
        return list.isEmpty();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public T get(int index) {
        return list.get(index);
    }

    @Override
    public String toString() {
        return "MyList{" +
                "list=" + list.toString() +
                '}';
    }
}
