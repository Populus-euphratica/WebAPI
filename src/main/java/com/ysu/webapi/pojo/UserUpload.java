package com.ysu.webapi.pojo;

import java.sql.Date;

public class UserUpload {
    //    用户详情id
    private int id;
    // 对应的用户id
    private int userId;
    //    API名称
    private String name;
    //    API的简略介绍
    private String descriptionBrief;
    //    API的详细介绍
    private String description;
    //    API的类别
    private String category;
    //    API的版本
    private String versions;
    //    API是否被审查
    private boolean istrue;
    //    API审查是否通过
    private boolean decide;
    //    申请时间
    private Date date;
//    上传者的邮箱
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getVersions() {
        return versions;
    }

    public void setVersions(String versions) {
        this.versions = versions;
    }

    public boolean isIstrue() {
        return istrue;
    }

    public void setIstrue(boolean istrue) {
        this.istrue = istrue;
    }

    public boolean isDecide() {
        return decide;
    }

    public void setDecide(boolean decide) {
        this.decide = decide;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
