package com.example.study.demo.design_pattern.strategy_pattern;

/**
 * Created by s94pcp on 2020/5/3.
 */
public class NomalBillingStrategy implements  BillingStrategy{

    @Override
    public Double getActPrice(Double rowPrice) {
        return rowPrice;
    }
}
