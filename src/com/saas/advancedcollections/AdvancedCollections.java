package com.saas.advancedcollections;

import java.util.*;

public class AdvancedCollections {
    static class Employee {
        private long id;
        private String name;
        private String department;
        private double salary;

        public Employee(long id, String name, String department, double salary) {
            this.id = id;
            this.name = name;
            this.department = department;
            this.salary = salary;
        }

        public long getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getDepartment() {
            return department;
        }

        public double getSalary() {
            return salary;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public void  setSalary(double salary) {
            this.salary = salary;
        }

        public String toString() {
            return "Employee Id: " + id + ", Name: " + name + ", Department: " + department + ", Salary: " + salary;
        }
    }
}

