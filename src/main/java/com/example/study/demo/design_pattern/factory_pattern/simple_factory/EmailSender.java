package com.example.study.demo.design_pattern.factory_pattern.simple_factory;

/**
 * Created by s94pcp on 2020/4/18.
 */
public class EmailSender implements  Sender{
    @Override
    public void send() {
        System.out.println("eamil  send");
    }
}
