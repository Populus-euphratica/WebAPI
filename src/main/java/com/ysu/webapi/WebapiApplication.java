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
public class WebapiApplication {
    public static final int pageSize=10;
    public static final String path="C:\\Users\\xxx\\Desktop\\Pingendo\\Web\\default\\APILogo\\";
    public static final String userPath="C:\\Users\\xxx\\Desktop\\Pingendo\\Web\\default\\UserAPILogo\\";
    public static final String logoPath="C:\\Users\\xxx\\Desktop\\Pingendo\\Web\\default\\image\\";
    public static void main(String[] args) {
        SpringApplication.run(WebapiApplication.class, args);
    }
//extends SpringBootServletInitializer
//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//        return builder.sources(Application.class);
//    }


}
