package com.ysu.webapi.pojo;

public class APIShow {

    //    API的id
    private int id;
    //    API名称
    private String name;
    //    API的简略介绍
    private String descriptionBrief;
    //    API的类别
    private String category;
    //    API版本id号
    private int APIVersionId;
    //    该版本版本号
    private String versions;

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

    public int getAPIVersionId() {
        return APIVersionId;
    }

    public void setAPIVersionId(int APIVersionId) {
        this.APIVersionId = APIVersionId;
    }

    public String getVersions() {
        return versions;
    }

    public void setVersions(String versions) {
        this.versions = versions;
    }
}
