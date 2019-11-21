package com.company.model.Repository;

import com.company.model.AbstractDataTypes.MyException;
import com.company.model.AbstractDataTypes.MyIList;
import com.company.model.AbstractDataTypes.MyList;
import com.company.model.PrgState;
import com.company.model.Repository.IRepository;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Repository implements IRepository {

    private MyIList<PrgState> Memory;
    private String logFilePath = "";

    //Repository(MyIList<PrgState> newMem){
    //   Memory = newMem;
    //}
    public Repository(String inputFilePath){
        logFilePath = inputFilePath;
        Memory = new MyList<>();
    }
    public Repository(MyIList<PrgState> newMem,String inputFilePath) {
        logFilePath = inputFilePath;
        Memory = newMem;
    }
    public Repository(MyIList<PrgState> newMem){
        Memory = newMem;
    }



    public PrgState getCrtPrgState(){
        return Memory.get(Memory.size()-1);
    }
    public void pushPrgStmt(PrgState prgState){
        Memory.add(prgState);
    }

    @Override
    public void logPrgStateExec() throws MyException, IOException {
        try(PrintWriter logFIle = new PrintWriter(new BufferedWriter(new FileWriter(logFilePath, true)))){
            logFIle.print("Execution Stack: " + Memory.get(0).getStk().toString() + '\n');
            logFIle.print("Symbol table: " + Memory.get(0).getSymTable().toString() + '\n');
            logFIle.print("Out: " + Memory.get(0).getOut().toString() + '\n');
            logFIle.print("Heap table: " + Memory.get(0).getFileTable() + '\n');
            logFIle.print("-------------------" + '\n');
        }catch (IOException error){
            throw new  MyException(error.toString());
        }
    }
}
