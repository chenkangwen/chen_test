package com.example.demo.commom.collection;

import com.example.demo.commom.model.User;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class MapTest {
    public static synchronized void main(String[] args) {
        Map<String, String> myMap = new HashMap<>();
        myMap.put("haha", "haha");



        Hashtable<String, String> ht = new Hashtable<>();
        ht.put("haha","haha");


        double i=2/3;
        System.out.println(i);


    }


    public void test(){
        Map<String, String> myMap = new HashMap<>();
        Map<String, String> sm = Collections.synchronizedMap(myMap);

        Map<String, String> chm = new ConcurrentHashMap<>();



    }


}
