package com.gacrnd.gcs.algorithm.designpatterns.action.observer.jdk;

import java.util.Observable;

public class Mango extends Observable {
    private String name;

    public Mango(String name){
        this.name = name;
    }

    //芒果到货了
    public void perform(){
        this.setChanged();
        this.notifyObservers();
    }
}
