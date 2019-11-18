package com.company.model.Expression;

import com.company.model.AbstractDataTypes.MyDictionary;
import com.company.model.AbstractDataTypes.MyException;
import com.company.model.AbstractDataTypes.MyIDictionary;
import com.company.model.Values.Value;

public class VarExp implements Exp {
    String id;

    public VarExp(String v) {
        id = v;
    }

    @Override
    public Value eval(MyIDictionary<String, Value> tbl) throws MyException
        {
            return tbl.lookup(id);
        }

    @Override
    public String toString() {
        return "VarExp{" +
                "id='" + id + '\'' +
                '}';
    }
}

