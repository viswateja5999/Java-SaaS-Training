package com.saas.polymorphism;

public class User {
    private int id;
    private String name;
    private String email;

    public User(int id,String name, String email){
        this.id = id;
        this.name = name;
        this.email = email;
    }
    public String  getRole(){
        return "User";
    }
    public void displayUserDetails(){
        System.out.println(id);
        System.out.println(name);
        System.out.println(email);
    }
}
