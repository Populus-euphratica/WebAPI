package com.ysu.webapi.pojo;

import java.sql.Date;

public class ApplyForAdmin {
    //申请管理员的id
    private int id;
    //    申请者的名字
    private String name;
    //    申请者的邮箱
    private String email;
    //    申请者的密码
    private String password;
    //    申请原因
    private String reason;
    //    申请日期
    private Date date;
    //    是否被审核
    private boolean istrue;
    //    是否同意
    private boolean decide;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
