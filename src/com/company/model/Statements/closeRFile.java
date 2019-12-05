package com.company.model.Statements;

import com.company.model.AbstractDataTypes.MyDictionary;
import com.company.model.AbstractDataTypes.MyException;
import com.company.model.AbstractDataTypes.MyIDictionary;
import com.company.model.AbstractDataTypes.MyIStack;
import com.company.model.Expression.Exp;
import com.company.model.Expression.VarExp;
import com.company.model.PrgState;
import com.company.model.Types.IntType;
import com.company.model.Types.StringType;
import com.company.model.Values.IntValue;
import com.company.model.Values.StringValue;
import com.company.model.Values.Value;

import java.io.BufferedReader;
import java.io.IOException;

public class closeRFile implements IStmt {
    private Exp exp;

    public closeRFile(Exp inputExp){
        exp = inputExp;
    }
    public PrgState execute(PrgState state) {
        MyIStack<IStmt> stk = state.getStk();
        MyIDictionary<String, Value> symTbl = state.getSymTable();
        MyIDictionary<StringValue, BufferedReader> fileTable = state.getFileTable();
        Value value=exp.eval(symTbl);
        if(value.getType().equals(new StringType())) {
                StringValue value1 = (StringValue) value;
                if (((MyDictionary)fileTable).isDefinedBuffer(value1)) {
                    try {
                        BufferedReader file = (BufferedReader) ((MyDictionary)fileTable).lookupBuffer(value1);
                        file.close();
                        ((MyDictionary)fileTable).remove(value1);
                    } catch (IOException e) {
                        e.printStackTrace();
                        throw new MyException("IOException incoming: close fail");
                    }
                } else throw new MyException("file not defined");
            }
            else throw new MyException("path not string");
        return state;
    }

    @Override
    public IStmt deepcopy() {
        return new closeRFile(exp);
    }

    @Override
    public String toString() {
        return "closeRFile{" +
                "exp=" + exp.toString() +
                '}';
    }
}
