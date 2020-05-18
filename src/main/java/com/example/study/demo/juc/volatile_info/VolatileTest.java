package com.example.study.demo.juc.volatile_info;

/**
 * Created by s94pcp on 2020/5/16.
 */
public class VolatileTest {


    public static void main(String[] args) {
        MySum mySum=new MySum();
        for (int i = 0; i <20 ; i++) {
            new Thread(()->{
                for (int j = 0; j <1000 ; j++) {
                    mySum.add();
                }
            },String.valueOf(i)).start();

            while (Thread.activeCount()>2){
               Thread.yield();
            }
        }
        System.out.println(mySum.num);
    }



}

