package com.library.user.pojo;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Resource {
    private Long id;
    private String name;
    private Timestamp publish_date;
    private Long storage_all;
    private Long storage_avail;
    private String author;
    private String publisher;
    private String language;
    private String country;
    private String ISBN;
    private Long access;
    private String translator;
    private String zhongtu;
    private String ketu;
    private String image;


}
