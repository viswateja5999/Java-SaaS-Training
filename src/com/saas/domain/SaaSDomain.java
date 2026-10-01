package com.saas.domain;

import java.util.Arrays;

public class SaaSDomain {
    public static void main(String[] args) {
        User user = new User(1, "Ravi", "ravi761@gmail.com");

        Employee employees1 = new Employee(101, "Teja", 5000.0, "6302691941");
        Employee employees2 = new Employee(102, "Viswa", 9000.0, "9515180592");

        Department departments = new Department(1, "IT");
        departments.setEmployees(Arrays.asList(employees1, employees2));
        Subscription subscription = new Subscription(1, "Premium", 999.0, "Active");

        Organization organization = new Organization(1, "Blackroth");
        organization.setEmployees(Arrays.asList(employees1, employees2));
        organization.setDepartments(Arrays.asList(departments));
        organization.setSubscription(subscription);

        System.out.println("User Details");
        System.out.println("Used ID : " + user.getId());
        System.out.println("User Name : " + user.getName());
        System.out.println("User Email : " + user.getEmail());

        System.out.println("\n -- Organization Details--");
        System.out.println("Organization : " + organization.getName());
        System.out.println("Number of Employees : " + organization.getEmployees().size());
        System.out.println("Number of Departments : " + organization.getDepartments().size());
        System.out.println("Subscription Plan : " + organization.getSubscription().getPlanName());
        System.out.println("Subscription Status : " + organization.getSubscription().getStatus());
    }
}
