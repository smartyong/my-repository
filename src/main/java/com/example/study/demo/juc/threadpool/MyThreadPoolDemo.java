package com.example.study.demo.juc.threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 手写线程池
 * 最大线程数+阻塞队列大小=最大处理能力  超过后调用拒绝策略（4种）
 * Created by s94pcp on 2020/5/19.
 */
public class MyThreadPoolDemo {

    public static void main(String[] args) {
        ThreadPoolExecutor poolExecutor=new ThreadPoolExecutor(
                2,
                5,
                2L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        try {
            for (int i = 1; i <= 9; i++) {
                poolExecutor.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"=== 正在办理");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            poolExecutor.shutdown();
        }


    }


}
