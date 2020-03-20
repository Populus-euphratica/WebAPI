package com.ysu.webapi.pojo;

import java.sql.Date;

public class FeedBack {
//    反馈id
    private int id;
//    反馈的主题题目
    private String theme;
//    反馈的内容
    private String content;
//    反馈用户的id
    private int userId;
//    反馈日期
    private Date date;
//    反馈是否被审核
    private boolean istrue;
//    管理员的回复
    private String reply;
//    回复还是忽略
    private boolean decide;

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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public boolean isIstrue() {
        return istrue;
    }

    public void setIstrue(boolean istrue) {
        this.istrue = istrue;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isDecide() {
        return decide;
    }

    public void setDecide(boolean decide) {
        this.decide = decide;
    }
}
