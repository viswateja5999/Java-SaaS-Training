package com.saas.generics;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //ApiResult<Employee>
        Employee employee = new Employee(101, "Teja", "IT", 6666.99);
        ApiResult<Employee> employeeResult = new ApiResult<>(true, "Employee fetched successfully", employee);
        System.out.println(employeeResult);

        //ApiResult<List<Employee>>
        Employee employee2 = new Employee(102, "Viswa", "HR", 78777.9);
        List<Employee> employees = Arrays.asList(employee, employee2);
        ApiResult<List<Employee>> employeeListResult = new ApiResult<>(true, "Employee fetched Ssuccessfully", employees);
        System.out.println(employeeListResult);

        //ApiResult<String>
        ApiResult<String> messageResult = new ApiResult<>(true, "Operation completed", "Employee created successfully");
        System.out.println(messageResult);
    }
}
