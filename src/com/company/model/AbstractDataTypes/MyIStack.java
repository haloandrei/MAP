package com.company.model.AbstractDataTypes;

public interface MyIStack<T> {
    T pop();
    void push(T v);

    boolean isEmpty();
}
