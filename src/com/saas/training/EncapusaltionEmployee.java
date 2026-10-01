package com.saas.training;

public class EncapusaltionEmployee {
    private long id;
    private String name;
    private String email;
    private double salary;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if(salary < 0)
        {
            throw new IllegalArgumentException("Salary cannot be negative");
        }
        this.salary = salary;
    }

    public static void main(String[] args) {
        EncapusaltionEmployee emp = new EncapusaltionEmployee();
        emp.setId(9995);
        emp.setName("Sree Viswa Teja");
        emp.setEmail("viswateja@blackroth.in");
        emp.setSalary(50000.00);

        System.out.println("ID : "+ emp.getName());
        System.out.println("Name : "+emp.getName());
        System.out.println("Email : "+ emp.getEmail());
        System.out.println("Salary : "+emp.getSalary());
    }
}
