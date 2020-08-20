package com.example.study.demo.design_pattern.prototype;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Administrator on 2020/8/20 0020.
 */
public class Test {
    /**
     * prototype  测试
     * @param args
     */
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        Object bean = applicationContext.getBean("001");
        System.out.println(bean.toString());
        Object bean2 = applicationContext.getBean("001");
        System.out.println(bean2.toString());
        System.out.println(bean==bean2);//false
    }
}
