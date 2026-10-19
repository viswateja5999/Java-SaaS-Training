package com.saas.mini.project.exception;


public class EmployeeNotFoundException extends RuntimeException {

    public EmployeeNotFoundException(String message) {
        super(message);
    }
}