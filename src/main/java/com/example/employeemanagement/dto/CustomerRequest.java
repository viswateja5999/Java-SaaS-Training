package com.example.employeemanagement.dto;


import jakarta.validation.constraints.*;
import java.math.BigDecimal;

public record CustomerRequest(

        @NotBlank(message = "Name is required")
        @Size(max = 100, message = "Name cannot exceed 100 characters")
        String name,

        @NotBlank(message = "Email is required")
        @Email(message = "Email format is invalid")
        @Size(max = 150, message = "Email cannot exceed 150 characters")
        String email,

        @NotNull(message = "Salary is required")
        @DecimalMin(value = "0.01",
                message = "Salary must be greater than zero")
        @Digits(integer = 10, fraction = 2,
                message = "Salary must have at most 10 integer digits and 2 decimal places")
        BigDecimal salary
) {
}
