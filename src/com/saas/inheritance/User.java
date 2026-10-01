package com.saas.inheritance;

public class User {
    private long id;
    private String name;
    private String email;
    private String role;

    public User(long id, String name, String email, String role){
        this.id = id;
        this.name = name;
        this.email = email;
        this.role = role;
    }

    public void displayUserDetails(){
        System.out.println("ID : "+id);
        System.out.println("Name : "+name);
        System.out.println("Email : "+email);
        System.out.println("Role : "+role);
    }
}
