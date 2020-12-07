package com.gacrnd.gcs.algorithm.designpatterns.structure.adapter;


import com.gacrnd.gcs.algorithm.designpatterns.entity.bag.AppleBag;
import com.gacrnd.gcs.algorithm.designpatterns.entity.bag.OrangeBag;
import com.gacrnd.gcs.algorithm.designpatterns.entity.fruit.Orange;

public class AdapterClient {
	public static void main(String[] args){
		Orange orange = new Orange("peter",100);
		OrangeBag bag = getBag2();
		orange.pack(bag);
	}

	/**
	 * 取桔子包装
	 * @return
     */
//	private static OrangeBag getBag(){
//		OrangeBag bag = new OrangeBag();
//		return bag;
//	}

	private static OrangeBag getBag2(){
		//准备用途苹果盒代替
		AppleBag appleBag = new AppleBag();

		//把苹果盒适配成桔子包装盒
		OrangeBag orangeBag = new OrangeBagAdapter(appleBag);

		return orangeBag;
	}
}
