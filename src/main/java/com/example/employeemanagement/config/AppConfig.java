package com.example.employeemanagement.config;


import com.example.employeemanagement.mapper.CustomerMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public CustomerMapper customerMapper() {
        return new CustomerMapper();
    }
}
