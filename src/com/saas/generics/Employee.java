package com.saas.generics;

public class Employee {
    private long id;
    private String name;
    private String department;
    private double salary;

    public Employee(long id, String name, String department, double salary){
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary=salary;
    }

    public long getId() {
        return id;
    }


    public String getName() {
        return name;
    }


    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
    }
}
