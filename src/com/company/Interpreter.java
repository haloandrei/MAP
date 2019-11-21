package com.company;

import com.company.model.ExitCommand;
import com.company.model.PrgState;
import com.company.model.Repository.IRepository;
import com.company.model.Repository.Repository;
import com.company.model.Statements.IStmt;
import com.company.model.TextMenu;

class Interpreter {
    public static void main(String[] args) {
        IStmt ex1=new ....;
        PrgState prg1 = new PrgState(..., ex1);
        IRepository repo1 = new Repository(prg1,"log1.txt");
        Controller ctr1 = new Controller(repo1);
        IStmt ex2=new ....;
        PrgState prg2 = new PrgState(..., ex2);
        IRepository repo2 = new Repository(prg2,"log2.txt");
        Controller ctr2 = new Controller(repo2);
        IStmt ex3= new ...;
        PrgState prg3 = new PrgState(..., ex3);
        IRepository repo3 = new Repository(prg3,"log3.txt");
        Controller ctr3 = new Controller(repo3);
        TextMenu menu = new TextMenu();
        menu.addCommand(new ExitCommand("0", "exit"));
        menu.addCommand(new RunExample("1",ex1.toString(),ctr1));
        menu.addCommand(new RunExample("2",ex2.toString(),ctr2));
        menu.addCommand(new RunExample("3",ex3.toString(),ctr3));
        menu.show();
    }
