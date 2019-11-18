package com.company;

import com.company.model.AbstractDataTypes.MyException;
import com.company.model.AbstractDataTypes.MyIList;
import com.company.model.PrgState;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Vector;

public class Repository implements IRepository{

    private MyIList<PrgState> Memory;
    private String logFilePath;

    Repository(MyIList<PrgState> newMem){
       Memory = newMem;
    }

    PrgState getCrtPrgState(){
        return Memory.get(Memory.size()-1);
    }
    public void pushPrgStmt(PrgState prgState){
        Memory.add(prgState);
    }

    @Override
    public void logPrgStateExec() throws MyException, IOException {
        PrintWriter logFile = new PrintWriter(new BufferedWriter(new FileWriter(logFilePath, true)));
        #i m just gonna 
    }
}
