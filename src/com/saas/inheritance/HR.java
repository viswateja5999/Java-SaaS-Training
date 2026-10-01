package com.saas.inheritance;

public class HR extends User {

    private String specialization;
    public HR(long id, String name, String email, String role, String specialization){
        super(id, name, email,role);
        this.specialization=specialization;
    }
    public void dispalyHRDetails(){
        displayUserDetails();
        System.out.println("Specialization : "+specialization);
    }
}
