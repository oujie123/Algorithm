package com.gacrnd.gcs.algorithm.designpatterns.create.fatory.abstractFactory;

import com.gacrnd.gcs.algorithm.designpatterns.entity.Bag;
import com.gacrnd.gcs.algorithm.designpatterns.entity.Fruit;
import com.gacrnd.gcs.algorithm.designpatterns.entity.bag.BananaBag;
import com.gacrnd.gcs.algorithm.designpatterns.entity.fruit.Banana;

/**
 * 水果工厂
 */
public class BananaFactory extends AbstractFactory{

    @Override
    public Fruit getFruit() {
        return new Banana();
    }

    @Override
    public Bag getBag() {
        return new BananaBag();
    }
}
