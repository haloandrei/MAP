package com.company;

import com.company.model.*;
import com.company.model.AbstractDataTypes.*;
import com.company.model.Repository.Repository;
import com.company.model.Statements.IStmt;
import com.company.model.Values.Value;

public class Main {

    public static void main(String[] args) {
        MyIDictionary<String, Value> dictionary = new MyDictionary<String, Value>();
        MyList<Value> list = new MyList<Value>();
        MyIStack<IStmt> stack = new MyStack<>();
        PrgState prg = new PrgState(stack,dictionary,list,new MyDictionary<>());
        MyIList<PrgState> repoList = new MyList<PrgState>();
        Repository repository = new Repository(repoList);
        repoList.add(prg);
        Controller controller = new Controller(repository);
        Ui ui = new Ui(controller);
        ui.start();

    }
}
