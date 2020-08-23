package com.example.study.demo.juc.lock;

import lombok.Getter;

/**
 * Created by Administrator on 2020/8/23 0023.
 */
public enum CountryEnum {
    ONE(1,"魏"),TWO(2,"赵"),THREE(3,"韩"),FOUR(4,"齐"),FIVE(5,"楚"),SEX(6,"宋");

    private Integer id;
    private String msg;

    CountryEnum (Integer id,String msg){
        this.id=id;
        this.msg=msg;
    }

    public static CountryEnum forEachGetCountry(Integer id){

        CountryEnum[] countryEnums = CountryEnum.values();
        for (CountryEnum countryEnum:countryEnums) {
            if (id==countryEnum.getId()){
                return countryEnum;
            }
        }
        return null;
    }

    public Integer getId() {
        return id;
    }

    public String getMsg() {
        return msg;
    }
}
