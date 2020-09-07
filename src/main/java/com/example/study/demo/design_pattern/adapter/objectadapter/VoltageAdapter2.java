package com.example.study.demo.design_pattern.adapter.objectadapter;

import com.example.study.demo.design_pattern.adapter.classadapter.Voltage220V;
import com.example.study.demo.design_pattern.adapter.classadapter.Voltage5V;

/**
 * Created by Administrator on 2020/8/20 0020.
 */
public class VoltageAdapter2 implements Voltage5V{

    private Voltage220V voltage220V;

    public  VoltageAdapter2 (Voltage220V voltage220V){
        this.voltage220V=voltage220V;
    }

    @Override
    public int output() {
        int outPutSrc = voltage220V.outPutSrc();
        int adapterOut = outPutSrc / 44;
        System.out.println("适配后输出"+adapterOut+"V电压");
        return adapterOut;
    }
}
