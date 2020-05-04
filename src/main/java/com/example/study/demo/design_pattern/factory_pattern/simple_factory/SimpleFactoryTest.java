package com.example.study.demo.design_pattern.factory_pattern.simple_factory;

/**
 * Created by s94pcp on 2020/4/18.
 */
public class SimpleFactoryTest {

    public static void main(String[] args) {
        SendFactory sendFactory=new SendFactory();
        //如果将SendFactory getSender方法改为static 修饰 就变成简单静态工厂了。
        Sender sender=sendFactory.getSender("sms");
        sender.send();
    }

}
