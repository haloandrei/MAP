package com.company.model.Expression;

import com.company.model.AbstractDataTypes.MyDictionary;
import com.company.model.AbstractDataTypes.MyIDictionary;
import com.company.model.Values.Value;

public class ValueExp implements Exp {
    Value e;

    public ValueExp(Value newValue) {
        e = newValue;
    }

    public Value eval(MyIDictionary<String, Value> tbl) {return e;}

    @Override
    public String toString() {
        return "ValueExp{" +
                "e=" + e.toString() +
                '}';
    }
}
