package com.example.study.demo.juc.lock.lock3;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreTest {

    public static void main(String[] args)throws Exception {
        Semaphore semaphore=new Semaphore(3);

        for (int i = 0; i < 6; i++) {

            new Thread(()->{
                try {
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread "+Thread.currentThread().getName()+"抢到车位");

                try {
                    TimeUnit.SECONDS.sleep(5);
                    System.out.println("thread "+Thread.currentThread().getName()+"离开车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }

            },String.valueOf(i)).start();

        }


    }

}
