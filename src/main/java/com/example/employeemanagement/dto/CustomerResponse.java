package com.example.employeemanagement.dto;

import java.math.BigDecimal;

public record CustomerResponse(
        Long id,
        String name,
        String email,
        BigDecimal salary
) {
}