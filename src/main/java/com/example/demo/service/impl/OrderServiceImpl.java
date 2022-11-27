package com.example.demo.service.impl;

import com.example.demo.dao.IOrderMapper;
import com.example.demo.entity.Order;
import com.example.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    IOrderMapper orderMapper;
    @Override
    public void insertOrder(Order order) {
        orderMapper.insertOrder(order);
    }
}
