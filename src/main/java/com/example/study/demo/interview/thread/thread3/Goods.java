package com.example.study.demo.interview.thread.thread3;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2020/9/3 0003.
 */
public class Goods {

    private String[] goods = new String[1];
    private Object obj=new Object();
    Lock lock=new ReentrantLock();
    Condition pro= lock.newCondition();
    Condition con= lock.newCondition();

    public void add(String good) {
            lock.lock();
        try {
            if (goods[0] == null) {
            goods[0] = Thread.currentThread().getName() + good;
            System.out.println(goods[0]);
                con.signal();
//            con.signalAll(); //多生产多消费
        } else {
            //等待
            try {
                pro.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        } finally {
            lock.unlock();
        }

    }

    public void take() {
        lock.lock();
        try {
            if (goods[0] != null) {
                System.out.println(Thread.currentThread().getName() + "取出商品" + goods[0]);
                goods[0] = null;
                pro.signal();
//              pro.signalAll(); //多生产多消费
            } else {
                //等待
                try {
                    con.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } finally {
            lock.unlock();
        }
    }



}
