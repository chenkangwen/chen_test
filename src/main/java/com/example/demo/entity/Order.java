package com.example.demo.entity;

import lombok.Data;
import org.joda.time.DateTime;

import java.io.File;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @Description:
 * @Author: chen kangwen
 * @Date: 2021/12/2 21:11
 **/
@Data
public class Order {

    private Long id;

    private Long orderNo;

    private Date orderTime;

    private String orderContent;

    private String creater;

    private Date createDate;

    private String modifier;

    private Date modifyDate;


}
