package com.company.model.Statements;

import com.company.model.AbstractDataTypes.MyException;
import com.company.model.AbstractDataTypes.MyIDictionary;
import com.company.model.AbstractDataTypes.MyIHeap;
import com.company.model.Expression.Exp;
import com.company.model.Expression.ReadHeapExpression;
import com.company.model.PrgState;
import com.company.model.Types.RefType;
import com.company.model.Values.RefValue;
import com.company.model.Values.Value;

public class WriteHeapStmt implements IStmt{
        private String variableName;
        private Exp expression;

        public WriteHeapStmt(String variableName, Exp expression){
            this.variableName = variableName;
            this.expression = expression;
        }

        public WriteHeapStmt(ReadHeapExpression a) {
        }

        @Override
        public PrgState execute(PrgState state) throws MyException {
            MyIDictionary<String, Value> symbolTable = state.getSymTable();
            MyIHeap<Integer, Value> heapTable = state.getHeap();

            if(!symbolTable.isDefined(variableName)){
                throw new MyException("Failed to write to heap. Variable name not defined!");
            }


            Value oldValue = symbolTable.getValue(variableName);

            if(!(oldValue.getType() instanceof RefType)){
                throw new MyException("Failed to write to heap. Type is not reference!");
            }

            if(!heapTable.isDefined(((RefValue) oldValue).getAddress())){
                throw new MyException("Failed to write to heap. Address not defined!");
            }

            Value newValue = expression.eval(symbolTable, heapTable);

            if(!newValue.getType().equals(((RefValue) oldValue).getLocationType())){
                throw new MyException("Failed to write to heap. Type of new value is wrong!");
            }

            heapTable.update(((RefValue) oldValue).getAddress(), newValue);
            return null;
        }

        @Override
        public IStmt deepcopy() {
            return new WriteHeapStmt(this.variableName, this.expression.deepcopy());
        }

        @Override
        public String toString(){
            return "(" + variableName + "->" + expression.toString() + ")";
        }
}
