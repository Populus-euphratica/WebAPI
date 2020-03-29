package com.ysu.webapi;


import javafx.application.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@ServletComponentScan                   //不明白
@EnableTransactionManagement
public class WebapiApplication extends SpringBootServletInitializer {
    public static final int pageSize=10;
    public static void main(String[] args) {
        SpringApplication.run(WebapiApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Application.class);
    }


}
