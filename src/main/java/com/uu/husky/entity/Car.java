package com.uu.husky.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 描述：
 *
 * @author liupenghao
 **/
@Data
public class Car implements Serializable {

    private String name;

    private Float price;
}
