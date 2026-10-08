package com.saas.streamapi;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Employee {

    private int id;
    private String name;
    private String department;
    private double salary;
    private boolean active;

    public Employee(int id, String name, String department,
                    double salary, boolean active) {

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

public class StramApi {

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee(1, "Ravi", "IT", 60000, true));
        employees.add(new Employee(2, "Sita", "HR", 50000, false));
        employees.add(new Employee(3, "Arun", "IT", 85000, true));
        employees.add(new Employee(4, "Priya", "Finance", 70000, true));
        employees.add(new Employee(5, "Kiran", "HR", 55000, true));
        employees.add(new Employee(6, "Anil", "Finance", 90000, true));


        // 1. Active employee count
        long activeEmployeeCount = employees.stream()
                .filter(employee -> employee.isActive())
                .count();

        System.out.println("Active Employee Count: " + activeEmployeeCount);


        // 2. Highest salary
        Employee highestSalaryEmployee = employees.stream()
                .sorted((employee1, employee2) ->
                        Double.compare(employee2.getSalary(),
                                employee1.getSalary()))
                .findFirst()
                .orElse(null);

        System.out.println("\nHighest Salary Employee:");
        System.out.println(highestSalaryEmployee);


        // 3. Employees by department
        Map<String, List<Employee>> employeesByDepartment =
                employees.stream()
                        .collect(Collectors.groupingBy(
                                employee -> employee.getDepartment()
                        ));

        System.out.println("\nEmployees By Department:");

        employeesByDepartment.forEach((department, employeeList) -> {
            System.out.println(department + ":");
            employeeList.forEach(employee ->
                    System.out.println("  " + employee.getName()));
        });


        // 4. Average salary
        double averageSalary = employees.stream()
                .map(employee -> employee.getSalary())
                .collect(Collectors.averagingDouble(
                        salary -> salary
                ));

        System.out.println("\nAverage Salary: " + averageSalary);


        // 5. Employees above salary threshold
        double salaryThreshold = 65000;

        List<Employee> employeesAboveThreshold = employees.stream()
                .filter(employee ->
                        employee.getSalary() > salaryThreshold)
                .collect(Collectors.toList());

        System.out.println("\nEmployees Above Salary Threshold:");

        employeesAboveThreshold.forEach(employee ->
                System.out.println(employee));


        // 6. findFirst()
        Employee firstEmployee = employees.stream()
                .findFirst()
                .orElse(null);

        System.out.println("\nFirst Employee:");
        System.out.println(firstEmployee);


        // 7. map()
        List<String> employeeNames = employees.stream()
                .map(employee -> employee.getName())
                .collect(Collectors.toList());

        System.out.println("\nEmployee Names:");
        System.out.println(employeeNames);


        // 8. sorted()
        List<Employee> sortedBySalary = employees.stream()
                .sorted((employee1, employee2) ->
                        Double.compare(employee1.getSalary(),
                                employee2.getSalary()))
                .collect(Collectors.toList());

        System.out.println("\nEmployees Sorted By Salary:");

        sortedBySalary.forEach(employee ->
                System.out.println(employee));


        // 9. anyMatch()
        boolean anyHighSalaryEmployee = employees.stream()
                .anyMatch(employee ->
                        employee.getSalary() > 80000);

        System.out.println("\nAny employee with salary above 80000: "
                + anyHighSalaryEmployee);


        // 10. allMatch()
        boolean allEmployeesActive = employees.stream()
                .allMatch(employee ->
                        employee.isActive());

        System.out.println("Are all employees active: "
                + allEmployeesActive);
    }
}
