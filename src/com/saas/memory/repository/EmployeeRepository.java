package com.saas.memory.repository;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeRepository {

    private final Map<Long, Employee> employees = new HashMap<>();

    // Save an employee
    public void save(Employee employee) {
        employees.put(employee.getId(), employee);
    }

    // Find an employee by ID
    public Employee findById(Long id) {
        return employees.get(id);
    }

    // Find all employees
    public List<Employee> findAll() {
        return new ArrayList<>(employees.values());
    }

    // Delete an employee by ID
    public void deleteById(Long id) {
        employees.remove(id);
    }

    // Check whether an employee exists
    public boolean existsById(Long id) {
        return employees.containsKey(id);
    }
}