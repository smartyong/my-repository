package com.example.study.demo.design_pattern.adapter.classadapter;

/**
 * Created by Administrator on 2020/8/20 0020.
 */
public class ClientTest {

    public static void main(String[] args) {

        Phone phone=new Phone();
        phone.charging(new VoltageAdapter());

    }

}
