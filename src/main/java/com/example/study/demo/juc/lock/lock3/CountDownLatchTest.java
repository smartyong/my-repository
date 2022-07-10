package com.example.study.demo.juc.lock.lock3;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {

    public static void main(String[] args) throws  Exception{
        CountDownLatch countDownLatch=new CountDownLatch(6);

        for (int i = 0; i < 6; i++) {
            final int tmpI=i;
            new Thread(()->{
                System.out.println("thread"+Thread.currentThread().getName()+"   灭国"+tmpI);
                countDownLatch.countDown();
            },String.valueOf(i)).start();

        }
        countDownLatch.await();
        System.out.println("thread"+Thread.currentThread().getName()+"   统一天下");


    }


}
