package com.company;

import com.company.model.Expression.ArithExp;
import com.company.model.Expression.ValueExp;
import com.company.model.Expression.VarExp;
import com.company.model.Statements.*;
import com.company.model.Types.BoolType;
import com.company.model.Types.IntType;
import com.company.model.Values.BoolValue;
import com.company.model.Values.IntValue;

public class Ui {
    Controller controller;

    public Ui (Controller c){
        controller = c;
    }

    public void start() {
        //int v; v=2;Print(v) is represented as:
        IStmt ex1 = new CompStmt(new VarDeclStmt("v", new IntType()),
                new CompStmt(new AssignStmt("v", new ValueExp(new IntValue(2))), new PrintStmt(new VarExp("v"))));

        //int a;int b; a=2+3*5;b=a+1;Print(b) is represented as:
        IStmt ex2 = new CompStmt( new VarDeclStmt("a",new IntType()),
                new CompStmt(new VarDeclStmt("b",new IntType()),
                        new CompStmt(new AssignStmt("a", new ArithExp('+',new ValueExp(new IntValue(2)),new
                                ArithExp('*',new ValueExp(new IntValue(3)), new ValueExp(new IntValue(5))))),
                                new CompStmt(new AssignStmt("b",new ArithExp('+',new VarExp("a"), new
                                        ValueExp(new IntValue(1)))), new PrintStmt(new VarExp("b"))))));

        // bool a; int v; a=true;(If a Then v=2 Else v=3);Print(v) is represented as
        IStmt ex3 = new CompStmt(new VarDeclStmt("a",new BoolType()),
                new CompStmt(new VarDeclStmt("v", new IntType()),
                        new CompStmt(new AssignStmt("a", new ValueExp(new BoolValue(true))),
                                new CompStmt(new IfStmt(new VarExp("a"),new AssignStmt("v",new ValueExp(new
                                        IntValue(2))), new AssignStmt("v", new ValueExp(new IntValue(3)))), new PrintStmt(new
                                        VarExp("v"))))));

        controller.getRepo().getCrtPrgState().addIStmt(ex3);
        controller.allStep(true);
    }
}
