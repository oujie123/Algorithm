package com.gacrnd.gcs.algorithm.designpatterns.action.command.command;


import com.gacrnd.gcs.algorithm.designpatterns.action.command.Command;
import com.gacrnd.gcs.algorithm.designpatterns.action.command.handler.HotHandler;

public class HotCommand extends Command {
    private HotHandler handler = new HotHandler();

    @Override
    public String execute() {
        return handler.getHots();
    }
}
