package com.saas.advancedcollections;

import java.util.*;

public class Main extends AdvancedCollections{
    public static void main(String[] args) {
        //List<Employee>
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(101, "Sree", "IT", 69999.98));
        employees.add(new Employee(102, "Viswa", "HR", 5000.00));
        employees.add(new Employee(103, "Teja", "Admin", 6888.99));
        employees.add(new Employee(104, "Krishna", "Testing", 77777.8));
        System.out.println("---Employee List---");
        for(Employee employee:employees){
            System.out.println(employee);
        }

        //Set<String>
        Set<String> departments = new HashSet<>();
        for(Employee employee:employees){
            departments.add(employee.getDepartment());
        }
        System.out.println("\n---Departments---");
        System.out.println(departments);

        //Map<Long, Employee>
        Map<Long, Employee> employeeMap = new HashMap<>();
        for(Employee employee:employees){
            employeeMap.put(employee.getId(), employee);
        }
        System.out.println("\n---Employee Map---");
        employeeMap.forEach((id, employee) -> System.out.println(id+" -> "+employee));

        Map<String, List<Employee>> departmentEmployees = new HashMap<>();
        for(Employee employee:employees){
            departmentEmployees.computeIfAbsent(employee.getDepartment(), key -> new ArrayList<>()).add(employee);
        }
        departmentEmployees.forEach((department, employeeList)->{
            System.out.println(department);
            employeeList.forEach(System.out::println);
        });

        //Add Employee
        Employee newEmployee = new Employee(105, "Vinay", "Admin", 67573.0);
        if(!employeeMap.containsKey(newEmployee.getId())){
            employees.add(newEmployee);
            employeeMap.put(newEmployee.getId(), newEmployee);

            departmentEmployees.computeIfAbsent(newEmployee.getDepartment(), key -> new ArrayList<>()).add(newEmployee);
            System.out.println("\nEmployee added successfully.");
        }else{
            System.out.println("\nEmployee already exists.");
        }
        //Update Employee
        Employee employeeToUpdate = employeeMap.get(102);

        if(employeeToUpdate != null){
            employeeToUpdate.setName("Jay Ram");
            employeeToUpdate.setSalary(99999);
            System.out.println("\nEmployee Updated Successfully");
        }

        //Search Employee
        long searchId = 103;
        Employee searchedEmployee = employeeMap.get(searchId);
        System.out.println("\n---Search Result---");
        if(searchedEmployee != null){
            System.out.println(searchedEmployee);
        }else{
            System.out.println("Employee not found.");
        }

        //Remove Employee
        long removeId = 104;
        Employee employeeToRemove = employeeMap.remove(removeId);

        if(employeeToRemove != null){
            employees.remove(employeeToRemove);

            List<Employee> departmentList = departmentEmployees.get(employeeToRemove.getDepartment());
            if(departmentList != null){
                departmentList.remove(employeeToRemove);
            }
            System.out.println("\nEmployee removed successfully.");
        }

        //Sort employee by salary

        employees.sort(Comparator.comparingDouble(Employee::getSalary));
        System.out.println("\n---Employees Sorted by Salary---");
        employees.forEach(System.out::println);

        //Sort employees by name

        employees.sort(Comparator.comparing(Employee::getName));
        System.out.println("\n---Employees Sorted By Name---");
        employees.forEach(System.out::println);
    }
}
