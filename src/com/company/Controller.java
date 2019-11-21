package com.company;

import com.company.model.AbstractDataTypes.MyException;
import com.company.model.AbstractDataTypes.MyIStack;
import com.company.model.PrgState;
import com.company.model.Repository.IRepository;
import com.company.model.Repository.Repository;
import com.company.model.Statements.IStmt;

import java.io.IOException;

public class Controller {
    private Repository repo;

    public Controller(IRepository newRepo){
        repo = (Repository) newRepo;
    }



    public PrgState oneStep() throws MyException {
        PrgState state = repo.getCrtPrgState();
        MyIStack<IStmt> stk=state.getStk();
        if(stk.isEmpty()) throw new MyException("prgstate stack is empty");
        IStmt crtStmt = stk.pop();
        return crtStmt.execute(state);
    }
    public void allStep(boolean debug) throws IOException {
        PrgState prg = repo.getCrtPrgState(); // repo is the controller field of type MyRepoInterface
        if (debug)
            System.out.println(prg.toString());//here you can display the prg state
            repo.logPrgStateExec();
        while (!prg.getStk().isEmpty()) {
            oneStep();
            if (debug)
                repo.logPrgStateExec();
                System.out.println(prg.toString());
        }
    }

        public Repository getRepo() {


        return repo;

    }

    public void addProgram(PrgState state){
        repo.pushPrgStmt(state);
    }
}
