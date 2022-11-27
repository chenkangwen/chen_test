package com.example.demo.commom.nioTest.dubboTest;

//这个是接口，是服务提供方和 服务消费方都需要
public interface RpcResourceService{	
    String hello(String mes);
}
