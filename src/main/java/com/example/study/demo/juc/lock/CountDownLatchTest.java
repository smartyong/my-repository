package com.example.study.demo.juc.lock;

import java.util.concurrent.CountDownLatch;

/**
 * Created by s94pcp on 2020/5/19.
 */
public class CountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch=new CountDownLatch(6);
        for (int i = 0; i <6 ; i++) {
            final int num=i+1;
            new Thread(()->{
                System.out.println(CountryEnum.forEachGetCountry(num).getMsg()+"被灭了！");
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getId()+"  秦国统一中国！");

    }

}
