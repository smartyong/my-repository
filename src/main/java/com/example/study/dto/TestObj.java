package com.example.study.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

/**
 * Created by Administrator on 2020/8/18 0018.
 */
@Data
@ToString
public class TestObj {
    private Integer id=100;
    private String optType="add";
    private String mark="hahah";
}
