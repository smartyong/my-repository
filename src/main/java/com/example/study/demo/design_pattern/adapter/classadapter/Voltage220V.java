package com.example.study.demo.design_pattern.adapter.classadapter;

/**
 * Created by Administrator on 2020/8/20 0020.
 */
public class Voltage220V {

    public int outPutSrc(){
        int src=220;
        System.out.println("输出"+src+"V电压");
        return src;
    }
}
