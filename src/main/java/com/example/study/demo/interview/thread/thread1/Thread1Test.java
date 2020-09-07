package com.example.study.demo.interview.thread.thread1;

/**
 *  模拟 多窗口 买票 (需要对共享资源同步代码 即加锁 不然会出现线程安全问题)
 * Created by Administrator on 2020/9/3 0003.
 */
public class Thread1Test {
    public static void main(String[] args) {
        ProduceSource produceSource=new ProduceSource(100);
        for (int i = 0; i < 4; i++) {
            new Thread(produceSource).start();
        }

    }

}
