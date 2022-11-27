package com.example.demo.commom.designMode.factoryModel.simpleFactory;
 
/**
 * @author Mr.Qing
 * @date 2021/11/8
 */
public class tesla implements car{
    @Override
    public void name() {
        System.out.println("特斯拉");
    }
}