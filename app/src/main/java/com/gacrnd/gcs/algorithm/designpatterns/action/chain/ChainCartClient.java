package com.gacrnd.gcs.algorithm.designpatterns.action.chain;

import com.gacrnd.gcs.algorithm.designpatterns.action.template.OtherPayShopping;
import com.gacrnd.gcs.algorithm.designpatterns.action.template.ShoppingCart;
import com.gacrnd.gcs.algorithm.designpatterns.create.fatory.simple.StaticFactory;
import com.gacrnd.gcs.algorithm.designpatterns.entity.Fruit;

import java.util.ArrayList;
import java.util.List;

/**
 * 当一个请求需要很多方对他进行处理的时候，可以使用责任链模式
 *
 * 模板方法模式
 * 订单费用结算过程
 */
public class ChainCartClient {

    //初始化满减优惠券
    private static MultyDiscount multyDiscount = new FullMultyDiscount(null);
    static {
        multyDiscount = new NewerMultyDiscount(multyDiscount);
        multyDiscount = new SecondMultyDiscount(multyDiscount);
        multyDiscount = new HolidayMultyDiscount(multyDiscount);


    }

    public static void main(String[] args) {
        List<Fruit> products = new ArrayList();

        products.add(StaticFactory.getFruitApple());
        products.add(StaticFactory.getFruitBanana());
        products.add(StaticFactory.getFruitOrange());

        ShoppingCart cart = new OtherPayShopping(products);

        //注入优惠方案
        cart.setDiscount(multyDiscount);

        cart.submitOrder();
    }


}
