package com.example.study.demo.design_pattern.singleton;

/**
 * 饿汉式
 * Created by Administrator on 2020/8/25 0025.
 */
public class Singleton2 {
    private static Singleton2 singleton2 =new Singleton2();//饿汉式 之间new 返回

    private Singleton2(){
      // 私有构造函数
    }

    public static  Singleton2 getSingleton1(){
        return singleton2;
    }
}
