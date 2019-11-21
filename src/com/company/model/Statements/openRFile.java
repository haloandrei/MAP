package com.company.model.Statements;

import com.company.model.AbstractDataTypes.MyException;
import com.company.model.AbstractDataTypes.MyIDictionary;
import com.company.model.AbstractDataTypes.MyIStack;
import com.company.model.Expression.Exp;
import com.company.model.PrgState;
import com.company.model.Types.BoolType;
import com.company.model.Types.StringType;
import com.company.model.Values.BoolValue;
import com.company.model.Values.StringValue;
import com.company.model.Values.Value;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Statement;

public class openRFile implements IStmt {

    private Exp exp;
    public  openRFile(Exp expression) {
        exp=expression;
    }
    public PrgState execute(PrgState state) throws MyException{
        MyIStack<IStmt> stk = state.getStk();
        MyIDictionary<String, Value> symTbl = state.getSymTable();
        MyIDictionary<StringValue, BufferedReader> fileTable = state.getFileTable();
        Value value=exp.eval(symTbl);
        if(value.getType().equals(new StringType())){
            StringValue value1=(StringValue) value;
            if(!fileTable.isDefined(value1)){
                try {
                    BufferedReader fileDescriptor = new BufferedReader(new FileReader(value1.getVal()));
                    fileTable.addElement(value1,fileDescriptor);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    throw new MyException("IOException incoming: 404");
                }
            }
            else throw new MyException("file already Opened");

        }
        else throw new MyException("openRF didn t reciev a filePath as expression");
        return state;
    }

    @Override
    public String toString() {
        return "openRFile{" +
                "exp=" + exp.toString() +
                '}';
    }
}
