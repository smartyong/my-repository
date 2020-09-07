package com.example.study.demo.interview.thread.thread5;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 面试笔试题  给定线程数 如 3个线程 依次打印 A B C  连续打印2遍
 * 思路：涉及到线程间通信 使用 lock 加 condition
 *
 * Created by Administrator on 2020/9/3 0003.
 */
public class Test {
    public static void main(String[] args) throws Exception {
        Lock lock=new ReentrantLock();
        Condition con1 = lock.newCondition();
        Condition con2 = lock.newCondition();
        Condition con3 = lock.newCondition();

        new Thread(new ContronlThread(lock,con1,con2,"A",3)).start();
        TimeUnit.SECONDS.sleep(1);
        new Thread(new ContronlThread(lock,con2,con3,"B",3)).start();
        TimeUnit.SECONDS.sleep(1);
        new Thread(new ContronlThread(lock,con3,con1,"C",3)).start();

    }

}
