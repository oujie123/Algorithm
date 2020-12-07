package com.gacrnd.gcs.algorithm.designpatterns.create.fatory.fatoryMethod;


import com.gacrnd.gcs.algorithm.designpatterns.entity.Fruit;
import com.gacrnd.gcs.algorithm.designpatterns.entity.fruit.Banana;

/**
 * 工厂方法模式
 */
public class BananaFactory implements FruitFactory{
    public Fruit getFruit(){
        return new Banana();
    }
}
