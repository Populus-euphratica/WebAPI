package com.ysu.webapi.pojo;

public class Admin {
//    管理员id
    private int id;
//    管理员姓名
    private String name;
//    管理员邮箱
    private String email;
//    管理员密码
    private String password;

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
}
