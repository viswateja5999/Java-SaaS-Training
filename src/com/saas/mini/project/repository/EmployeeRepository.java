package com.saas.mini.project.repository;


import com.saas.mini.project.model.Employee;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class EmployeeRepository {

    private final Map<Long, Employee> employees = new HashMap<>();

    // Save or replace an employee by ID
    public void save(Employee employee) {
        employees.put(employee.getId(), employee);
    }

    // Find an employee by ID
    public Optional<Employee> findById(Long id) {
        return Optional.ofNullable(employees.get(id));
    }

    // Get all employees
    public Collection<Employee> findAll() {
        return employees.values();
    }

    // Check whether an ID already exists
    public boolean existsById(Long id) {
        return employees.containsKey(id);
    }

    // Check whether an email already exists
    public boolean existsByEmail(String email) {
        return employees.values().stream()
                .anyMatch(employee ->
                        employee.getEmail().equalsIgnoreCase(email));
    }

    // Check whether another employee owns the email
    public boolean existsByEmailAndIdNot(String email, Long id) {
        return employees.values().stream()
                .anyMatch(employee ->
                        !employee.getId().equals(id)
                                && employee.getEmail().equalsIgnoreCase(email));
    }

    // Delete an employee by ID
    public void deleteById(Long id) {
        employees.remove(id);
    }
}