package com.example.study.controller;

import com.example.study.domain.Persion;
import com.example.study.service.PersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Administrator on 2020/8/13 0013.
 */
@RestController("/api/v1")
public class PersionController {

    @Autowired
    PersionService persionService;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String  addPersion(@RequestBody Persion persion){

        persionService.addPersion(persion);

        return "OK";
    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public String  updatePersion(@RequestBody Persion persion){

        persionService.updatePersion(persion);

        return "OK";
    }
    @RequestMapping(value ="/getall",method = RequestMethod.GET)
    public List<Persion> getAllPersion(){

        return  persionService.getAllPersion();

    }

    @RequestMapping(value ="/delete/{id}",method = RequestMethod.DELETE)
    public String  deletePersion(@PathVariable ("id") Integer id){

        persionService.deletePersion(id);

        return "OK";
    }
}
