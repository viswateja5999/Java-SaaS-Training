package com.saas.employee.service;

import com.saas.employee.exception.EmployeeNotFoundException;
import com.saas.employee.exception.InvalidEmployeeException;
import com.saas.employee.model.Employee;
import com.saas.employee.repositry.EmployeeRepository;

import java.util.List;

public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public void addEmployee(Employee employee) {
        if (employee.getId() <= 0) {
            throw new InvalidEmployeeException(
                    "Employee ID must be positive.");
        }

        if (employee.getName() == null
                || employee.getName().isBlank()) {
            throw new InvalidEmployeeException(
                    "Employee name cannot be empty.");
        }

        if (employee.getDepartment() == null
                || employee.getDepartment().isBlank()) {
            throw new InvalidEmployeeException(
                    "Department cannot be empty.");
        }

        if (!Double.isFinite(employee.getSalary())
                || employee.getSalary() < 0) {
            throw new InvalidEmployeeException(
                    "Salary must be a valid non-negative number.");
        }

        if (repository.findById(employee.getId()).isPresent()) {
            throw new InvalidEmployeeException(
                    "Employee ID already exists.");
        }

        repository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public Employee getEmployeeById(int id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new EmployeeNotFoundException(
                                "Employee not found with ID: " + id));
    }

    public void deactivateEmployee(int id) {
        Employee employee = getEmployeeById(id);
        employee.setActive(false);
    }
}