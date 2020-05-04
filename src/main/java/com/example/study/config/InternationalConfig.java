package com.example.study.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

/**
 * Created by s94pcp on 2020/4/14.
 */
@Configuration
public class InternationalConfig {

    @Value("${spring.messages.basename:i18n/messages}")
    private String msgBaseName;

    /**
     * 设置国际化 文件路径
     * @return
     */
    @Bean (name = "messageSource")
    public ResourceBundleMessageSource  addBaseName(){
        ResourceBundleMessageSource messageSource=new ResourceBundleMessageSource();
        messageSource.setBasename(msgBaseName);
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

}
