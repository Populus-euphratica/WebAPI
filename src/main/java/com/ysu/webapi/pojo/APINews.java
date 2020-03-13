package com.ysu.webapi.pojo;


import java.sql.Date;

public class APINews {
//    新闻id
    private int id;
//    新闻名称
    private String name;
//    新闻作者
    private String author;
//    发表日期
    private Date date;
//    资讯种类
    private String category;
//    新闻内容
    private String content;
//    资讯简介
    private String contentBrief;

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContentBrief() {
        return contentBrief;
    }

    public void setContentBrief(String contentBrief) {
        this.contentBrief = contentBrief;
    }
}
