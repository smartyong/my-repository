package com.example.study.demo.interview.thread.thread3;

/**
 * Created by Administrator on 2020/9/3 0003.
 */
public class Consumer implements Runnable {

    private Goods goods;

    public Consumer (Goods goods){
        this.goods=goods;
    }

    @Override
    public void run() {
        while (true) {
            goods.take();
        }
    }
}
