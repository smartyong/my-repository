package com.example.study.demo.design_pattern.factory_pattern.abstract_factory;

import com.example.study.demo.design_pattern.factory_pattern.simple_factory.Sender;
import com.example.study.demo.design_pattern.factory_pattern.simple_factory.SmsSender;

/**
 * Created by s94pcp on 2020/4/18.
 */
public class SmsFactory implements Producer{
    @Override
    public Sender produce() {
        return new SmsSender();
    }
}
