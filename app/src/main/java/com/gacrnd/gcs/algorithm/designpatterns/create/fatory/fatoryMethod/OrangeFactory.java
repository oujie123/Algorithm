package com.gacrnd.gcs.algorithm.designpatterns.create.fatory.fatoryMethod;

import com.gacrnd.gcs.algorithm.designpatterns.entity.Fruit;
import com.gacrnd.gcs.algorithm.designpatterns.entity.fruit.Orange;

/**
 * 工厂方法模式
 */
public class OrangeFactory implements FruitFactory{
    public Fruit getFruit(){
        return new Orange("Peter",80);
    }
}
