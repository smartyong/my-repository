package com.example.study.demo.juc.volatile_info.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * 解决 cas 引发的 ABA 问题
 * Created by s94pcp on 2020/5/21.
 */
public class CasAbaTest {

    public static void main(String[] args) {

        AtomicStampedReference<Integer> num=new AtomicStampedReference<>(1,1);

        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"--"+num.compareAndSet(1, 5,1,2));
            System.out.println(Thread.currentThread().getName()+"--"+num.compareAndSet(5, 1,2,3));


            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"AAA").start();

        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"--"+num.compareAndSet(1, 10,1,2));
        },"BBB").start();

    }
}
