package com.company.model.Expression;

import com.company.model.AbstractDataTypes.MyException;
import com.company.model.AbstractDataTypes.MyDictionary;
import com.company.model.AbstractDataTypes.MyIDictionary;
import com.company.model.Types.IntType;
import com.company.model.Values.IntValue;
import com.company.model.Values.Value;

public class ArithExp implements Exp {
    Exp e1;
    Exp e2;
    char op; //1-plus, 2-minus, 3-star, 4-divide

    public ArithExp(char c, Exp valueExp, Exp valueExp1) {
        e1 = valueExp;
        e2 = valueExp1;
        op = c;
    }

    @Override
    public String toString() {
        return e1.toString() + " " + op + " " + e2.toString();
    }

    //override
    public Value eval(MyIDictionary<String, Value> tbl) throws MyException {
        Value v1, v2;
        v1 = e1.eval(tbl);
        if (v1.getType().equals(new IntType())) {
            v2 = e2.eval(tbl);
            if (v2.getType().equals(new IntType())) {
                IntValue i1 = (IntValue) v1;
                IntValue i2 = (IntValue) v2;
                int n1, n2;
                n1 = ((IntValue) v1).getVal();
                n2 = ((IntValue) v2).getVal();
                if (op == '+') return new IntValue(n1 + n2);
                if (op == '-') return new IntValue(n1 - n2);
                if (op == '*') return new IntValue(n1 * n2);
                if (op == '/')
                    if (n2 == 0) throw new MyException("division by zero");
                    else return new IntValue(n1 / n2);
            } else
                throw new MyException("second operand is not an integer");
        } else
            throw new MyException("first operand is not an integer");
        throw  new MyException("All hope is lost");
    }
}