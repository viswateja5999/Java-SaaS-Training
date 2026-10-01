package com.saas.abstraction;

public class Employee extends User{
    public  Employee(int id, String name, String email){
        super(id, name, email);
    }

    @Override
    public void showPermissions() {
        System.out.println("Employee -> View own Profile");
    }
}
