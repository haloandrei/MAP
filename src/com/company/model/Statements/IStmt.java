package com.company.model.Statements;

import com.company.model.PrgState;

public interface IStmt {
    PrgState execute(PrgState state);
    IStmt deepcopy();
}
