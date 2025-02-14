package com.company.model;


import com.company.model.AbstractDataTypes.*;
import com.company.model.Statements.IStmt;
import com.company.model.Types.StringType;
import com.company.model.Values.StringValue;
import com.company.model.Values.Value;

import java.io.BufferedReader;
import java.io.File;
import java.util.HashMap;

public class PrgState {
    private MyIStack<IStmt> exeStack;
    private MyIDictionary<String, Value> symTable;
    private MyIList<Value> out;
    private MyIDictionary<StringValue, BufferedReader> FileTable;
    private MyIHeap<Integer, Value> Heap;

    IStmt originalProgram; //optional field, but good to have
    public PrgState(MyIStack<IStmt> stk, MyIDictionary<String,Value> symtbl, MyIList<Value> ot, MyIDictionary<StringValue,BufferedReader> ift){
        exeStack=stk;
        symTable=symtbl;
        out = ot;
        FileTable = ift;
        //originalProgram=deepCopy(prg);//recreate the entire original prg
    }
    public PrgState(IStmt stmt){
        exeStack = new MyStack<>();
        symTable = new MyDictionary<>();
        out = new MyList<>();
        FileTable = new MyDictionary<>();
        Heap = new MyHeap<>();
        exeStack.push(stmt);
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

    public MyIDictionary<StringValue, BufferedReader> getFileTable() {
        return FileTable;
    }

    public MyIHeap<Integer,Value> getHeap(){
        return Heap;
    }

    public void reset() throws MyException {
        this.exeStack = new MyStack<IStmt>();
        this.symTable = new MyDictionary<String, Value>();
        this.out = new MyList<Value>();
        this.exeStack.push(this.originalProgram.deepcopy());
        this.FileTable = new MyDictionary<StringValue, BufferedReader>();
        this.Heap = new MyHeap<Integer, Value>();
    }
}

