package com.uu.husky.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 描述：
 *
 * @author liupenghao
 **/
@Data
public class Student implements Serializable {

    private Integer id;
    private String name;

    private Car car;
}
