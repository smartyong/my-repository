package com.example.study.demo.juc.volatile_info;

import java.util.concurrent.TimeUnit;

/**
 * 可见性
 * Created by s94pcp on 2020/5/16.
 */
public class VolatileTest0 {


    public static void main(String[] args) {
        MyData myData = new MyData();

        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+": come in");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myData.addTo50();
            System.out.println(Thread.currentThread().getName()+":"+myData.data);
        }).start();

        while (myData.data==0){
            //
        }
        System.out.println(Thread.currentThread().getName()+": mission is over");

    }


}
class  MyData{

    int data=0;

    void addTo50(){
        this.data=50;
    }

}