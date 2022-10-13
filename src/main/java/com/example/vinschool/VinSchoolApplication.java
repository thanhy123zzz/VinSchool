package com.example.vinschool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

@SpringBootApplication(scanBasePackages = "com.example.vinschool")
public class VinSchoolApplication {

    public static void main(String[] args) {
        SpringApplication.run(VinSchoolApplication.class, args);

    }

}
