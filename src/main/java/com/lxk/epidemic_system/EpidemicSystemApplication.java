package com.lxk.epidemic_system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.lxk.epidemic_system.mapper")
public class EpidemicSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(EpidemicSystemApplication.class, args);
    }

}
