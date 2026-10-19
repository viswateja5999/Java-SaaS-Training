package com.saas.mini.project.exception;


public class InvalidEmployeeException extends RuntimeException {

    public InvalidEmployeeException(String message) {
        super(message);
    }
}