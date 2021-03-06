package com.gacrnd.gcs.algorithm.designpatterns.entity.fruit;


import com.gacrnd.gcs.algorithm.designpatterns.action.visit.Visit;
import com.gacrnd.gcs.algorithm.designpatterns.entity.Fruit;
import com.gacrnd.gcs.algorithm.designpatterns.entity.bag.BananaBag;

/**
 * 桔子
 * Created by Peter on 10/9 009.
 */
public class Banana implements Fruit {
    private int price = 60;
    @Override
    public int price() {
        return price;
    }

    public void pack(BananaBag bag){
        bag.pack();
    }
    @Override
    public void draw() {
        System.out.print("仙人蕉");
    }

    @Override
    public int accept(Visit visit){
        return visit.sell(this);
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
