package com.example.study.demo.design_pattern.builder;

/**
 * Created by Administrator on 2020/8/20 0020.
 */
public class ClientTest {
    public static void main(String[] args) {

        HouseDirector houseDirector=new HouseDirector(new CommonHouse());
        houseDirector.construcHouse();
        System.out.println("==========================");
        houseDirector.setHouseBuilder(new HighBuilding());
        houseDirector.construcHouse();
    }
}
