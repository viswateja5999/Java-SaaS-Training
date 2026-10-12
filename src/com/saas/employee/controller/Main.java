package com.saas.employee.controller;

import com.saas.employee.repositry.EmployeeRepository;
import com.saas.employee.service.EmployeeService;

public class Main {

    public static void main(String[] args) {

        EmployeeRepository repository = new EmployeeRepository();

        EmployeeService service = new EmployeeService(repository);

        EmployeeController controller = new EmployeeController(service);

        controller.start();
    }
}