package com.example.study.demo.design_pattern.singleton;

public class SingleDemo {
    private static volatile SingleDemo singleDemo;

    private SingleDemo(){

    }
    public static SingleDemo getInstance(){
        if (singleDemo==null){
            synchronized (SingleDemo.class){
                if (singleDemo == null) {
                    singleDemo=new SingleDemo();
                }
            }
        }
        return singleDemo;
    }

}
