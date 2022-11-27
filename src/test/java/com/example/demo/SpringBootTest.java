package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class SpringBootTest extends DemoApplicationTests {


    @Test
    public void test1314(){
       // String[] split = "22/08/15".split("\\/");
       // System.out.println(split[0]+"-"+split[1]+"-"+split[2]);
        Calendar calendar = Calendar.getInstance();//日历对象
        calendar.setTime(new Date());//设置当前日期
        String yearStr = calendar.get(Calendar.YEAR) + "";//获取年份
        String yearPrefix = yearStr.substring(0,2);
        System.out.println(yearPrefix);
        //System.out.println(yearStr);
    }
    @Test
    public void test13145(){
        List<String> list= new ArrayList<>();
        list.add("hehe");
        list.add("haihai");
        System.out.println(String.join(",",list));
    }


}
