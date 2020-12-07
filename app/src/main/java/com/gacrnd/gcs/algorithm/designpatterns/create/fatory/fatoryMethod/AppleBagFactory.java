package com.gacrnd.gcs.algorithm.designpatterns.create.fatory.fatoryMethod;

import com.gacrnd.gcs.algorithm.designpatterns.entity.Bag;
import com.gacrnd.gcs.algorithm.designpatterns.entity.bag.AppleBag;

/**
 * 工厂方法模式
 */
public class AppleBagFactory implements BagFactory{
    @Override
    public Bag getBag(){
        return new AppleBag();
    }
}
