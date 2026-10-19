package com.saas.mini.project;

import com.saas.mini.project.model.Employee;
import com.saas.mini.project.repository.EmployeeRepository;
import com.saas.mini.project.service.EmployeeService;
import com.saas.mini.project.exception.DuplicateEmployeeException;
import com.saas.mini.project.exception.EmployeeNotFoundException;
import com.saas.mini.project.exception.InvalidEmployeeException;
import com.saas.mini.project.exception.InvalidSubscriptionException;

public class Main {

    public static void main(String[] args) {

        // Connect the repository and service
        EmployeeRepository repository = new EmployeeRepository();
        EmployeeService service = new EmployeeService(repository);

        // 1. CREATE EMPLOYEES
        System.out.println("=== CREATE EMPLOYEES ===");

        service.createEmployee(new Employee(
                101L, "Ravi", "ravi@example.com",
                40000, true, "BASIC"));

        service.createEmployee(new Employee(
                102L, "Priya", "priya@example.com",
                50000, true, "PREMIUM"));

        service.createEmployee(new Employee(
                103L, "Arjun", "arjun@example.com",
                35000, false, "STANDARD"));

        System.out.println("Employees created successfully.");

        // 2. LIST ALL EMPLOYEES
        System.out.println("\n=== ALL EMPLOYEES ===");
        service.listEmployees().forEach(System.out::println);

        // 3. FIND AN EMPLOYEE
        System.out.println("\n=== FIND EMPLOYEE ===");
        System.out.println(service.findEmployee(101L));

        // 4. UPDATE AN EMPLOYEE
        System.out.println("\n=== UPDATE EMPLOYEE ===");

        service.updateEmployee(101L, new Employee(
                101L, "Ravi Kumar", "ravi@example.com",
                45000, true, "STANDARD"));

        System.out.println(service.findEmployee(101L));

        // 5. FILTER ACTIVE EMPLOYEES
        System.out.println("\n=== ACTIVE EMPLOYEES ===");

        service.getActiveEmployees()
                .forEach(System.out::println);

        // 6. SALARY REPORT
        System.out.println("\n=== SALARY REPORT ===");
        System.out.println(service.salaryReport());

        // 7. VALIDATE SUBSCRIPTION PLAN
        System.out.println("\n=== SUBSCRIPTION VALIDATION ===");

        System.out.println(
                "PREMIUM valid: "
                        + service.isSubscriptionPlanValid("PREMIUM"));

        // 8. DEMONSTRATE DUPLICATE EMPLOYEE EXCEPTION
        System.out.println("\n=== DUPLICATE VALIDATION ===");

        try {
            service.createEmployee(new Employee(
                    101L, "Another Ravi", "another@example.com",
                    30000, true, "BASIC"));
        } catch (DuplicateEmployeeException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // 9. DEMONSTRATE INVALID SUBSCRIPTION
        System.out.println("\n=== INVALID SUBSCRIPTION ===");

        try {
            service.createEmployee(new Employee(
                    104L, "Kiran", "kiran@example.com",
                    30000, true, "GOLD"));
        } catch (InvalidSubscriptionException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // 10. DEMONSTRATE INVALID EMPLOYEE
        System.out.println("\n=== INVALID EMPLOYEE ===");

        try {
            service.createEmployee(new Employee(
                    105L, "", "wrong-email",
                    -1000, true, "BASIC"));
        } catch (InvalidEmployeeException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // 11. DELETE AN EMPLOYEE
        System.out.println("\n=== DELETE EMPLOYEE ===");

        service.deleteEmployee(103L);
        System.out.println("Employee 103 deleted successfully.");

        // 12. LIST EMPLOYEES AFTER DELETION
        System.out.println("\n=== EMPLOYEES AFTER DELETION ===");

        service.listEmployees().forEach(System.out::println);

        // 13. DEMONSTRATE EMPLOYEE NOT FOUND EXCEPTION
        System.out.println("\n=== NOT FOUND VALIDATION ===");

        try {
            service.findEmployee(999L);
        } catch (EmployeeNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}