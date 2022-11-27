package com.example.demo.controller;

import com.example.demo.commom.model.User;
import com.example.demo.commom.springAop.annotation.MyAnnotation;
import com.example.demo.entity.Order;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.Executor;

@RestController
public class RedisController {


    @Autowired
    private OrderService orderService;

    @Autowired
    private Executor executor;

    @RequestMapping("/test/{id}")
    @MyAnnotation
    public String test(@PathVariable(name = "id") String id) {
        Order order = new Order();
        order.setOrderNo(10001l);
        order.setOrderContent("一个测试订单");
        order.setCreater("chenkw");
        order.setModifier("chenkw");
        orderService.insertOrder(order);
        return "SUCCESS";
    }

    @GetMapping("/hello")
    public String hello(@RequestBody User user) {
        return "SUCCESS";
    }

}
