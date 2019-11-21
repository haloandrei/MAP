package com.company.model.Statements;

import com.company.model.AbstractDataTypes.MyException;
import com.company.model.AbstractDataTypes.MyIDictionary;
import com.company.model.PrgState;
import com.company.model.Statements.IStmt;
import com.company.model.Types.BoolType;
import com.company.model.Types.IntType;
import com.company.model.Types.StringType;
import com.company.model.Types.Type;
import com.company.model.Values.BoolValue;
import com.company.model.Values.IntValue;
import com.company.model.Values.StringValue;
import com.company.model.Values.Value;

public class VarDeclStmt implements IStmt {
    private String value;
    private Type type;
    public VarDeclStmt(String v, Type newType) {
        value = v;
        type = newType;
    }
    @Override
    public PrgState execute(PrgState state) throws MyException {

        MyIDictionary<String, Value> symTbl = state.getSymTable();
        if (type.equals(new BoolType())) {
            BoolType boolType = new BoolType();
            symTbl.addElement(value, new BoolValue(true));
        } else if (type.equals(new IntType())) {
            IntType intType = new IntType();
            symTbl.addElement(value, new IntValue(0));

        } else if (type.equals(new StringType())) {
        StringType intType = new StringType();
        symTbl.addElement(value, new StringValue(""));

    }
        return state;
    }

    @Override
    public String toString() {
        return "VarDeclStmt{" +
                "value='" + value + '\'' +
                ", type=" + type +
                '}';
    }
}
