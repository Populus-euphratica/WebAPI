package com.ysu.webapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *
 * @method Swagger2配置类
 * @time 2020年2月21日
 */
@Configuration //标记配置类
@EnableSwagger2 //开启在线接口文档
public class Swagger2 {
    /**
     * 添加摘要信息(Docket)
     */
    @Bean
    public Docket controllerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ysu.webapi"))
                .paths(PathSelectors.any())
                .build();
    }

    @SuppressWarnings("deprecation")
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Bootstrap WebAPI网站 API接口")
                .description("描述：用于Bootstrap WebAPI网站API接口文档，访问地址：http://localhost:8080/swagger-ui.html")
                .contact("贾廷刚")
                .version("版本号:v1.0")
                .build();
    }
}
