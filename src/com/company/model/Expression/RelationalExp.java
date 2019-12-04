package com.company.model.Expression;

import com.company.model.AbstractDataTypes.MyException;
import com.company.model.AbstractDataTypes.MyIDictionary;
import com.company.model.Types.BoolType;
import com.company.model.Types.IntType;
import com.company.model.Values.BoolValue;
import com.company.model.Values.IntValue;
import com.company.model.Values.Value;

public class RelationalExp implements Exp {
    private Exp expression1;
    private Exp expression2;
    private String relation;

    @Override
    public Value eval(MyIDictionary<String, Value> tbl) throws MyException {
        Value v1, v2;
        v1 = expression1.eval(tbl);
        if (v1.getType().equals(new IntType())) {
            v2 = expression2.eval(tbl);
            if (v2.getType().equals(new IntType())) {
                IntValue i1 = (IntValue) v1;
                IntValue i2 = (IntValue) v2;
                int n1, n2;
                n1 = i1.getVal();
                n2 = i2.getVal();
                if (relation.equals("==")) return new BoolValue(n1 == n2);
                else if (relation.equals("<=")) return new BoolValue(n1 <= n2);
                else if (relation.equals("<")) return new BoolValue(n1 < n2);
                else if (relation.equals(">=")) return new BoolValue(n1 >= n2);
                else if (relation.equals(">")) return new BoolValue(n1 > n2);
                else if (relation.equals("!=")) return new BoolValue(n1 != n2);

                else  throw new MyException("invalid operant");

            } else
                throw new MyException("second operand is not an int");
        } else
            throw new MyException("first operand is not an int");
    }
}
