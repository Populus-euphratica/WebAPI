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
    private Date data;
//    新闻内容
    private String content;

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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
