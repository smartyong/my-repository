package com.example.study.demo.design_pattern.factory_pattern.simple_factory;

/**
 * Created by s94pcp on 2020/4/18.
 */
public class SendFactory {

    public Sender getSender(String sendType){
        if ("sms".equals(sendType)){
            return new SmsSender();
        }else if ("email".equals(sendType)){
            return  new EmailSender();
        }else {
            System.out.println("参数错误！");
            return null;
        }
    }

}
