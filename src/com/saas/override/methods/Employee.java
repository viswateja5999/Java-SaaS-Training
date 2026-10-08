package com.saas.override.methods;

import java.util.Objects;

public class Employee {
    private long id;
    private String name;
    private String department;
    private double salary;

    public Employee(long id, String name, String department, double salary){
        this.id = id;
        this.name=name;
        this.department=department;
        this.salary=salary;
    }

    public long getId(){
        return id;
    }

    //equals() method
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj == null || getClass() != obj.getClass()){
            return false;
        }
        Employee employee = (Employee) obj;
        return Objects.equals(id, employee.id);
    }

    //hashCode() method

    public int hashCode(){
        return Objects.hash(id);
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
