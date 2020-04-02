package com.ysu.webapi.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Date;

public class UploadAPIVersions {
    //    API版本id号
    private int id;
    //    对应的APIid
    private int APIId;
    // 对应的用户id
    private int userId;
    //    该版本API的名称
    private String name;
    //    该版本API的详细描述
    private String description;
    //    该版本API的类别
    private String category;
    //    该版本API的logo
    private String logo;
    //    该版本版本号
    private String versions;
    //    申请时间
    private Date date;
    //    API是否被审查
    private boolean istrue;
    //    API审查是否通过
    private boolean decide;
    //    上传者的邮箱
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @JsonProperty(value = "APIId")
    public int getAPIId() {
        return APIId;
    }

    public void setAPIId(int APIId) {
        this.APIId = APIId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getVersions() {
        return versions;
    }

    public void setVersions(String versions) {
        this.versions = versions;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
