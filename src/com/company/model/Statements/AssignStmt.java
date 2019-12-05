package com.company.model.Statements;

import com.company.model.*;
import com.company.model.AbstractDataTypes.MyDictionary;
import com.company.model.AbstractDataTypes.MyException;
import com.company.model.AbstractDataTypes.MyIDictionary;
import com.company.model.AbstractDataTypes.MyIStack;
import com.company.model.Expression.Exp;
import com.company.model.Types.Type;
import com.company.model.Values.Value;

public class AssignStmt implements IStmt {
    String id;
    Exp exp;

    public AssignStmt(String v, Exp valueExp) {
        id = v;
        exp = valueExp;
    }

    public String toString(){ return id + "="+ exp.toString();}
    public PrgState execute(PrgState state){
        MyIStack<IStmt> stk=state.getStk();
        MyIDictionary<String, Value> symTbl= state.getSymTable();
        Value val = exp.eval(symTbl);
        if (symTbl.isDefined(id))
            {
                Type typId = (symTbl.getValue(id)).getType();
                if (val.getType().equals(typId))
                    symTbl.update(id, val);
                else
                    throw new MyException("declared type of variable" + id + " and type of the assigned expression do not match");
            }
        else throw new MyException("the used variable " +id + " was not declared before");
            return state;
    }

    @Override
    public IStmt deepcopy() {
        return new AssignStmt(id, exp);
    }
}
