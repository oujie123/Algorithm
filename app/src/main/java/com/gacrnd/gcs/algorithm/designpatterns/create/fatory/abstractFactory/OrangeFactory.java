package com.gacrnd.gcs.algorithm.designpatterns.create.fatory.abstractFactory;

import com.gacrnd.gcs.algorithm.designpatterns.entity.Bag;
import com.gacrnd.gcs.algorithm.designpatterns.entity.Fruit;
import com.gacrnd.gcs.algorithm.designpatterns.entity.bag.OrangeBag;
import com.gacrnd.gcs.algorithm.designpatterns.entity.fruit.Orange;

/**
 * 水果工厂
 */
public class OrangeFactory extends AbstractFactory{

    @Override
    public Fruit getFruit() {
        return new Orange("Peter",50);
    }

    @Override
    public Bag getBag() {
        return new OrangeBag();
    }
}
