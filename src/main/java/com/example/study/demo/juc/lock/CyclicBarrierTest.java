package com.example.study.demo.juc.lock;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by Administrator on 2020/8/23 0023.
 */
public class CyclicBarrierTest {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier=new CyclicBarrier(7,()->{
            System.out.println("===召唤神龙===");
        });
        for (int i = 1; i <=7 ; i++) {
            final int num=i;
            new Thread(()->{

                System.out.println(Thread.currentThread().getId()+"  收集到第"+num+"颗龙珠");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();

        }



    }
}
