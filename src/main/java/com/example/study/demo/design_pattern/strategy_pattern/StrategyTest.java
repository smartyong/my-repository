package com.example.study.demo.design_pattern.strategy_pattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by s94pcp on 2020/5/3.
 */
public class StrategyTest {
    public static void main(String[] args) {
        List<OrderItem> orders=new ArrayList<OrderItem>();
        OrderItem orderItem=new OrderItem();
        orderItem.setId(100L);
        orderItem.setPrice(10.00);
        orderItem.setQuantity(2);
        orderItem.setBillingStrategy(new NomalBillingStrategy());
        OrderItem orderItem1=new OrderItem();
        orderItem1.setId(200L);
        orderItem1.setPrice(20.00);
        orderItem1.setQuantity(2);
        orderItem1.setBillingStrategy(new HappytimeBillingStrategy());
        orders.add(orderItem);
        orders.add(orderItem1);

        Double sum=0.00;
        for (OrderItem order: orders) {
            sum+=order.getBillingStrategy().getActPrice(order.getPrice()*order.getQuantity());
        }
        System.out.println("orders sum is: "+sum);

    }

}
