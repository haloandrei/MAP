package com.company.model.Expression;

import com.company.model.AbstractDataTypes.MyException;
import com.company.model.AbstractDataTypes.MyDictionary;
import com.company.model.AbstractDataTypes.MyIDictionary;
import com.company.model.Types.BoolType;
import com.company.model.Values.BoolValue;
import com.company.model.Values.Value;

public class LogicExp implements Exp {
    Exp e1;
    Exp e2;
    int op;
    @Override
    public Value eval(MyIDictionary<String,Value> tbl) throws MyException {
        Value v1, v2;
        v1 = e1.eval(tbl);
        if (v1.getType().equals(new BoolType())) {
            v2 = e2.eval(tbl);
            if (v2.getType().equals(new BoolType())) {
                BoolValue i1 = (BoolValue) v1;
                BoolValue i2 = (BoolValue) v2;
                boolean n1, n2;
                n1 = i1.getVal();
                n2 = i2.getVal();
                if (op == '&') return new BoolValue(n1 && n2);
                else if (op == '|') return new BoolValue(n1 | n2);
                else  throw new MyException("invalid operant");

            } else
                throw new MyException("second operand is not an boolean");
        } else
            throw new MyException("first operand is not an boolean");}

    @Override
    public String toString() {
        return "LogicExp{" +
                "e1=" + e1 +
                ", e2=" + e2 +
                ", op=" + op +
                '}';
    }
}
