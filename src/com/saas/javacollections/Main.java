package com.saas.javacollections;

import java.util.*;

public class Main
{
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        Map<Long, Employee> employeeMap = new HashMap<>();
        Set<String> departments = new HashSet<>();

        Employee emp1 = new Employee(101, "Teja", "LE-1");
        Employee emp2 = new Employee(102, "Viswa", "HR");
        Employee emp3 = new Employee(103, "Sree", "Admin");

        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);

        employeeMap.put(emp1.getId(), emp1);
        employeeMap.put(emp2.getId(), emp2);
        employeeMap.put(emp3.getId(), emp3);

        departments.add(emp1.getDepartment());
        departments.add(emp2.getDepartment());
        departments.add(emp3.getDepartment());

        System.out.println("Employees :");
        for (Employee employee : employees) {
            System.out.println(employee);
        }

        System.out.println("\nEmployee Map");
        for (Map.Entry<Long, Employee> entry : employeeMap.entrySet()) {
            System.out.println("ID : " + entry.getKey() + "->" + entry.getValue());
        }

        System.out.println("\nDepartments :");
        for (String department : departments) {
            System.out.println(departments);
        }
    }

}
