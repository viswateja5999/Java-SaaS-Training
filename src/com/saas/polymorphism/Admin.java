package com.saas.polymorphism;

public class Admin extends User {
    public Admin(int id,String name, String email){
        super(id, name, email);
    }
    public String getRole(){
        return "ADMIN";
    }
    public void displayAdmin(){
        displayUserDetails();
    }
}
