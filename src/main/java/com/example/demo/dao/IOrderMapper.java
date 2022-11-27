package com.example.demo.dao;

import com.example.demo.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
public interface IOrderMapper {

    Order getOrderById(@Param("id") String id);


    int insertOrder(Order order);


    List<Order> getOrderList();
}
