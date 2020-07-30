package com.example.mdbdouban;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.definesys.mpaas","com.example.mdbdouban"})
public class MdbdoubanApplication {

    public static void main(String[] args) {
        SpringApplication.run(MdbdoubanApplication.class, args);
    }

}
