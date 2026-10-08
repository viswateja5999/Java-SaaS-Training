package com.saas.override.methods;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        //Create first employee
        Employee employee1 = new Employee(101, "Teja", "HR", 888.99);

        //Create second employee with the same ID
        Employee employee2 = new Employee(101, "Teja", "Admin", 77888.99);

        //Compare two employees
        System.out.println("Are employes equal? "+employee1.equals(employee2));

        //Compare hash codes
        System.out.println("Employee 1 hashCode: "+employee1.hashCode());
        System.out.println("Employee 2 hashCode: "+employee2.hashCode());

        //Create HashSet
        Set<Employee> employees = new HashSet<>();

        //Add employees
        employees.add(employee1);
        employees.add(employee2);

        //Display HashSet
        System.out.println("Employees in HashSet: ");
        System.out.println(employees);

        //Display employee object
        System.out.println("Employee object: ");
        System.out.println(employee1);
    }
}
