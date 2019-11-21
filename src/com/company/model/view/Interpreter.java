package com.company.model.view;

import com.company.Controller;
import com.company.model.AbstractDataTypes.MyException;
import com.company.model.ExitCommand;
import com.company.model.Expression.ArithExp;
import com.company.model.Expression.ValueExp;
import com.company.model.Expression.VarExp;
import com.company.model.PrgState;
import com.company.model.Repository.IRepository;
import com.company.model.Repository.Repository;
import com.company.model.Statements.*;
import com.company.model.Types.BoolType;
import com.company.model.Types.IntType;
import com.company.model.Types.StringType;
import com.company.model.Values.BoolValue;
import com.company.model.Values.IntValue;
import com.company.model.Values.StringValue;

public class Interpreter {
    private Controller controller;

    public Interpreter(){}

    public Interpreter(Controller controller){
        this.controller = controller;
    }

    public static void main(String[] args){
        try {
            IStmt example1 = programOne();
            PrgState program1 = new PrgState(example1);
            IRepository repository1 = new Repository("log1.txt");
            Controller controller1 = new Controller(repository1);
            controller1.addProgram(program1);


            IStmt example2 = programTwo();

            PrgState program2 = new PrgState(example2);
            IRepository repository2 = new Repository("log2.txt");
            ((Repository) repository2).pushPrgStmt(program2);
            Controller controller2 = new Controller(repository2);
            controller2.addProgram(program2);

            IStmt example3 = programThree();
            PrgState program3 = new PrgState(example3);
            IRepository repository3 = new Repository("log3.txt");
            ((Repository) repository3).pushPrgStmt(program3);
            Controller controller3 = new Controller(repository3);
            controller3.addProgram(program3);

            IStmt example4 = programFour();
            PrgState program4 = new PrgState(example4);
            IRepository repository4 = new Repository("log4.txt");
            ((Repository) repository4).pushPrgStmt(program4);
            Controller controller4 = new Controller(repository4);
            controller4.addProgram(program4);

            TextMenu menu = new TextMenu();
            menu.addCommand(new ExitCommand("0", "Exit"));
            menu.addCommand(new RunExampleCommand("1", example1.toString(), controller1));
            menu.addCommand(new RunExampleCommand("2", example2.toString(), controller2));
            menu.addCommand(new RunExampleCommand("3", example3.toString(), controller3));
            menu.addCommand(new RunExampleCommand("4", example4.toString(), controller4));
            menu.show();
        }catch (MyException exception){
            System.out.println(exception.getMessage());
        }
        //TODO comparators, files and more examples
    }


    private static IStmt programOne(){
        return new CompStmt(new VarDeclStmt("v", new IntType()),
                new CompStmt(new AssignStmt("v", new ValueExp(new IntValue(2))), new PrintStmt(new VarExp("v"))));
    }

    private static IStmt programTwo() throws MyException {
        return new CompStmt(new VarDeclStmt("a", new IntType()), new CompStmt(new VarDeclStmt("b", new IntType()), new CompStmt(new AssignStmt("a", new ArithExp('+', new ValueExp(new IntValue(2)), new ArithExp('*', new ValueExp(new IntValue(3)), new ValueExp(new IntValue(5))))), new CompStmt(new AssignStmt("b", new ArithExp('+', new VarExp("a"), new ValueExp(new IntValue(1)))),
                new PrintStmt(new VarExp("b"))))));
    }

    private static IStmt programThree() {
        return new CompStmt(new VarDeclStmt("a",new BoolType()), new CompStmt(new VarDeclStmt("v", new IntType()),new CompStmt(new AssignStmt("a", new ValueExp(new BoolValue(true)))
                , new CompStmt(new IfStmt(new VarExp("a"),new AssignStmt("v",new ValueExp(new IntValue(2))), new AssignStmt("v", new ValueExp(new IntValue(3)))), new PrintStmt(new VarExp("v"))))));
    }

    private static IStmt programFour(){
        return new CompStmt(
                new VarDeclStmt("varf",new StringType()),new CompStmt(
                new AssignStmt("varf",new ValueExp(new StringValue("test.in"))),new CompStmt(
                new openRFile(new VarExp("varf")),new CompStmt(
                new VarDeclStmt("varc",new IntType()),new CompStmt(
                new readFile(new VarExp("varf"),new VarExp("varc")),new CompStmt(
                new PrintStmt(new VarExp("varc")),new CompStmt(
                new readFile(new VarExp("varf"),new VarExp("varc")) ,new CompStmt(new PrintStmt(new VarExp("varc")),new closeRFile(new VarExp("varf"))))))))));
    }
}