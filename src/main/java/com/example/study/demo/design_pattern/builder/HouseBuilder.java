package com.example.study.demo.design_pattern.builder;

/**
 * Created by Administrator on 2020/8/20 0020.
 */
public abstract class HouseBuilder {
    public House house=new House();
    public abstract void buildBasic();
    public abstract void buildWalls();
    public abstract void buildRoof();
    public abstract House build();
}

