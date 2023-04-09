package com.example.webbanquanao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class WebBanQuanAoApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebBanQuanAoApplication.class, args);
        System.out.println("success");
    }

}
