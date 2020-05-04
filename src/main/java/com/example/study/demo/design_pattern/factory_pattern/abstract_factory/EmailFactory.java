package com.example.study.demo.design_pattern.factory_pattern.abstract_factory;

import com.example.study.demo.design_pattern.factory_pattern.simple_factory.EmailSender;
import com.example.study.demo.design_pattern.factory_pattern.simple_factory.Sender;

/**
 * Created by s94pcp on 2020/4/18.
 */
public class EmailFactory  implements  Producer{
    @Override
    public Sender produce() {
        return new EmailSender();
    }
}
