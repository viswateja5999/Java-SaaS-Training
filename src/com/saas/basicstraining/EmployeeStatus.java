package com.saas.basicstraining;

public class EmployeeStatus {
    public static void main(String[] args) {
        String status = "ACTIVE";

        //if
        if (status.equals("ACTIVE")) {
            System.out.println("Employee is Active");
        }
        //if-else
        if(status.equals("INACTIVE")){
            System.out.println("Employee is Inactive");
        }
        else{
            System.out.println("Employee is Active");
        }
        //else-if
        if(status.equals("ON_LEAVE")){
            System.out.println("Employee is ON_LEAVE");
        }
        else if(status.equals("ACTIVE")){
            System.out.println("Employee is Active");
        }else
        {
            System.out.println("Employee is Inactive");
        }

        String statuss = "ON_LEAVE";

                switch (statuss) {
                    case "ACTIVE" -> System.out.println("Employee is Active.");
                    case "INACTIVE" -> System.out.println("Employee is Inactive.");
                    case "ON_LEAVE" -> System.out.println("Employee is On_Leave.");
                    case "TERMINATED" -> System.out.println("Access revoked: Employee are Terminated.");
                    default -> System.out.println("Unknown status: Contact system administrator.");
                }
    }
}