package com.example.study.demo.design_pattern.factory_pattern.method_factory;

/**
 * Created by s94pcp on 2020/4/18.
 */
public class MethodFactoryTest {

    public static void main(String[] args) {
        //方法工厂比简单工厂的优点是可以避免传参错误
        SendFactory sendFactory=new SendFactory();
        sendFactory.getEmailSender().send();
        sendFactory.getSmsSender().send();
    }
}
