package com.company.model.Statements;

import com.company.model.AbstractDataTypes.MyException;
import com.company.model.AbstractDataTypes.MyIDictionary;
import com.company.model.AbstractDataTypes.MyIHeap;
import com.company.model.AbstractDataTypes.MyIStack;
import com.company.model.Expression.Exp;
import com.company.model.PrgState;
import com.company.model.Types.BoolType;
import com.company.model.Values.BoolValue;
import com.company.model.Values.Value;

public class WhileStmt implements IStmt {
    private Exp expression;
    private IStmt statement;
    public WhileStmt(Exp expression, IStmt statement){
        this.expression = expression;
        this.statement = statement;
    }


    @Override
    public PrgState execute(PrgState state) throws MyException {
        MyIStack<IStmt> stack = state.getStk();
        MyIDictionary symbolTable = state.getSymTable();
        MyIHeap<Integer, Value> heapTable = state.getHeap();
        Value value = expression.eval(symbolTable, heapTable);
        if(value.getType() != new BoolType()){
            if(((BoolValue) value).getVal() == false){
                return state;
            }else{
                stack.push(this);
                stack.push(statement);
            }
        }else throw new MyException("Conditional expression is not a boolean value");
        return null;
    }

    @Override
    public IStmt deepcopy() throws MyException {
        return new WhileStmt(this.expression.deepcopy(), this.statement.deepcopy());
    }

    @Override
    public String toString(){
        return "while(" + expression.toString() + ")execute(" + this.statement.toString() + ")";
    }
}
