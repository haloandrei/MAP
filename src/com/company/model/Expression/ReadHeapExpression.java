package com.company.model.Expression;

import com.company.model.AbstractDataTypes.MyException;
import com.company.model.AbstractDataTypes.MyIDictionary;
import com.company.model.AbstractDataTypes.MyIHeap;
import com.company.model.Values.RefValue;
import com.company.model.Values.Value;

public class ReadHeapExpression implements Exp {
    private Exp expression;

    public ReadHeapExpression(Exp expression){
        this.expression = expression;
    }

    @Override
    public Value eval(MyIDictionary<String, Value> tbl) throws MyException {
        return null;
    }

    @Override
    public Value eval(MyIDictionary<String, Value> table, MyIHeap<Integer, Value> heapTable) throws MyException {
        Value value = expression.eval(table, heapTable);

        if(!(value instanceof RefValue)){
            throw new MyException("Failed to read from heap. Value not of reference type!");
        }

        Integer address = ((RefValue) value).getAddress();

        if(!heapTable.isDefined(address)){
            throw new MyException("Failed to read from heap. Value not assigned!");
        }

        return heapTable.getValue(address);
    }

    @Override
    public Exp deepcopy() throws MyException {
        return new ReadHeapExpression(expression.deepcopy());
    }

    @Override
    public String toString(){
        return "Read(" + expression.toString() + ")";
    }
}
