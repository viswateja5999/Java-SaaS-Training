package com.saas.javacollections;

public class Employee {
    private  long id;
    private String name;
    private String department;

    public Employee(long id, String name, String department){
        this.id = id;
        this.name = name;
        this.department = department;
    }

    public long getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getDepartment(){
        return department;
    }
    public void setDepartment(String department){
        this.department = department;
    }
    public String toString(){
        return "Employee{id=" + id +", name="+ name + '\'' +", department='"+department +'\'' +'}';
    }
}
