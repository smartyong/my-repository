package com.example.study.demo.design_pattern.singleton;

/**
 * 懒汉式
 * Created by Administrator on 2020/8/25 0025.
 */
public class Singleton1 {

    private static Singleton1 singleton1 =null;

    private Singleton1(){
        //私有构造函数
    }
    public static synchronized Singleton1 getSingleton1(){
        if (singleton1 ==null){
            return new Singleton1();
        }
        return singleton1;
    }

}
