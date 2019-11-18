package com.company.model;


import com.company.model.AbstractDataTypes.*;
import com.company.model.Statements.IStmt;
import com.company.model.Values.Value;

public class PrgState {
    MyIStack<IStmt> exeStack;
    MyIDictionary<String, Value> symTable;
    MyIList<Value> out;
    IStmt originalProgram; //optional field, but good to have
    public PrgState(MyIStack<IStmt> stk, MyIDictionary<String,Value> symtbl, MyIList<Value> ot){
        exeStack=stk;
        symTable=symtbl;
        out = ot;
        //originalProgram=deepCopy(prg);//recreate the entire original prg
    }
    public void addIStmt(IStmt st) {exeStack.push(st);}

    public MyIStack<IStmt> getStk() {
        return exeStack;
    }

    public MyIDictionary<String, Value> getSymTable() {
        return symTable;
    }

    public MyIList<Value> getOut() {
        return out;
    }

    @Override
    public String toString() {
        return " exeStack=" + exeStack.toString() +
                "\n, symTable=" + symTable.toString() +
                "\n, out=" + out.toString() +"\n";
    }
}

