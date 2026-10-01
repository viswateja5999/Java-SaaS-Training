package com.saas.polymorphism;

public class Main {
    public static void main(String[] args) {
        User user = new User(100, "Sree", "sree@gmail.com");
        Employee employee = new Employee(101, "Teja", "viswateja@gmail.com");
        HR hr = new HR(102, "Vinay", "vinay3333@gmail.com");
        Admin admin = new Admin(103, "Krishna", "krishnak@gmail.com");

        /* user.displayUserDetails();
        employee.displayUserDetails();
        hr.displayUserDetails();
        admin.displayUserDetails(); */

        System.out.println("Employee -> "+employee.getRole());
        System.out.println("HR -> "+hr.getRole());
        System.out.println("Admin -> "+admin.getRole());
    }
}
