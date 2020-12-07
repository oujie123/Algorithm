package com.gacrnd.gcs.algorithm.designpatterns.action.command.command;


import com.gacrnd.gcs.algorithm.designpatterns.action.command.Command;
import com.gacrnd.gcs.algorithm.designpatterns.action.command.handler.NewerHandler;

public class NewerCommand extends Command {
    private NewerHandler handler = new NewerHandler();

    @Override
    public String execute() {
        return handler.getNewers();
    }
}
