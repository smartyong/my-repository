package com.example.study.demo.design_pattern.decorate_pattern;

public class DecorateCircle implements Shape{

    private Circle circle;

    public DecorateCircle(Circle circle){
        this.circle=circle;
    }

    @Override
    public void draw() {
        System.out.println("use red pen");
        circle.draw();
    }
}
