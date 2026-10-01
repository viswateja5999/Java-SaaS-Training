package com.saas.inheritance;

public class Admin extends User {
    private String accessLevel;
    public Admin(long id, String name, String email, String role, String accessLevel){
        super(id, name, email,role);
        this.accessLevel=accessLevel;
    }
    public void dispalyAdminDetails(){
        displayUserDetails();
        System.out.println("Specialization : "+accessLevel);
    }
}

