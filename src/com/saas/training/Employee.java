package com.saas.training;

public class Employee {
    long id;
    String name;
    String email;
    double salary;

    //Default Constructor
    Employee(){
        System.out.println("Default Constructor Called.");
    }
    //Parameter Constructor
    Employee(long id,String name){
        this.id = id;
        this.name = name;
    }
    //Constructor Overloading
    Employee(long id,String name,String email,double salary){
        this.id = id;
        this.name = name;
        this.email = email;
        this.salary = salary;
    }

    public static void main(String[] args) {
        Employee employee1 = new Employee();
        Employee emp2 = new Employee(101, "Teja");
        Employee emp3 = new Employee(102, "Viswa Teja", "viswateja761@gmail.com", 59999.99);
        System.out.println("Parameter Constructor");
        System.out.println("Employee ID : "+ emp2.id);
        System.out.println("Employee Name : "+emp2.name);
        System.out.println("Constructor Overloading");
        System.out.println("Employee ID : "+ emp3.id);
        System.out.println("Employee Name : "+ emp3.name);
        System.out.println("Employee Email : "+ emp3.email);
        System.out.println("Employee Salary : "+ emp3.salary);
    }
}
