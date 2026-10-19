package com.saas.mini.project.model;


public class Employee {

    private final Long id;
    private String name;
    private String email;
    private double salary;
    private boolean active;
    private String subscriptionPlan;

    public Employee(Long id, String name, String email,
                    double salary, boolean active,
                    String subscriptionPlan) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.salary = salary;
        this.active = active;
        this.subscriptionPlan = subscriptionPlan;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public double getSalary() {
        return salary;
    }

    public boolean isActive() {
        return active;
    }

    public String getSubscriptionPlan() {
        return subscriptionPlan;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setSubscriptionPlan(String subscriptionPlan) {
        this.subscriptionPlan = subscriptionPlan;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", salary=" + salary +
                ", active=" + active +
                ", subscriptionPlan='" + subscriptionPlan + '\'' +
                '}';
    }
}