package com.example.study.demo.juc.volatile_info;

/**
 * Created by s94pcp on 2020/5/16.
 */
public class MyTest {

    public static void main(String[] args) {
        int a=0;
        do{
            a=a+1;
            System.out.println("do a is:" + a);
        }
        while (a<20);
        System.out.println(a);
    }
}
