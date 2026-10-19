package com.saas.mini.project.service;


import com.saas.mini.project.model.Employee;
import com.saas.mini.project.repository.EmployeeRepository;
import com.saas.mini.project.exception.DuplicateEmployeeException;
import com.saas.mini.project.exception.EmployeeNotFoundException;
import com.saas.mini.project.exception.InvalidEmployeeException;
import com.saas.mini.project.exception.InvalidSubscriptionException;

import java.util.List;
import java.util.Locale;
import java.util.Map;

public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    // Validate the subscription plan
    private String validateSubscriptionPlan(String plan) {

        if (plan == null || plan.isBlank()) {
            throw new InvalidSubscriptionException(
                    "Subscription plan is required");
        }

        String normalizedPlan =
                plan.trim().toUpperCase(Locale.ROOT);

        if (!List.of("BASIC", "STANDARD", "PREMIUM")
                .contains(normalizedPlan)) {
            throw new InvalidSubscriptionException(
                    "Invalid subscription plan: " + plan
                            + ". Allowed plans: BASIC, STANDARD, PREMIUM");
        }

        return normalizedPlan;
    }

    // Validate all employee details
    private void validateEmployee(Employee employee) {

        if (employee == null) {
            throw new InvalidEmployeeException(
                    "Employee cannot be null");
        }

        if (employee.getId() == null || employee.getId() <= 0) {
            throw new InvalidEmployeeException(
                    "Employee ID must be positive");
        }

        if (employee.getName() == null
                || employee.getName().isBlank()) {
            throw new InvalidEmployeeException(
                    "Employee name is required");
        }

        if (employee.getEmail() == null
                || !employee.getEmail().matches(
                "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
            throw new InvalidEmployeeException(
                    "Please provide a valid email address");
        }

        if (!Double.isFinite(employee.getSalary())
                || employee.getSalary() <= 0) {
            throw new InvalidEmployeeException(
                    "Salary must be positive and finite");
        }

        employee.setSubscriptionPlan(
                validateSubscriptionPlan(
                        employee.getSubscriptionPlan()));
    }

    // 1. CREATE EMPLOYEE
    public void createEmployee(Employee employee) {

        validateEmployee(employee);

        if (repository.existsById(employee.getId())) {
            throw new DuplicateEmployeeException(
                    "Employee ID already exists: "
                            + employee.getId());
        }

        if (repository.existsByEmail(employee.getEmail())) {
            throw new DuplicateEmployeeException(
                    "Employee email already exists: "
                            + employee.getEmail());
        }

        repository.save(employee);
    }

    // 2. UPDATE EMPLOYEE
    public void updateEmployee(Long id, Employee updatedEmployee) {

        Employee existingEmployee = findEmployee(id);

        if (updatedEmployee == null) {
            throw new InvalidEmployeeException(
                    "Updated employee cannot be null");
        }

        if (updatedEmployee.getId() == null
                || !id.equals(updatedEmployee.getId())) {
            throw new InvalidEmployeeException(
                    "Employee ID cannot be changed");
        }

        validateEmployee(updatedEmployee);

        if (repository.existsByEmailAndIdNot(
                updatedEmployee.getEmail(), id)) {
            throw new DuplicateEmployeeException(
                    "Email already belongs to another employee");
        }

        existingEmployee.setName(updatedEmployee.getName());
        existingEmployee.setEmail(updatedEmployee.getEmail());
        existingEmployee.setSalary(updatedEmployee.getSalary());
        existingEmployee.setActive(updatedEmployee.isActive());
        existingEmployee.setSubscriptionPlan(
                updatedEmployee.getSubscriptionPlan());
    }

    // 3. FIND EMPLOYEE
    public Employee findEmployee(Long id) {

        if (id == null || id <= 0) {
            throw new InvalidEmployeeException(
                    "Employee ID must be positive");
        }

        return repository.findById(id)
                .orElseThrow(() ->
                        new EmployeeNotFoundException(
                                "Employee not found with ID: " + id));
    }

    // 4. LIST ALL EMPLOYEES
    public List<Employee> listEmployees() {
        return List.copyOf(repository.findAll());
    }

    // 5. DELETE EMPLOYEE
    public void deleteEmployee(Long id) {
        findEmployee(id);
        repository.deleteById(id);
    }

    // 6. FILTER ACTIVE EMPLOYEES
    public List<Employee> getActiveEmployees() {

        return repository.findAll().stream()
                .filter(Employee::isActive)
                .toList();
    }

    // 7. GENERATE SALARY REPORT
    public Map<String, Double> salaryReport() {

        List<Employee> employees = listEmployees();

        double totalSalary = employees.stream()
                .mapToDouble(Employee::getSalary)
                .sum();

        double averageSalary = employees.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0);

        double maximumSalary = employees.stream()
                .mapToDouble(Employee::getSalary)
                .max()
                .orElse(0.0);

        double minimumSalary = employees.stream()
                .mapToDouble(Employee::getSalary)
                .min()
                .orElse(0.0);

        return Map.of(
                "employeeCount", (double) employees.size(),
                "totalSalary", totalSalary,
                "averageSalary", averageSalary,
                "maximumSalary", maximumSalary,
                "minimumSalary", minimumSalary
        );
    }

    // 8. CHECK SUBSCRIPTION PLAN
    public boolean isSubscriptionPlanValid(String plan) {
        validateSubscriptionPlan(plan);
        return true;
    }
}