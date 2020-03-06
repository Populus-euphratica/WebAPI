package com.ysu.webapi.pojo;

public class UserInfo {
//    用户详情id
    private int id;
//    对应的用户id
    private int userId;
//    用户关注的API
    private String userConcern;
//    用户上传的API
    private String userUpload;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserid(int userid) {
        this.userId = userId;
    }

    public String getUserConcern() {
        return userConcern;
    }

    public void setUserConcern(String userConcern) {
        this.userConcern = userConcern;
    }

    public String getUserUpload() {
        return userUpload;
    }

    public void setUserUpload(String userUpload) {
        this.userUpload = userUpload;
    }

}
