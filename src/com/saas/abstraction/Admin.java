package com.saas.abstraction;

public class Admin extends User{
    public Admin(int id, String name, String email){
        super(id,name,email);
    }

    @Override
    public void showPermissions() {
        System.out.println("Admin -> Manages Organization");
    }

    public static void main(String[] args) {
        User employee = new Employee(101, "Teja", "teja@gmail");
        User hr = new HR(102, "Viswa", "viswa66@gmail");
        User admin = new Admin(103, "Sree", "sree333@gmail");

        employee.showPermissions();
        hr.showPermissions();
        admin.showPermissions();
    }
}
