package com.example.study.demo.design_pattern.factory_pattern.method_factory;

import com.example.study.demo.design_pattern.factory_pattern.simple_factory.EmailSender;
import com.example.study.demo.design_pattern.factory_pattern.simple_factory.Sender;
import com.example.study.demo.design_pattern.factory_pattern.simple_factory.SmsSender;

/**
 * Created by s94pcp on 2020/4/18.
 */
public class SendFactory {

    public  Sender getSmsSender(){
        return new SmsSender();
    }

    public  Sender getEmailSender(){
        return new EmailSender();
    }
}
