package com.saas.training.model;

public class Employee {
    private  int employeeId;
    private String name;

    private String email;
    private double salary;
    private String status;
    private User user;
    private Department department;
    private Organization organization;

    public Employee(int employeeId, String name, String email, double salary,
                    String status, User user, Department department, Organization organization) {
        this.employeeId = employeeId;
        this.name = name;
        this.email = email;
        this.salary = salary;
        this.status = status;
        this.user = user;
        this.department = department;
        this.organization = organization;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDeparment(Department department) {
        this.department = department;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", salary=" + salary +
                ", status='" + status + '\'' +
                ", user=" + user +
                ", department=" + department.getDepartmentName() +
                ", organization=" + organization.getOrganizationName() +
                '}';
    }
}
