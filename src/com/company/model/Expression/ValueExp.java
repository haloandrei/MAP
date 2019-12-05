package com.company.model.Expression;

import com.company.model.AbstractDataTypes.MyDictionary;
import com.company.model.AbstractDataTypes.MyException;
import com.company.model.AbstractDataTypes.MyIDictionary;
import com.company.model.AbstractDataTypes.MyIHeap;
import com.company.model.Values.Value;

public class ValueExp implements Exp {
    private Value e;

    public ValueExp(Value newValue) {
        e = newValue;
    }

    public Value eval(MyIDictionary<String, Value> tbl) {return e;}

    @Override
    public Value eval(MyIDictionary<String, Value> tb1, MyIHeap<Integer, Value> tb2) throws MyException {
        return null;
    }

    @Override
    public Exp deepcopy() {
        return new ValueExp(e);
    }

    @Override
    public String toString() {
        return "ValueExp{" +
                "e=" + e.toString() +
                '}';
    }
}
