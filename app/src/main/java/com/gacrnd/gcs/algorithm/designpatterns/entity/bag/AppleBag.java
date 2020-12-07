package com.gacrnd.gcs.algorithm.designpatterns.entity.bag;


import com.gacrnd.gcs.algorithm.designpatterns.entity.Bag;
import com.gacrnd.gcs.algorithm.designpatterns.entity.Fruit;
import com.gacrnd.gcs.algorithm.designpatterns.entity.fruit.Apple;
import com.gacrnd.gcs.algorithm.designpatterns.entity.fruit.Banana;

import java.util.ArrayList;
import java.util.List;

/**
 * 苹果包装
 * Created by Peter on 10/9 009.
 */
public class AppleBag implements Bag {

    List<Fruit> list = new ArrayList<>();

    @Override
    public void pack() {
        System.out.print("--苹果使用纸箱包装");
        list.add(new Apple());
        list.add(new Banana());
        System.out.println(list.toString());
    }
}
