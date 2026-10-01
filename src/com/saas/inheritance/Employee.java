package com.saas.inheritance;

public class Employee extends User{
    private String department;

    public Employee(long id, String name, String email, String role, String department){
        super(id, name, email, role);
        this.department = department;
    }


    public void displayEmployeeDetails() {
        displayUserDetails();
        System.out.println("Department : "+department);
    }
}
