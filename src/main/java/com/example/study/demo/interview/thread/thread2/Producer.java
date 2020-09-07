package com.example.study.demo.interview.thread.thread2;

/**
 * Created by Administrator on 2020/9/3 0003.
 */
public class Producer implements Runnable{
    private Goods goods;

    public  Producer (Goods goods){
        this.goods=goods;
    }

    @Override
    public void run() {
        int num = 1;
        while (true) {
            goods.add("添加商品" + num);
            num++;
        }
    }
}
