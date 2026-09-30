package com.saas.training;

public class Employees {
    static int id;
    static String name;
    static String email;
    static String phone;
    static double salary;
    static String department;
    static String status;
     public static void main(String[] args){
        Employees employees = new Employees();
            employees.id = 104;
            employees.name = "Y Sree Viswa Teja";
            employees.email = "viswateja761@gmail.com";
            employees.phone = "6302691941";
            employees.salary = 59999.99;
            employees.department = "IT";
            employees.status = "Active";

        System.out.println("ID : "+id);
        System.out.println("NAME : "+name);
        System.out.println("EMAIL : "+email);
        System.out.println("PHONE : "+phone);
        System.out.println("SALARY : "+salary);
        System.out.println("DEPARTMENT : "+department);
         System.out.println("STATUS : "+ employees.status);
    }
}
