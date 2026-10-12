package com.saas.employee.controller;

import com.saas.employee.exception.EmployeeNotFoundException;
import com.saas.employee.exception.InvalidEmployeeException;
import com.saas.employee.model.Employee;
import com.saas.employee.service.EmployeeService;
import com.saas.employee.util.InputUtil;

import java.util.List;

public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    public void start() {
        boolean running = true;

        while (running) {
            System.out.println("\n--- Employee Management System ---");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Find Employee By ID");
            System.out.println("4. Deactivate Employee");
            System.out.println("5. Exit");

            int choice = InputUtil.readInt("Enter your choice: ");

            try {
                switch (choice) {
                    case 1 -> addEmployee();
                    case 2 -> viewAllEmployees();
                    case 3 -> findEmployee();
                    case 4 -> deactivateEmployee();
                    case 5 -> {
                        running = false;
                        System.out.println("Application closed.");
                    }
                    default -> System.out.println("Invalid menu choice.");
                }
            } catch (InvalidEmployeeException
                     | EmployeeNotFoundException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private void addEmployee() {
        int id = InputUtil.readInt("Enter employee ID: ");
        String name = InputUtil.readString("Enter employee name: ");
        String department = InputUtil.readString("Enter department: ");
        double salary = InputUtil.readDouble("Enter salary: ");

        Employee employee = new Employee(
                id, name, department, salary);

        service.addEmployee(employee);

        System.out.println("Employee added successfully.");
    }

    private void viewAllEmployees() {
        List<Employee> employees = service.getAllEmployees();

        if (employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }

        employees.forEach(System.out::println);
    }

    private void findEmployee() {
        int id = InputUtil.readInt("Enter employee ID: ");

        Employee employee = service.getEmployeeById(id);

        System.out.println(employee);
    }

    private void deactivateEmployee() {
        int id = InputUtil.readInt("Enter employee ID: ");

        service.deactivateEmployee(id);

        System.out.println("Employee deactivated successfully.");
    }
}