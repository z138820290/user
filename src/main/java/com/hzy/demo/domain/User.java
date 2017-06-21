package com.hzy.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by 何峥言 on 2017/6/16.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private int id;
    private String name;
    private int age;
    private int sex;
    private String address;
    private String email;

    public User(String name, int age, int sex, String address, String email) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.address = address;
        this.email = email;
    }
}
