package com.example.study.demo.design_pattern.template;

/**
 * Created by Administrator on 2020/8/24 0024.
 */
public class Test {

    public static void main(String[] args) {
        System.out.println("=========开始制作 红豆豆浆===========");
        Soybeanmilk redbeanSoybeanmilk = new RedbeanSoybeanmilk();
        redbeanSoybeanmilk.make();
        System.out.println("=========开始制作 花生豆浆===========");
        Soybeanmilk penautSoybeanmilk = new PenautSoybeanmilk();
        penautSoybeanmilk.make();

    }
}
