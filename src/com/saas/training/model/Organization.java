package com.saas.training.model;

import java.util.*;

public class Organization {
    private int organizationId;
    private String organizationName;
    private Subscription subscription;

    private List<User> users;
    private List<Employee> employees;
    private List<Department> departments;

    public Organization(int organizationId, String organizationName, Subscription subscription){
        this.organizationId = organizationId;
        this.organizationName = organizationName;
        this.subscription = subscription;

        this.users=new ArrayList<>();
        this.employees=new ArrayList<>();
        this.departments=new ArrayList<>();
    }

    public int getOrganizationId() {
        return organizationId;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public List<User> getUsers() {
        return users;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public List<Department> getDeparments() {
        return departments;
    }
    public void addUser(User user){
        users.add(user);
    }
    public  void addEmployee(Employee employee){
        employees.add(employee);
    }
    public void addDepartment(Department department){
        departments.add(department);
    }

    @Override
    public String toString() {
        return "Organization{" +
                "organizationId=" + organizationId +
                ", organizationName='" + organizationName + '\'' +
                ", subscription=" + subscription.getPlanName() +
                '}';
    }
}
