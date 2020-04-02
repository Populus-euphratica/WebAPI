package com.ysu.webapi.pojo;

import java.sql.Date;

public class UploadAPIShow {
    //    用户详情id
    private int id;
    // 对应的用户id
    private int userId;
    //    API名称
    private String name;
    //    API的简略介绍
    private String descriptionBrief;
    //    API的类别
    private String category;
    //    API是否被审查
    private boolean istrue;
    //    API审查是否通过
    private boolean decide;
    //    上传者的邮箱
    private String email;
    //    API版本id号
    private int versionsId;
    //    该版本版本号
    private String versions;
    //    该版本API的logo
    private String logo;

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getVersionsId() {
        return versionsId;
    }

    public void setVersionsId(int versionsId) {
        this.versionsId = versionsId;
    }

    public String getVersions() {
        return versions;
    }

    public void setVersions(String versions) {
        this.versions = versions;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
