package com.saas.inheritance;

public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee(104, "Teja", "viswateja761@gmail.com", "Employee", "Testing");
        HR hr = new HR(105, "Vinay", "vinay777@gmail", "HR","Recruitment");
        Admin admin = new Admin(103, "Sai", "sai444@gmail.com", "Admin", "Full");

        System.out.println("--Employee--");
        employee.displayEmployeeDetails();
        System.out.println("\n--HR--");
        hr.dispalyHRDetails();
        System.out.println("\n--Admin--");
        admin.dispalyAdminDetails();
    }
}
