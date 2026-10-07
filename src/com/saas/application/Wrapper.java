package com.saas.application;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Wrapper {
    public static void main(String[] args) {
        Integer employeeId = 5999;
        Long salary = 50000L;
        Double subscriptionPlan = 888.88;
        Boolean employeeActive = true;
        LocalDate joiningDate = LocalDate.of(2026, 10, 6);
        LocalDate subscriptionStartDate = LocalDate.now();
        LocalDate subscriptionExpiryDate = subscriptionStartDate.plusMonths(1);
        LocalDateTime createdAt = LocalDateTime.now();

        System.out.println("Employee ID: "+ employeeId);
        System.out.println("Salary: "+ salary);
        System.out.println("Subscription Plan: "+ subscriptionPlan);
        System.out.println("Employee Active: "+employeeActive);
        System.out.println("Joining Date: "+joiningDate);
        System.out.println("Subscription Start Date: "+subscriptionStartDate);
        System.out.println("Subscription Expiry Date: "+subscriptionExpiryDate);
        System.out.println("Created At: "+createdAt);
    }
}
