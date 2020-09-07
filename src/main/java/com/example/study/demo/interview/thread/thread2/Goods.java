package com.example.study.demo.interview.thread.thread2;

/**
 * Created by Administrator on 2020/9/3 0003.
 */
public class Goods {

    private String[] goods = new String[1];
    private Object obj=new Object();

    public void add(String good) {
        synchronized (obj) {
            if (goods[0] == null) {
                goods[0] = Thread.currentThread().getName() + good;
                System.out.println(goods[0]);
//                obj.notify();//单生产单消费 需要使用 notify
                obj.notifyAll();//多生产多消费 需要使用 notifyAll
            } else {
                //等待
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void take() {
        synchronized (obj) {
            if (goods[0] != null) {
                System.out.println(Thread.currentThread().getName() + "取出商品" + goods[0]);
                goods[0] = null;
//                obj.notify();//单生产单消费 需要使用 notify
                obj.notifyAll();//多生产多消费 需要使用 notifyAll
            } else {
                //等待
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
