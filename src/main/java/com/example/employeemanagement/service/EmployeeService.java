package com.example.employeemanagement.service;

import com.example.employeemanagement.dto.EmployeeRequest;
import com.example.employeemanagement.entity.Employee;
import com.example.employeemanagement.exception.DuplicateEmployeeException;
import com.example.employeemanagement.exception.ResourceNotFoundException;
import com.example.employeemanagement.repository.EmployeeRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public Employee create(EmployeeRequest request) {

        if (repository.existsByEmail(request.getEmail())) {
            throw new DuplicateEmployeeException(
                    "Email already exists: " + request.getEmail());
        }

        Employee employee = new Employee(
                request.getName(),
                request.getEmail(),
                request.getSalary()
        );

        return repository.save(employee);
    }

    @Transactional(readOnly = true)
    public List<Employee> getAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Employee getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Employee not found with ID: " + id));
    }

    public Employee update(Long id, EmployeeRequest request) {

        Employee employee = getById(id);

        if (!employee.getEmail().equalsIgnoreCase(request.getEmail())
                && repository.existsByEmail(request.getEmail())) {
            throw new DuplicateEmployeeException(
                    "Email already exists: " + request.getEmail());
        }

        employee.setName(request.getName());
        employee.setEmail(request.getEmail());
        employee.setSalary(request.getSalary());

        return repository.save(employee);
    }

    public void delete(Long id) {
        Employee employee = getById(id);
        repository.delete(employee);
    }
}