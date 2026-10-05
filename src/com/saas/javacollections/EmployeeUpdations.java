package com.saas.javacollections;

import java.util.*;

public class EmployeeUpdations {
    public static void main(String[] args) {
         List<Employee> employees = new ArrayList<>();
         Map<Long, Employee> employeeMap = new HashMap<>();

         Employee employee1 = new Employee(401, "Vinay", "IT");
         Employee employee2 = new Employee(402, "Teja", "Testing");
         Employee employee3 = new Employee(403, "Krishna", "Manual Testing");

         employees.add(employee1);
         employees.add(employee2);
         employees.add(employee3);

         employeeMap.put(employee1.getId(), employee1);
         employeeMap.put(employee2.getId(), employee2);
         employeeMap.put(employee3.getId(), employee3);

        //Read
        System.out.println("All Employees :");
        for(Employee employee:employees){
            System.out.println(employee);
        }
        //Search
        System.out.println("\nSearch Employee ID 402:");
        for(Employee employee : employees){
            if(employee.getId() == 402){
                System.out.println(employee);
            }
        }
        //Update
        for(Employee employee : employees){
            if (employee.getId()==403){
                employee.setDepartment("Manual Testing");
                System.out.println("\nEmployee updated Successfully.");
            }
        }

        //Display after updation
        System.out.println("After Update:");
        for(Employee employee:employees){
            System.out.println(employee);
        }

        //Delete
        long deleteId = 401;

        Employee employeeToDelete = employeeMap.remove(deleteId);
        if(employeeToDelete != null){
            employees.remove(employeeToDelete);
            System.out.println("\nEmployee deleted successfully.");
        }
        //Display after delete
        System.out.println("\nAfter Delete:");
        for(Employee employee:employees){
            System.out.println(employee);
        }
    }
}
