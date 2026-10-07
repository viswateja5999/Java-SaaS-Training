package com.saas.training;

import com.saas.training.model.Department;
import com.saas.training.model.Employee;
import com.saas.training.model.Organization;
import com.saas.training.model.Subscription;
import com.saas.training.model.User;

import com.saas.training.notificationservice.EmailNotificationService;
import com.saas.training.notificationservice.NotificationService;

import com.saas.training.services.EmployeeService;
import com.saas.training.services.OrganizationService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        OrganizationService organizationService =
                new OrganizationService();

        EmployeeService employeeService = null;

        NotificationService notificationService =
                new EmailNotificationService();

        boolean running = true;

        while (running) {

            System.out.println();
            System.out.println("======================================");
            System.out.println("      EMPLOYEE SaaS MANAGEMENT SYSTEM");
            System.out.println("======================================");

            System.out.println("1. Create Organization");
            System.out.println("2. Add Employee");
            System.out.println("3. View Employees");
            System.out.println("4. Search Employee");
            System.out.println("5. Update Employee");
            System.out.println("6. Delete Employee");
            System.out.println("7. Calculate Salary");
            System.out.println("8. Change Employee Status");
            System.out.println("9. View Subscription");
            System.out.println("10. Exit");

            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            try {

                switch (choice) {

                    case 1:

                        System.out.print("Enter Organization ID: ");
                        int organizationId = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Enter Organization Name: ");
                        String organizationName =
                                scanner.nextLine();


                        System.out.println("Choose Subscription:");
                        System.out.println("1. Basic");
                        System.out.println("2. Premium");

                        int planChoice = scanner.nextInt();
                        scanner.nextLine();

                        Subscription subscription;

                        if (planChoice == 1) {

                            subscription = new Subscription(
                                    1,
                                    "Basic",
                                    999,
                                    5
                            );

                        } else {

                            subscription = new Subscription(
                                    2,
                                    "Premium",
                                    1999,
                                    20
                            );
                        }

                        organizationService.createOrganization(
                                organizationId,
                                organizationName,
                                subscription
                        );

                        Organization organization =
                                organizationService.getOrganization();

                        employeeService =
                                new EmployeeService(organization);

                        notificationService.sendNotification(
                                "Organization created successfully."
                        );

                        break;

                    case 2:

                        if (employeeService == null) {
                            System.out.println(
                                    "Please create organization first."
                            );
                            break;
                        }

                        System.out.print("Enter Employee ID: ");
                        int employeeId = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Enter Employee Name: ");
                        String employeeName = scanner.nextLine();

                        System.out.print("Enter Employee Email: ");
                        String employeeEmail = scanner.nextLine();

                        System.out.print("Enter Salary: ");
                        double salary = scanner.nextDouble();
                        scanner.nextLine();

                        System.out.print("Enter User ID: ");
                        int userId = scanner.nextInt();
                        scanner.nextLine();

                        User user = new User(
                                userId,
                                employeeName,
                                employeeEmail
                        );

                        System.out.print("Enter Department ID: ");

                        int departmentId = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Enter Department Name: ");
                        String departmentName =
                                scanner.nextLine();

                        Department department =
                                new Department(
                                        departmentId,
                                        departmentName
                                );

                        Organization currentOrganization =
                                organizationService.getOrganization();

                        Employee employee =
                                new Employee(
                                        employeeId,
                                        employeeName,
                                        employeeEmail,
                                        salary,
                                        "ACTIVE",
                                        user,
                                        department,
                                        currentOrganization
                                );

                        currentOrganization.addUser(user);
                        currentOrganization.addDepartment(department);

                        employeeService.addEmployee(employee);

                        notificationService.sendNotification(
                                "Employee " + employeeName +
                                        " added successfully."
                        );

                        break;

                    case 3:

                        if (employeeService == null) {
                            System.out.println(
                                    "Please create organization first."
                            );
                            break;
                        }

                        employeeService.viewEmployees();

                        break;

                    case 4:

                        if (employeeService == null) {
                            System.out.println(
                                    "Please create organization first."
                            );
                            break;
                        }

                        System.out.print("Enter Employee ID: ");
                        int searchId = scanner.nextInt();
                        scanner.nextLine();

                        Employee foundEmployee =
                                employeeService.searchEmployee(searchId);

                        System.out.println(foundEmployee);

                        break;

                    case 5:

                        if (employeeService == null) {
                            System.out.println(
                                    "Please create organization first."
                            );
                            break;
                        }

                        System.out.print("Enter Employee ID: ");
                        int updateId = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Enter New Name: ");
                        String newName = scanner.nextLine();

                        System.out.print("Enter New Email: ");
                        String newEmail = scanner.nextLine();

                        System.out.print("Enter New Salary: ");
                        double newSalary = scanner.nextDouble();
                        scanner.nextLine();

                        employeeService.updateEmployee(
                                updateId,
                                newName,
                                newEmail,
                                newSalary
                        );

                        notificationService.sendNotification(
                                "Employee updated successfully."
                        );

                        break;

                    case 6:

                        if (employeeService == null) {
                            System.out.println(
                                    "Please create organization first."
                            );
                            break;
                        }

                        System.out.print("Enter Employee ID: ");
                        int deleteId = scanner.nextInt();
                        scanner.nextLine();

                        employeeService.deleteEmployee(deleteId);

                        notificationService.sendNotification(
                                "Employee deleted successfully."
                        );

                        break;

                    case 7:

                        if (employeeService == null) {
                            System.out.println(
                                    "Please create organization first."
                            );
                            break;
                        }

                        System.out.print("Enter Employee ID: ");
                        int salaryId = scanner.nextInt();
                        scanner.nextLine();

                        double calculatedSalary =
                                employeeService.calculateSalary(
                                        salaryId
                                );

                        System.out.println(
                                "Employee Salary: "
                                        + calculatedSalary
                        );

                        break;

                    case 8:

                        if (employeeService == null) {
                            System.out.println(
                                    "Please create organization first."
                            );
                            break;
                        }

                        System.out.print("Enter Employee ID: ");
                        int statusId = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print(
                                "Enter New Status (ACTIVE/INACTIVE): "
                        );

                        String status = scanner.nextLine();

                        employeeService.changeEmployeeStatus(
                                statusId,
                                status
                        );

                        notificationService.sendNotification(
                                "Employee status changed."
                        );

                        break;

                    case 9:

                        organizationService.viewSubscription();

                        break;

                    case 10:

                        running = false;

                        System.out.println(
                                "Thank you for using Employee SaaS Management System."
                        );

                        break;

                    default:

                        System.out.println(
                                "Invalid choice. Please try again."
                        );
                }

            } catch (Exception e) {

                System.out.println(
                        "Error: " + e.getMessage()
                );
            }
        }

        scanner.close();
    }
}