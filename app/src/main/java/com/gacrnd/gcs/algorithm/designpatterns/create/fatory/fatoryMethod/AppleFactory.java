package com.gacrnd.gcs.algorithm.designpatterns.create.fatory.fatoryMethod;

import com.gacrnd.gcs.algorithm.designpatterns.entity.Fruit;
import com.gacrnd.gcs.algorithm.designpatterns.entity.fruit.Apple;

/**
 * 工厂方法模式
 */
public class AppleFactory implements FruitFactory{
    @Override
    public Fruit getFruit(){
        return new Apple();
    }
}
