package com.gacrnd.gcs.algorithm.designpatterns.create.fatory.fatoryMethod;


import com.gacrnd.gcs.algorithm.designpatterns.entity.Bag;
import com.gacrnd.gcs.algorithm.designpatterns.entity.bag.BananaBag;

/**
 * 工厂方法模式
 */
public class BananaBagFactory implements BagFactory{
    public Bag getBag(){
        return new BananaBag();
    }
}
