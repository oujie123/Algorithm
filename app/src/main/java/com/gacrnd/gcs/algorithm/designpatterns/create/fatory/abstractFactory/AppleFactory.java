package com.gacrnd.gcs.algorithm.designpatterns.create.fatory.abstractFactory;

import com.gacrnd.gcs.algorithm.designpatterns.entity.Bag;
import com.gacrnd.gcs.algorithm.designpatterns.entity.Fruit;
import com.gacrnd.gcs.algorithm.designpatterns.entity.bag.AppleBag;
import com.gacrnd.gcs.algorithm.designpatterns.entity.fruit.Apple;

/**
 * 水果工厂
 */
public class AppleFactory extends AbstractFactory{

    @Override
    public Fruit getFruit() {
        return new Apple();
    }

    @Override
    public Bag getBag() {
        return new AppleBag();
    }
}
