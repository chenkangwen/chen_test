package com.example.demo.commom.designMode.factoryModel.simpleFactory;
 
/**
 * @author Mr.Qing
 * @date 2021/11/8
 */
public class carFactory {

    //优点：专门定义一个工厂类负责创建其他类的实例，最大的优点在于工厂类中包含了必要的逻辑，根据客户需要的条件动态实例化相关的类。
    //缺点：当需要增加一种产品时，比如ProductC就需要修改简单工厂类SimpleFactory（增加if-else块），这违背了开闭原则。
    //当需要增加一种产品时，比如ProductC就需要修改简单工厂类SimpleFactory（增加if-else块），这违背了开闭原则。
    public static car getCar(String car){
        if (car.equals("wuLing")){
            return new wuLing();
        }
        else if (car.equals("tesla")){
            return new tesla();
        }
        else {
            return null;
        }
    }
}