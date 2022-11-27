package com.example.demo.commom.designMode.proxy.test;

import com.example.demo.commom.designMode.proxy.cglibDynamicProxy.CglibProxyFactory;
import com.example.demo.commom.designMode.proxy.entity.SuperMarket;
import com.example.demo.commom.designMode.proxy.entity.SuperMarketAction;
import com.example.demo.commom.designMode.proxy.jdkDynamicProxy.SuperMarketInvocationHandler;
import com.example.demo.commom.designMode.proxy.staticProxy.ExpressCompanyProxy;
import net.sf.cglib.proxy.Enhancer;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Test {


    public static void main(String[] args) throws Exception {

        //静态代理
       /* ExpressCompanyProxy staticProxyObject = getStaticProxyObject();
        staticProxyObject.deliverGoods();*/


        //jdk动态代理
        //不需要导入包,被代理类需要实现接口 创建代理对象速度快与cjlb,jdk1.8执行速度快于cjlb
       /* SuperMarketAction superMarketAction = new SuperMarket();
        SuperMarketAction jdkProxyObject = getJDKProxyObject(superMarketAction);
        jdkProxyObject.deliverGoods();*/


        //cjlb动态代理
        //被代理目标类和方法不能是被final修饰 生成代理类速度快于jdk,jdk1.8之前执行速度快于jdk动态代理
      /* SuperMarket superMarket = new SuperMarket();
        InternetBar internetBar = new InternetBar();
        SuperMarket cjlbProxyObject = getCjlbProxyObject(superMarket);
        InternetBar cjlbProxyObject1 = getCjlbProxyObject(internetBar);
        cjlbProxyObject.deliverGoods();
        System.out.println("-----------------------------");
        cjlbProxyObject1.surfingTheWeb();*/
    }


    public static ExpressCompanyProxy getStaticProxyObject() {
        SuperMarket superMarket = new SuperMarket();
        ExpressCompanyProxy proxy = new ExpressCompanyProxy(superMarket);
        return proxy;
    }


    public static <T> T getJDKProxyObject(T t) {
        // 创建要被代理类的处理方式
        SuperMarketInvocationHandler invocationHandler = new SuperMarketInvocationHandler(t);
        // 创建代理对象
        T proxy = (T) Proxy.newProxyInstance(t.getClass().getClassLoader(), t.getClass().getInterfaces(), invocationHandler);
        return proxy;
    }



    public static SuperMarketAction getJDKProxyObject1() throws Exception {
        // HelloWorld 是一个接口，此处没有贴出来
        Class<?> proxyClass = Proxy.getProxyClass(SuperMarketAction.class.getClassLoader(), SuperMarketAction.class);
        Constructor cc = proxyClass.getConstructor(InvocationHandler.class);
        InvocationHandler ihs = new SuperMarketInvocationHandler(new SuperMarket());
        SuperMarketAction proxy = (SuperMarketAction) cc.newInstance(ihs);
        return proxy;
    }


    private static <T> T getCjlbProxyObject(T t) {
        //工具类
        Enhancer enhancer = new Enhancer();
        //设置父类
        enhancer.setSuperclass(t.getClass());
        //设置回调函数
        enhancer.setCallback(new CglibProxyFactory(t));
        // 创建子类对象代理
        T proxy = (T) enhancer.create();
        return proxy;
    }



}
