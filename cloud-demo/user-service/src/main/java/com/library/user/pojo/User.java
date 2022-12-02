package com.library.user.pojo;

import lombok.Data;

import java.sql.Timestamp;


@Data
public class User {
    private Long id;
    private String name;        //唯一
    private String password;
    private String avatar;
    private Long role;
    private Long card_id;
    private Timestamp created_time;    //绑卡时间
    private Long access;      //可以借阅的资源类型

}