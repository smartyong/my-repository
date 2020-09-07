package com.example.study.demo.interview.thread.thread4;

import org.springframework.util.StringUtils;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2020/9/3 0003.
 */
public class LettersSource {

    private char[] lows= {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    private char[] uppers= {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    private int size=0;
    private int uppersSize=0;
    private Lock lock=new ReentrantLock();
    Condition lowCond= lock.newCondition();
    Condition upperCond= lock.newCondition();
    private boolean low=true;

    public void printLetters(){
        lock.lock();
        try {
            if (low&&size<lows.length){
            System.out.println(Thread.currentThread().getName()+"---"+lows[size]);
            size++;
            low=false;
            upperCond.signalAll();
            }else {
                try {
                    lowCond.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        } finally {
            lock.unlock();
        }
    }
    public void printUppers(){
        lock.lock();
        try {
         if (!low&&uppersSize<uppers.length)  {
        System.out.println(Thread.currentThread().getName()+"---"+uppers[uppersSize]);
        uppersSize++;
             low=true;
             lowCond.signalAll();
         }else {
             try {
                 upperCond.await();
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }
        } finally {
            lock.unlock();
        }
    }


}
