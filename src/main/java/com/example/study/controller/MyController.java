package com.example.study.controller;

import com.example.study.service.DemoService;
import com.example.study.service.DemoServiceImpl;
import com.example.study.util.MessageUtil;
import com.example.study.util.SpringcontextUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;


/**
 * Created by s94pcp on 2020/4/18.
 */
@RestController
@RequestMapping("/api/v1")
public class MyController {
    public final static Logger log= LoggerFactory.getLogger(MyController.class);

    @Autowired
    DemoService demoService;

    @RequestMapping(value="/hello",method= RequestMethod.GET)
    public ResponseEntity<?>  helloWorld(){

        return new ResponseEntity<>("helloworld", HttpStatus.OK);
    }


    @RequestMapping(value="/hello/{key}/{lang}",method= RequestMethod.GET)
    public String test1(@PathVariable("key")String key, @PathVariable("lang")String lang) {
        log.info("MyController test input hello222");
        String[] strings = lang.split("_");
        demoService.doSth(key);
        MessageUtil messageUtil = SpringcontextUtil.getBean(MessageUtil.class);
        log.info("MyController test SpringcontextUtil getBean");
        return messageUtil.getMsg(key,new Locale(strings[0],strings[1]));
    }

}
