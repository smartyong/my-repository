package com.example.study.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Created by s94pcp on 2020/4/14.
 */
@Component
public class SpringcontextUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("初始化了");
        SpringcontextUtil.applicationContext = applicationContext;

    }
    public static ApplicationContext getApplicationContext(){
        return applicationContext;
    }

    /**
     * 用bean组件的name来获取bean
     * @param beanName
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T>T getBean(String beanName){
        return (T) applicationContext.getBean(beanName);
    }

    /**
     * 用类来获取bean
     * @param c
     * @return
     */
    public static <T> T getBean(Class<T> c){
        return (T) applicationContext.getBean(c);
    }

}
