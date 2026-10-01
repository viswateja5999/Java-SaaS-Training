package com.saas.polymorphism;

public class HR extends User{
    public HR(int id, String name, String email){
        super(id, name, email);
    }
    public String getRole(){
        return "HR";
    }
    public void displayHR(){
        displayUserDetails();
    }
}
