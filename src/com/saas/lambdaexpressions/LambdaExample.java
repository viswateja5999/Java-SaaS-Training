package com.saas.lambdaexpressions;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Employee {

    private int id;
    private String name;
    private String department;
    private double salary;
    private boolean active;

    public Employee(int id, String name, String department, double salary, boolean active) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public boolean isActive() {
        return active;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                ", active=" + active +
                '}';
    }
}

public class LambdaExample {

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee(1, "Ravi", "IT", 60000, true));
        employees.add(new Employee(2, "Sita", "HR", 50000, false));
        employees.add(new Employee(3, "Arun", "IT", 75000, true));
        employees.add(new Employee(4, "Priya", "Finance", 65000, true));
        employees.add(new Employee(5, "Kiran", "HR", 55000, true));

        // 1. Filter active employees
        List<Employee> activeEmployees = employees.stream()
                .filter(employee -> employee.isActive())
                .collect(Collectors.toList());

        System.out.println("Active Employees:");
        activeEmployees.forEach(employee -> System.out.println(employee));

        // 2. Sort employees by salary
        List<Employee> sortedEmployees = employees.stream()
                .sorted((employee1, employee2) ->
                        Double.compare(employee1.getSalary(), employee2.getSalary()))
                .collect(Collectors.toList());

        System.out.println("\nEmployees Sorted By Salary:");
        sortedEmployees.forEach(employee -> System.out.println(employee));

        // 3. Find employees by department
        String department = "IT";

        List<Employee> departmentEmployees = employees.stream()
                .filter(employee -> employee.getDepartment().equals(department))
                .collect(Collectors.toList());

        System.out.println("\nEmployees In IT Department:");
        departmentEmployees.forEach(employee -> System.out.println(employee));
    }
}