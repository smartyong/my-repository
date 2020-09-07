package com.example.study.demo.design_pattern.adapter.objectadapter;

import com.example.study.demo.design_pattern.adapter.classadapter.Phone;
import com.example.study.demo.design_pattern.adapter.classadapter.Voltage220V;
import com.example.study.demo.design_pattern.adapter.classadapter.VoltageAdapter;

/**
 * Created by Administrator on 2020/8/20 0020.
 */
public class ClientTest {

    public static void main(String[] args) {

        Phone phone=new Phone();
        phone.charging(new VoltageAdapter2(new Voltage220V()));

    }

}
