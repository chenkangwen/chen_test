package com.example.demo.commom.nioTest.dubboTest.service;

import com.example.demo.commom.nioTest.dubboTest.RpcResourceService;

public class ClientRun {


    //这里定义协议头
    public static final String providerName = "RpcResourceService#hello#";

    public static void main(String[] args) throws  Exception{

        //创建一个消费者
        NettyClient customer = new NettyClient();

        //创建代理对象
        RpcResourceService service = (RpcResourceService) customer.getBean(RpcResourceService.class, providerName);

        for (;; ) {
            Thread.sleep(2 * 1000);
            //通过代理对象调用服务提供者的方法(服务)
            String res = service.hello("你好 RPC");
            System.out.println("调用的结果 res= " + res);
        }
    }
}
