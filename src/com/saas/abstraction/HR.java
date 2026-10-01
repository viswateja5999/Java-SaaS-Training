package com.saas.abstraction;

public class HR extends User{
    public HR(int id, String name, String email){
        super(id, name, email);
    }

    @Override
    public void showPermissions() {
        System.out.println("HR -> Manage Employes");
    }
}
