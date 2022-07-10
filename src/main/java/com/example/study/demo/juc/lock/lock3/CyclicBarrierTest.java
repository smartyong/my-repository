package com.example.study.demo.juc.lock.lock3;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {
    public static void main(String[] args)throws Exception {
        CyclicBarrier cyclicBarrier=new CyclicBarrier(7,()->{
            System.out.println("召唤神龙");
        });

        for (int i = 0; i < 7; i++) {
            final int tmp=i;
            new Thread(()->{
                System.out.println("thread "+Thread.currentThread().getName()+" 收集龙珠"+tmp);

                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }

            }).start();

        }


    }


}
