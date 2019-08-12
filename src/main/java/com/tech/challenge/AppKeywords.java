package com.tech.challenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({"aws-keywords.xml"})
public class AppKeywords {

    public static void main(String[] args) {
        SpringApplication.run(AppKeywords.class, args);
    }

}
