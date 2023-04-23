package com.example.webbanquanao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
public class WebBanQuanAoApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebBanQuanAoApplication.class, args);
        System.out.println("success");
    }

}



