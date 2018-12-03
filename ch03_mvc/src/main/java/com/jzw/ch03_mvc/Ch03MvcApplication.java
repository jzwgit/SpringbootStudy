package com.jzw.ch03_mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class Ch03MvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(Ch03MvcApplication.class, args);
    }
}
