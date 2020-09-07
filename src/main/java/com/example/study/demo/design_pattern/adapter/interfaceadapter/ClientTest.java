package com.example.study.demo.design_pattern.adapter.interfaceadapter;

/**
 * Created by Administrator on 2020/8/20 0020.
 */
public class ClientTest {
    public static void main(String[] args) {

        AbsAdapter absAdapter = new AbsAdapter() {

            public void m1() {
                System.out.println("适配 m1 方法");
            }
        };
        absAdapter.m1();
    }

}
