package com.company.model.view;


import com.company.Controller;
import com.company.model.AbstractDataTypes.MyException;

import java.io.IOException;

public class RunExampleCommand extends Command {
    private Controller controller;

    public RunExampleCommand(String key, String description, Controller controller){
        super(key,description);
        this.controller = controller;
    }

    @Override
    public void execute() {
        try{
            controller.allStep(true);
        } catch (MyException | IOException e) {
            System.out.println(e.getMessage());
        }
    }
}