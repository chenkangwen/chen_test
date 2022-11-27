package com.example.demo.commom.designMode.proxy.entity;

public class SuperMarket implements SuperMarketAction {


    @Override
    public void deliverGoods() {
        System.out.println("SuperMarket.deliverGoods()");
    }
}
