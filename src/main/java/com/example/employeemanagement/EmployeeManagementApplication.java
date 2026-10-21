package com.example.employeemanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class EmployeeManagementApplication {

    public static void main(String[] args) {

        SpringApplication.run(EmployeeManagementApplication.class, args);
    }
}
