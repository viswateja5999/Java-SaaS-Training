package com.saas.domain;

public class Employee {
    private long id;
    private String name;
    private double salary;
    private String contactNumber;

    public Employee(){

    }

    public Employee(long id,String name, double salary, String contactNumber){
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.contactNumber = contactNumber;
    }

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

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }
}
