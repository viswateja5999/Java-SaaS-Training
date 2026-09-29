package com.saas.training;
public class SubscriptionPlan {
    public static void main(String[] args) {
        String plan = "Pro";

        switch (plan.toUpperCase()) {
            case "FREE":
                System.out.println("Limited Features");
                break;
            case "BASIC":
                System.out.println("Employee Management");
                break;
            case "PRO":
                System.out.println("Employee + Payroll");
                break;
            case "ENTERPRISE":
                System.out.println("All Features");
                break;
            default:
                System.out.println("Invalid Plan Selected");
                break;
        }
    }
}