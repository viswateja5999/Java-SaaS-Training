package com.saas.polymorphism;

public class Employee extends User {
    public Employee(int id, String name, String email){
        super(id, name, email);
    }

    public String getRole(){
        return "EMPLOYEE";
    }
    public void displayEmployee(){
        displayUserDetails();
    }
}
