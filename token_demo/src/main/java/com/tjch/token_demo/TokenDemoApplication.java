package com.tjch.token_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//包扫描
@SpringBootApplication(scanBasePackages= {"com.tjch.token_demo.*"})
public class TokenDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(TokenDemoApplication.class, args);
    }

}
