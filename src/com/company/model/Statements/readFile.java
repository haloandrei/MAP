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
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class readFile implements IStmt {

    private Exp exp;
    private Exp lineReadVariable;

    public readFile(Exp inputExpression,Exp inputVariableName){
        exp = inputExpression;
        lineReadVariable = inputVariableName;
    }

    public PrgState execute(PrgState state) {
        MyIStack<IStmt> stk = state.getStk();
        MyIDictionary<String, Value> symTbl = state.getSymTable();
        MyIDictionary<StringValue, BufferedReader> fileTable = state.getFileTable();
        Value value=exp.eval(symTbl);
        Value lineInFile = lineReadVariable.eval(symTbl);
        if(lineInFile.getType().equals(new IntType())){
            if(value.getType().equals(new StringType())) {
                StringValue value1 = (StringValue) value;
                if (((MyDictionary)fileTable).isDefinedBuffer(value1)) {
                    try {
                        BufferedReader file = (BufferedReader) ((MyDictionary)fileTable).lookupBuffer(value1);
                        String content = file.readLine();
                        int newVal = 0;
                        if (content != null) {
                            newVal = Integer.parseInt(content);
                        }
                        symTbl.update(((VarExp)lineReadVariable).getId(),new IntValue(newVal));
                    } catch (IOException e) {
                        e.printStackTrace();
                        throw new MyException("IOException incoming: read fail");
                    }
                } else throw new MyException("file not open");
            }
            else throw new MyException("path not string");
        }
        else throw new MyException("file line position not int");
        return state;
    }

    @Override
    public String toString() {
        return "readFile{" +
                "exp=" + exp.toString() +
                ", lineReadVariable=" + lineReadVariable.toString() +
                '}';
    }
}
