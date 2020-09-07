package com.example.study.demo.interview.thread.thread5;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * Created by Administrator on 2020/9/3 0003.
 */
public class ContronlThread implements Runnable {

    private String printChar;
    private int printCount;

    private Lock lock;
    private Condition curentCond;
    private Condition nextCond;

    public ContronlThread(Lock lock, Condition curentCond, Condition nextCond, String printChar, int printCount) {

        this.printChar = printChar;
        this.printCount = printCount;
        this.lock = lock;
        this.curentCond = curentCond;
        this.nextCond = nextCond;
    }


    @Override
    public void run() {
        lock.lock();
        System.out.println("===lock"+Thread.currentThread().getName());
        try {
            for (int i = 0; i < printCount; i++) {
                System.out.println(":" + printChar);
                nextCond.signal();
//                if (i < printCount) {
                    curentCond.await();
//                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("===unlock");
            lock.unlock();
        }

    }
}
