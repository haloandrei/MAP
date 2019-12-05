package com.company.model.Expression;

import com.company.model.AbstractDataTypes.MyException;
import com.company.model.AbstractDataTypes.MyDictionary;
import com.company.model.AbstractDataTypes.MyIDictionary;
import com.company.model.AbstractDataTypes.MyIHeap;
import com.company.model.Values.Value;

public interface Exp {
    Value eval(MyIDictionary<String,Value> tbl) throws MyException;
    Value eval(MyIDictionary<String,Value> tb1, MyIHeap<Integer,Value> tb2) throws MyException;

    Exp deepcopy();
}
