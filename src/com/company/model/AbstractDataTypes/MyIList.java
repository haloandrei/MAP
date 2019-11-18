package com.company.model.AbstractDataTypes;

import com.company.model.Types.Type;

public interface MyIList<T> {
    boolean add(T e);
    T remove(int index);
    boolean isEmpty();

    int size();
    T get(int index);
}
