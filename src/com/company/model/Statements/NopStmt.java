package com.company.model.Statements;

import com.company.model.PrgState;
import com.company.model.Statements.IStmt;

public class NopStmt implements IStmt {
    @Override
    public PrgState execute(PrgState state) {
        return state;
    }
}
