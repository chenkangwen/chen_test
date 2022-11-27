package com.example.demo.commom.lockTest;

import java.math.BigDecimal;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {

    private static volatile int i=10;


    public static void main(String[] args){
        Lock lock = new ReentrantLock();
         if(lock.tryLock()){
             boolean b = lock.tryLock();
             System.out.println(b);
         }




    }
}
