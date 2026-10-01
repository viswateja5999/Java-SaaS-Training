package com.saas.domain;

import java.util.ArrayList;
import java.util.List;

public class Organization {
    private long id;
    private String name;
    private List<Employee> employees = new ArrayList<>();
    private List<Department> departments = new ArrayList<>();
    private Subscription subscription;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }


    public Organization(){

    }

    public Organization(long id, String name){
        this.id = id;
        this.name = name;
    }


}
