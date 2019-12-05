package com.company.model.Statements;

import com.company.model.AbstractDataTypes.MyException;
import com.company.model.AbstractDataTypes.MyIDictionary;
import com.company.model.AbstractDataTypes.MyIHeap;
import com.company.model.Expression.Exp;
import com.company.model.PrgState;
import com.company.model.Types.RefType;
import com.company.model.Values.RefValue;
import com.company.model.Values.Value;

public class NewStmt implements IStmt {
    private String variableName;
    private Exp expression;

    public NewStmt(String variableName, Exp expression){
        this.variableName = variableName;
        this.expression = expression;
    }

    @Override
    public PrgState execute(PrgState state) throws MyException {
        MyIDictionary<String, Value> symbolTable = state.getSymTable();
        MyIHeap<Integer, Value> heapTable = state.getHeap();
        Value value = expression.eval(symbolTable, heapTable);

        if (!symbolTable.isDefined(variableName)) {
            throw new MyException("Failed to allocate. The variable " + variableName + " was not defined!");
        }

        if (!(((Value) symbolTable.getValue(variableName)).getType() instanceof RefType)) {
            throw new MyException("Failed to allocate. The type is not a reference!");
        }

        RefValue valueInSymbolTable = (RefValue) symbolTable.getValue(variableName);

        if (!value.getType().equals(valueInSymbolTable.getLocationType())) {
            throw new MyException("Failed to allocate. The variables are not of the same type!");
        }

        RefValue valueToPutInTable = new RefValue((Integer) heapTable.getCurrentFree(), value.getType());
        valueToPutInTable.setAddress((Integer) heapTable.getCurrentFree());
        symbolTable.update(variableName, valueToPutInTable);
        heapTable.update(value);
        return null;
    }

    public IStmt deepcopy() throws MyException {
        return new NewStmt(variableName, expression.deepcopy());
    }

    @Override
    public String toString(){
        return "New(" + variableName + "->" + expression.toString() + ")";
    }
}
