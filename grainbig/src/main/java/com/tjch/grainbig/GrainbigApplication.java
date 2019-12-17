package com.tjch.grainbig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//包扫描
@SpringBootApplication(scanBasePackages= {"com.tjch.grainbig.*"})
public class GrainbigApplication {

    public static void main(String[] args) {

        SpringApplication.run(GrainbigApplication.class, args);
    }

}
