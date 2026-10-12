package com.saas.memory.repository;

public class Main {

    public static void main(String[] args) {

        EmployeeRepository repository = new EmployeeRepository();

        Employee emp1 = new Employee(101L, "Ravi", "IT", 50000);
        Employee emp2 = new Employee(102L, "Priya", "HR", 45000);
        Employee emp3 = new Employee(103L, "Arun", "Finance", 60000);

        // Save employees
        repository.save(emp1);
        repository.save(emp2);
        repository.save(emp3);

        // Find employee by ID
        System.out.println("Employee with ID 101:");
        System.out.println(repository.findById(101L));

        // Find all employees
        System.out.println("\nAll Employees:");
        for (Employee employee : repository.findAll()) {
            System.out.println(employee);
        }

        // Check whether employee exists
        System.out.println("\nEmployee 102 exists: "
                + repository.existsById(102L));

        // Delete employee
        repository.deleteById(102L);

        // Check again after deletion
        System.out.println("Employee 102 exists after deletion: "
                + repository.existsById(102L));
    }
}
