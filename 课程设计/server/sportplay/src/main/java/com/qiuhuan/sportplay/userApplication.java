package com.qiuhuan.sportplay;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.qiuhuan.sportplay.Dao") //扫描dao层
@SpringBootApplication
public class userApplication {  //启动类
    public static void main(String[] args) {
        SpringApplication.run(userApplication.class, args);
    }
}
