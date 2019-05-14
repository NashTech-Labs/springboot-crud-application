package com.knoldus.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ApplicationLoader {
    
    public static void main(String[] args) {
        
        SpringApplication.run(ApplicationLoader.class, args);
    }
}
