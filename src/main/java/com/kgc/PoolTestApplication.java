package com.kgc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
@MapperScan("com.kgc.mapper")
public class PoolTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(PoolTestApplication.class, args);
    }

}
