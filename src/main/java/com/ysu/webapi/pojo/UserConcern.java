package com.ysu.webapi.pojo;

import java.sql.Date;

public class UserConcern {
//    用户详情id
    private int id;
    // 对应的用户id
    private int userId;
//    用户关注的API
    private String userConcern;
//    收藏日期
    private Date date;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserConcern() {
        return userConcern;
    }

    public void setUserConcern(String userConcern) {
        this.userConcern = userConcern;
    }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
