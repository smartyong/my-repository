package com.example.study.demo;

/**
 * Created by Administrator on 2020/9/1 0001.
 */
public abstract class Test1 {

    {
        System.out.println("构造代码块。。。");
    }

    static {
        System.out.println("静态代码块。。。");
    }

    Test1 (){

        System.out.println("构造函数。。。");
    }

    public  abstract void m2();

    public void m1(){

        System.out.println("m1函数。。。");
    }
}
