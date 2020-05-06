package com.example.study.demo.serialize;

import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by s94pcp on 2020/5/6.
 */
@ToString
public class MySerializeDTO implements Serializable{
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private Date birthDay;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }
}
