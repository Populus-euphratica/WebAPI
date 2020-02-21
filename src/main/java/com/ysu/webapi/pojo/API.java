package com.ysu.webapi.pojo;

public class API {
//    API的id
    private int id;
//    API名称
    private String name;
//    API的简略介绍
    private String descriptionBiref;
//    API的详细介绍
    private String description;
//    API的类别
    private String category;
//    API的版本
    private String Version;

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

    public String getDescriptionBiref() {
        return descriptionBiref;
    }

    public void setDescriptionBiref(String descriptionBiref) {
        this.descriptionBiref = descriptionBiref;
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

    public String getVersion() {
        return Version;
    }

    public void setVersion(String version) {
        Version = version;
    }
}
