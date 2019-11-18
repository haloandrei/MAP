package com.company.model.AbstractDataTypes;

import com.company.model.AbstractDataTypes.MyIStack;

import java.util.Stack;

public class MyStack<T> implements MyIStack<T> {
    Stack<T> stack;

    public MyStack() {
        stack = new Stack<>();
    }
    @Override
    public T pop() {
        return stack.pop();
    }

    @Override
    public void push(T v) {
        stack.push(v);
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public String toString() {
        return "MyStack{" +
                "stack=" + stack.toString() +
                '}';
    }
}
