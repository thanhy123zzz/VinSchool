package com.example.vinschool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.vinschool")
public class VinSchoolApplication {

    public static void main(String[] args) {
        SpringApplication.run(VinSchoolApplication.class, args);
    }

}
