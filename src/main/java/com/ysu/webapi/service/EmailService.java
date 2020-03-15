package com.ysu.webapi.service;

public interface EmailService {
    public boolean sendHtmlMail(String to,  String content);
}
