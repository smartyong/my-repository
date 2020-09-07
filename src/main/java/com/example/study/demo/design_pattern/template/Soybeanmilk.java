package com.example.study.demo.design_pattern.template;

/**
 * Created by Administrator on 2020/8/24 0024.
 */
public abstract class Soybeanmilk {

    final void make(){
         add();
         soak();
         beating();
    }
    abstract void add();

    void soak(){
        System.out.println("原料浸泡2小时");
    }

    void beating(){
        System.out.println("打浆后 完成");
    }

}
