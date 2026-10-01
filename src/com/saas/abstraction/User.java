package com.saas.abstraction;

//This creates an Abstract class named User. Abstract means we cannot directly create an object of this class.
public abstract class User {
    protected int id;
    protected String name;
    protected String email;

    public User (int id, String name, String email){
        this.id = id;
        this.name = name;
        this.email = email;
    }

    //Abstract method - no method body, no{}, only the method declaration.
    public abstract void showPermissions();
}
