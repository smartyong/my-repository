package com.example.study.demo.design_pattern.builder;

/**
 * Created by Administrator on 2020/8/20 0020.
 */
public class HouseDirector {

    private HouseBuilder houseBuilder;

    public HouseDirector(HouseBuilder houseBuilder){
        this.houseBuilder=houseBuilder;
    }

    public void setHouseBuilder(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    public House construcHouse(){
        this.houseBuilder.buildBasic();
        this.houseBuilder.buildWalls();
        this.houseBuilder.buildRoof();
        return this.houseBuilder.build();
    }
}
