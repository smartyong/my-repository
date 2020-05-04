package com.example.study.service;

import org.springframework.stereotype.Service;

/**
 * Created by s94pcp on 2020/4/18.
 */
@Service
public class DemoServiceImpl implements  DemoService{
    @Override
    public void doSth(String s) {
        System.out.println(s);
    }
}
