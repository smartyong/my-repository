package com.example.study.demo.design_pattern.builder;

/**
 * Created by Administrator on 2020/8/20 0020.
 */
public class HighBuilding extends HouseBuilder {
    @Override
    public void buildBasic() {
        System.out.println(" 建造高楼地基");
    }

    @Override
    public void buildWalls() {
        System.out.println(" 建造高楼地基");
    }

    @Override
    public void buildRoof() {
        System.out.println(" 建造高楼地基");
    }

    @Override
    public House build() {
        return house;
    }
}
