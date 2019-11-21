package com.company.model.Repository;

import com.company.model.AbstractDataTypes.MyException;

import java.io.IOException;

public interface IRepository {
    void logPrgStateExec() throws MyException, IOException;
}
