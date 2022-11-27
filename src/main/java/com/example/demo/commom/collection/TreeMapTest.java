package com.example.demo.commom.collection;

import com.alibaba.fastjson.JSON;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TreeMap;

public class TreeMapTest {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) throws Exception {
        Date begin = sdf.parse("2022-10-24 02:04:00");
        Date end = sdf.parse("2022-10-27 02:04:00");
        Date today = getToday(begin);
        System.out.println(sdf.format(today));


    }

    //2022-10-24 03:00:00
    //2022-10-24 04:00:00
    //2022-10-24 05:00:00
    //2022-10-25 04:00:00
    public static Integer mathSum(Date begin, Date end, String total) {
        Date left = getToday(begin);
        Date right = getToday(end);
        Integer num = getCha(left, right);
        if(num==0){//同一天
            return 1;
        }else{
            begin = addDay(left);

        }
        return null;
    }


    public static Date addDay(Date left){
        Calendar instance = Calendar.getInstance();
        instance.setTime(left);
        instance.add(Calendar.DATE,1);
        return instance.getTime();
    }

    public static Integer getCha(Date left, Date right){
       Long day=right.getTime()-left.getTime()/60*60*24;
       return Integer.parseInt(day+"");
    }




    public static Date getToday(Date begin) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(begin);
        int year = instance.get(Calendar.YEAR);
        int month = instance.get(Calendar.MONTH);
        int day = instance.get(Calendar.DATE);
        Calendar instance1 = Calendar.getInstance();
        instance1.set(year, month, day, 4, 0, 0);
        return instance1.getTime();
    }


    public static Integer getWeek(Date date) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        int week = instance.get(Calendar.DAY_OF_WEEK) - 1;
        return week;
    }


    private static Integer test(int i) throws Exception {
        try {
            return 3;
        } catch (Exception e) {
            throw new RuntimeException("这个是一个异常");
        } finally {
            System.out.println("finally");
            return 4;
        }

    }


    private static void treeMapSort() {
        /* TreeMap<Integer, String> treemap = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1>o2){
                    return 1;
                }else{
                    return -1;
                }
            }
        });*/
        TreeMap<Integer, String> treemap = new TreeMap<>((o1, o2) -> {
            if (o1 > o2) {
                return -1;
            } else {
                return 1;
            }
        });
        treemap.put(2, "two");
        treemap.put(3, "tree");
        treemap.put(1, "one");
        treemap.put(3, "three");
        treemap.put(6, "six");
        treemap.put(5, "five");
        System.out.println(JSON.toJSONString(treemap));
    }


}
