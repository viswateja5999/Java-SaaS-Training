package com.saas.training.services;

import com.saas.training.exception.EmployeeNotFoundException;
import com.saas.training.exception.InvalidSalaryException;
import com.saas.training.model.Employee;
import com.saas.training.model.Organization;

import java.util.*;

public class EmployeeService {

    private Organization organization;

    public EmployeeService(Organization organization) {
        this.organization = organization;
    }

    public void addEmployee(Employee employee) {

        if (employee.getSalary() < 0) {
            throw new InvalidSalaryException(
                    "Salary cannot be negative.");
        }

        if (organization.getEmployees().size()
                >= organization.getSubscription().getMaxEmployee()) {

            System.out.println("Subscription employee limit reached.");
            return;
        }

        organization.addEmployee(employee);

        System.out.println("Employee added successfully.");
    }


    public void viewEmployees() {

        List<Employee> employees = organization.getEmployees();

        if (employees.isEmpty()) {
            System.out.println("No employees found.");
            return;
        }

        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    public Employee searchEmployee(int employeeId) {

        for (Employee employee : organization.getEmployees()) {

            if (employee.getEmployeeId() == employeeId) {
                return employee;
            }
        }

        throw new EmployeeNotFoundException(
                "Employee with ID " + employeeId + " not found.");
    }

    public void updateEmployee(int employeeId,
                               String name,
                               String email,
                               double salary) {

        Employee employee = searchEmployee(employeeId);

        if (salary < 0) {
            throw new InvalidSalaryException(
                    "Salary cannot be negative.");
        }

        employee.setName(name);
        employee.setEmail(email);
        employee.setSalary(salary);

        System.out.println("Employee updated successfully.");
    }

    public void deleteEmployee(int employeeId) {

        Employee employee = searchEmployee(employeeId);

        organization.getEmployees().remove(employee);

        System.out.println("Employee deleted successfully.");
    }

    public double calculateSalary(int employeeId) {

        Employee employee = searchEmployee(employeeId);

        return employee.getSalary();
    }

    public void changeEmployeeStatus(int employeeId,
                                     String status) {

        Employee employee = searchEmployee(employeeId);

        employee.setStatus(status);

        System.out.println("Employee status changed successfully.");
    }
}