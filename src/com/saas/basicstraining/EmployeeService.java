package com.saas.basicstraining;

public class EmployeeService {
    private long id;
    private String name;
    private double salary;
    private String status;
    private String subscriptionPlan;

    public EmployeeService(long id, String name, double salary, String status, String subscriptionPlan){
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.status = status;
        this.subscriptionPlan = subscriptionPlan;
    }

    public double calculateSalary(){
        return  salary;
    }
    public double calculateTax(){
        double taxRate = 0.10;
        return salary * taxRate;
    }
    public double calculateNetSalary(){
        double tax = calculateTax();
        return salary - tax;
    }
    public boolean checkEmployeeStatus(){
        return status.equalsIgnoreCase("Active");
    }
    public double calculateSubscription(){
        if(subscriptionPlan.equalsIgnoreCase("Basic")){
            return 10.0;
        } else if (subscriptionPlan.equalsIgnoreCase("Premium")) {
            return 25.0;
        } else if (subscriptionPlan.equalsIgnoreCase("Enteerprise")) {
            return 50.0;
        }
        return 0.0;
    }

    public static void main(String[] args) {
        EmployeeService es = new EmployeeService(101,"Viswa Teja", 50000.0, "Active", "Premium");
        System.out.println("Employee ID : "+ es.id);
        System.out.println("Employee Name : "+ es.name);
        System.out.println("Salary : "+es.calculateSalary());
        System.out.println("Tax : "+es.calculateTax());
        System.out.println("Net Salary : "+es.calculateNetSalary());
        System.out.println("Employee Activate : "+es.checkEmployeeStatus());
        System.out.println("Subscription Cost : "+es.calculateSubscription());
    }
}
