package com.ysu.webapi.pojo;

import java.sql.Date;

public class APIShow {

    //    API的id
    private int id;
    //    API名称
    private String name;
    //    API的简略介绍
    private String descriptionBrief;
    //    API的类别
    private String category;
    //    收藏日期
    private Date date;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescriptionBrief() {
        return descriptionBrief;
    }

    public void setDescriptionBrief(String descriptionBrief) {
        this.descriptionBrief = descriptionBrief;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
