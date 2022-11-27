package com.example.demo.commom.lockTest;

import com.alibaba.fastjson.JSON;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class CasTest {

    private int i=0;
    private static int j=0;

    public static void main(String[] args)throws Exception {
        CasTest casTest = new CasTest();
        System.out.println(casTest.getIncrement());
        System.out.println(casTest.getIncrement2());
        CasTest casTest1 = new CasTest();
        System.out.println(casTest1.getIncrement());
       // System.out.println(j);

        int[] arr = new int[10];
        for (int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }


    }



   public  int getIncrement(){
        return j++;
   }

    public int getIncrement2(){
        return ++j;
    }

   private static void executors(CasTest casTest){
        casTest.i++;
   }

   public static void mycast(int i){
       switch (i){
           case 1:
               System.out.println("color");
           case 2:
               System.out.println("yello");
           case 3:
               System.out.println("black");
               break;
           case 4:
               System.out.println("orange");
       }
   }

}
