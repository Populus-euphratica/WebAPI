package com.ysu.webapi.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class APIVersions {
//    API版本id号
    private int id;
//    对应的APIid
    private int APIId;
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

    public APIVersions(UploadAPIVersions uploadAPIVersions){
        this.APIId=uploadAPIVersions.getAPIId();
        this.name=uploadAPIVersions.getName();
        this.description=uploadAPIVersions.getDescription();
        this.category=uploadAPIVersions.getCategory();
        this.logo=uploadAPIVersions.getLogo();
        this.versions=uploadAPIVersions.getVersions();
    }
    public APIVersions(){

    }

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
}
