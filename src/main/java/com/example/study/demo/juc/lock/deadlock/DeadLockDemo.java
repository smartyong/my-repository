package com.example.study.demo.juc.lock.deadlock;

import java.util.concurrent.TimeUnit;

/**
 * 死锁：互相持有对方需要的锁（资源）
 * 定位死锁：
 * jps
 * jstack pid
 *
 * Created by s94pcp on 2020/5/19.
 */
public class DeadLockDemo {


    public static void main(String[] args) {
        DLSource dlSource=new DLSource("lockA","lockB");
        DLSource dlSource1=new DLSource("lockB","lockA");

        /**
         避免死锁
         DLSource dlSource=new DLSource("lockA","lockB");
         DLSource dlSource1=new DLSource("lockA","lockB");
         */

        new Thread(()->{
            dlSource.getLock();
        },"AAA").start();
        new Thread(()->{
            dlSource1.getLock();
        },"BBB").start();
    }
}

class DLSource{
    String lockA;
    String lockB;
    public DLSource(String lockA,String lockB){
        this.lockA=lockA;
        this.lockB=lockB;
    }
    public  void getLock(){
        synchronized (lockA){
            System.out.println(Thread.currentThread().getName()+"=get="+lockA);

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"wait get"+lockB);
            synchronized (lockB){

                System.out.println(Thread.currentThread().getName()+"get"+lockB);
            }

        }
    }

}
