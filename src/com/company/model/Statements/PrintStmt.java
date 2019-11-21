package com.company.model.Statements;

import com.company.model.AbstractDataTypes.MyIDictionary;
import com.company.model.AbstractDataTypes.MyIList;
import com.company.model.Expression.Exp;
import com.company.model.PrgState;
import com.company.model.Expression.VarExp;
import com.company.model.Values.Value;

public class PrintStmt implements IStmt {
    private Exp exp;

    public PrintStmt(VarExp v) {
        this.exp = v;
    }

    public String toString(){ return "print(" +exp.toString()+");";}
    public PrgState execute(PrgState state){
        MyIDictionary<String, Value> dictionary = state.getSymTable();
        MyIList<Value> list = state.getOut();
        list.add(exp.eval(dictionary));
        return state;
    }
}
