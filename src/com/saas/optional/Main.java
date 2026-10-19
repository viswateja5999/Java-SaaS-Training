package com.saas.optional;

import java.util.List;
import java.util.Optional;

class Employee{

    private long id;
    private String name;
    private double salary;


    public Employee(long id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }


    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }
}

class EmployeeService{

    private List<Employee> employees;

    public EmployeeService(List<Employee> employees){
        this.employees=employees;
    }

    public Optional<Employee> findEmployeeById(long id){
        return employees.stream().filter(employee -> employee.getId()==id).findFirst();
    }
}
public class Main {

    public static void main(String[] args) {

        //Create employee list
        List<Employee> employees = List.of(new Employee(101, "Teja", 88889.09),
                new Employee(102, "Viswa", 9999.99),
                new Employee(103, "Sree", 5555.55));
        EmployeeService service = new EmployeeService(employees);

        //Search Employee
        Optional<Employee> employee = service.findEmployeeById(106);

        //Handle result
        employee.ifPresentOrElse(emp -> System.out.println("Employee Found: "+emp.getName()),
                () -> System.out.println("Employee Not Found"));
    }
}
