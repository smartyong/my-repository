package com.example.study.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

/**
 * Created by s94pcp on 2020/4/14.
 */
@Component
public class MessageUtil {

    @Autowired
    MessageSource messageSource;

    public String getMsg(String key,Locale locale){
        return messageSource.getMessage(key,null,locale);
    }
}
