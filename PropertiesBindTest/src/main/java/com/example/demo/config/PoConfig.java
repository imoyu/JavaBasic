package com.example.demo.config;

import com.example.demo.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class PoConfig {

    @Bean
    public User getUser() {
        return new User();
    }

}
