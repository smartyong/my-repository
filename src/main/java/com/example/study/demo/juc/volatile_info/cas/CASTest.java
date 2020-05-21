package com.example.study.demo.juc.volatile_info.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * CAS 引发 ABA 问题
 * Created by s94pcp on 2020/5/21.
 */
public class CASTest {

    public static void main(String[] args) {
    //   ABA 问题
        AtomicInteger num=new AtomicInteger(1);
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"--"+num.compareAndSet(1, 5));
            System.out.println(Thread.currentThread().getName()+"--"+num.compareAndSet(5, 1));
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"AAA").start();

        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"--"+num.compareAndSet(1, 10));
        },"BBB").start();
    }
}
