package com.gacrnd.gcs.algorithm.designpatterns.action.visit;


import com.gacrnd.gcs.algorithm.designpatterns.entity.Fruit;
import com.gacrnd.gcs.algorithm.designpatterns.entity.fruit.Apple;
import com.gacrnd.gcs.algorithm.designpatterns.entity.fruit.Banana;
import com.gacrnd.gcs.algorithm.designpatterns.entity.fruit.Orange;

/**
 * 多态中不能识别真实对象的时候，就需要用到访问者模式，来双重分派任务
 */
public class Visit {

	//苹果计价
	public int sell(Apple apple){
		System.out.println("apple's price: ￥50");
		return 50;
	}

	//桔子计价
	public int sell(Orange orange){
		System.out.println("orange's price: ￥20");
		return 20;
	}

	//香蕉计价
	public int sell(Banana banana){
		System.out.println("banana's price: ￥30");
		return 30;
	}

	//其它水果计价
	public int sell(Fruit fruit){
		System.out.println("other price: ￥10");
		return 10;
	}
}
