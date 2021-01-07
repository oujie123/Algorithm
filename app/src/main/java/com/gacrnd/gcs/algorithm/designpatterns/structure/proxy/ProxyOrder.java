package com.gacrnd.gcs.algorithm.designpatterns.structure.proxy;


import com.gacrnd.gcs.algorithm.designpatterns.service.OrderService;
import com.gacrnd.gcs.algorithm.designpatterns.service.impl.OutOrderServiceImpl;

public class ProxyOrder implements OrderService {

    //真实的订单服务
    private OrderService orderService = new OutOrderServiceImpl();

    private void setOrderTag() {
        // 在真实操作之前，还可以对订单进行控制，演示上叙目的2
        // 例如：可以在用户下单之后，给订单打上标签
        System.out.println("开始海外下订单");
    }

    @Override
    public int saveOrder() {
        setOrderTag();
        return orderService.saveOrder();
    }
}
