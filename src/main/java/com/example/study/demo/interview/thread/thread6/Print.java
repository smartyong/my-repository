package com.example.study.demo.interview.thread.thread6;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2020/9/4 0004.
 */
public class Print {

    final Lock lock = new ReentrantLock();
    final Condition num = lock.newCondition();
    final Condition zimu = lock.newCondition();
    final Condition zimuLittle = lock.newCondition();

    public void printNum(){
        lock.lock();
        try {
            for (int i=1;i<53;i++){
                System.out.print(i);
                if (i%2==0){
                    zimu.signal();
                    num.await();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printZimu(){
        lock.lock();
        try {
            for (int i=0;i<26;i++){
                System.out.print((char)(i+'A'));
                zimuLittle.signal();
                zimu.await();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printZimuLittle(){
        lock.lock();
        try {
            for (int i=0;i<26;i++){
                System.out.print((char)(i+'a'));
                num.signal();
                zimuLittle.await();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
