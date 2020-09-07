package com.example.study.demo.interview.thread.thread2;

/**
 *
 * 使用 wait 和 notify 来进行线程间通信  解决单生产单消费问题
 * 多生产多消费 需要使用 notifyAll
 * Created by Administrator on 2020/9/3 0003.
 */
public class Test {

    public static void main(String[] args) {
     Goods goods=new Goods();
     new Thread(new Producer(goods)).start();
     new Thread(new Consumer(goods)).start();
        //多生产多消费 需要使用 notifyAll
        new Thread(new Producer(goods)).start();
        new Thread(new Consumer(goods)).start();
        new Thread(new Producer(goods)).start();
        new Thread(new Consumer(goods)).start();


    }

}
