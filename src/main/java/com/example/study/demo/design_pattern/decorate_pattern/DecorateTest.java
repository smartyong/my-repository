package com.example.study.demo.design_pattern.decorate_pattern;

/**
 * Created by s94pcp on 2020/5/4.
 */
public class DecorateTest {
    public static void main(String[] args) {
        DecorateCircle decorateCircle=new DecorateCircle(new Circle());
        decorateCircle.draw();
    }
}
