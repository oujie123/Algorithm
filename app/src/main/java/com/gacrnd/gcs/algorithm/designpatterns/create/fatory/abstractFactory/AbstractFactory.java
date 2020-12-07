package com.gacrnd.gcs.algorithm.designpatterns.create.fatory.abstractFactory;

import com.gacrnd.gcs.algorithm.designpatterns.entity.Bag;
import com.gacrnd.gcs.algorithm.designpatterns.entity.Fruit;

/**
 * 抽象水果工厂
 */
public abstract class AbstractFactory {

    public abstract Fruit getFruit();

    public abstract Bag getBag();

}
