package com.tream.coach.user.entity;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private Integer id;

    private String loginId;

    private String password;

    private String name;

    private Integer age;

    private String sex;

    private String address;

    private String tel;

    private String mail;

    private String role;

    private String level;

    private String identifyNum;

    private String delFlag;

    private String costSum;

    private Date birth;


}