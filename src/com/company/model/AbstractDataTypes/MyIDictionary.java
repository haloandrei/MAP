package com.company.model.AbstractDataTypes;

import com.company.model.Values.Value;

public interface MyIDictionary<T, T1> {
    public void addElement(T key, T1 value);

    public void clear();

    public Value lookup(String token);

    public boolean isDefined(T id) ;

    public Value getValue(T id);

    public void update(T id, T1 val);
}
