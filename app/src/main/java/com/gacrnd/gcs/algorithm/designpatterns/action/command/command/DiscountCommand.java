package com.gacrnd.gcs.algorithm.designpatterns.action.command.command;


import com.gacrnd.gcs.algorithm.designpatterns.action.command.Command;
import com.gacrnd.gcs.algorithm.designpatterns.action.command.handler.DiscountHandler;

public class DiscountCommand extends Command {

    private DiscountHandler handler = new DiscountHandler();

    @Override
    public String execute() {
        return handler.getDiscounts();
    }
}
