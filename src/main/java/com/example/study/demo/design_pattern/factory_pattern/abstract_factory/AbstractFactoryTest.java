package com.example.study.demo.design_pattern.factory_pattern.abstract_factory;

/**
 * Created by s94pcp on 2020/4/18.
 */
public class AbstractFactoryTest {
    public static void main(String[] args) {
        //抽象工厂比方法工厂的优势是 新增一个send时 不用改动原来的代码，只需新增一个sender实现类和 工厂类
        EmailFactory emailFactory=new EmailFactory();
        emailFactory.produce().send();
        SmsFactory smsFactory=new SmsFactory();
        smsFactory.produce().send();
    }

}
