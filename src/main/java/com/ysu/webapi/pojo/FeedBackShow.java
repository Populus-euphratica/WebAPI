package com.ysu.webapi.pojo;

import java.sql.Date;

public class FeedBackShow {
    //    反馈id
    private int id;
    //    反馈的主题题目
    private String theme;
    //    反馈的内容
    private String content;
    //    反馈日期
    private Date date;
    //    反馈用户的id
    private int userid;
    //    管理员的回复
    private String reply;
    //用户所在的公司
    private String company;
    //    用户的名称
    private String name;
    //    用户的邮箱
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
