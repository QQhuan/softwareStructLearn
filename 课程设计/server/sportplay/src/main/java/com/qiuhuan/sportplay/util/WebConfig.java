package com.qiuhuan.sportplay.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") //端口路径
                .allowedOrigins("http://localhost:8080", "null") //允许请求源
                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE") //允许的方法
                .maxAge(3600)               //请求最大时长
                .allowCredentials(true); //写在凭证信息，例如cookie等
    }
}
