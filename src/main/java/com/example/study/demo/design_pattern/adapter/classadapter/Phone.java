package com.example.study.demo.design_pattern.adapter.classadapter;

/**
 * Created by Administrator on 2020/8/20 0020.
 */
public class Phone {


    public void charging(Voltage5V voltage5V){
        if (voltage5V.output()==5){
            System.out.println("是5v电压可以充电");
        }else {
            System.out.println("不是5v电压不可以充电");
            }

    }
}
