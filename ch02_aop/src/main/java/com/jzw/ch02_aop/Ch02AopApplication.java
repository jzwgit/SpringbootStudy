package com.jzw.ch02_aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//exclude解除自动加载的mybatis类
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class Ch02AopApplication {

    public static void main(String[] args) {
        SpringApplication.run(Ch02AopApplication.class, args);
    }
}
