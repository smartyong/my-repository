package com.example.study.demo.design_pattern.adapter.classadapter;

/**
 * Created by Administrator on 2020/8/20 0020.
 */
public class VoltageAdapter extends Voltage220V implements  Voltage5V {
    @Override
    public int output() {
        int outPutSrc = outPutSrc();
        int adapterOut = outPutSrc / 44;
        System.out.println("适配后输出"+adapterOut+"V电压");
        return adapterOut;
    }
}
