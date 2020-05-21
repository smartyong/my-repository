package com.example.study.demo.juc.volatile_info.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by s94pcp on 2020/5/21.
 */
public class AtomicIntegerDemo {

    public static void main(String[] args) {

        AtomicInteger atomicInteger=new AtomicInteger(1);
        System.out.println(atomicInteger.compareAndSet(1, 5));
        System.out.println(atomicInteger.compareAndSet(1, 10));

        /*
        输出
        true
        false
        */
    }

}
