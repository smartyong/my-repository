package com.example.study.demo.design_pattern.strategy_pattern;

/**
 * 5折策略
 * Created by s94pcp on 2020/5/3.
 */
public class HappytimeBillingStrategy implements BillingStrategy {
    @Override
    public Double getActPrice(Double rowPrice) {
        return 0.5*rowPrice;
    }
}
