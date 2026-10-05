package com.saas.exceptionhandling;

class EmployeeNotFoundException extends Exception{
    public EmployeeNotFoundException(String message){
        super(message);
    }
}
class InvalidSalaryException extends Exception{
    public InvalidSalaryException(String message){
        super(message);
    }
}
class InvalidOrganizationException extends Exception{
    public InvalidOrganizationException(String message){
        super(message);
    }
}
public class EmployeeManagement{
    static void validateEmployee(int employeeId)
            throws EmployeeNotFoundException{
        if (employeeId <= 0){
            throw new EmployeeNotFoundException("Employee not found");
        }
        System.out.println("Employee found successfully");
    }
    static void validateSalary(double salary)
        throws InvalidSalaryException{
        if(salary <= 0 ){
            throw new InvalidSalaryException("Salary must be greater than 0");
        }
        System.out.println("Salary is valid");
    }
    static void validateOrganization(String organization)
        throws InvalidOrganizationException{
        if (organization == null || organization.isEmpty()){
            throw new InvalidOrganizationException("Organization name is invalid");
        }
        System.out.println("Organization is valid");
    }

    public static void main(String[] args) {
        try{
            int employeeId = 101;
            double salary = 50000.00;
            String organization = "Blackroth";
            
            validateEmployee(employeeId);
            validateSalary(salary);
            validateOrganization(organization);

            System.out.println("Employee validation completed");
        }
        catch (EmployeeNotFoundException e){
            System.out.println(e.getMessage());
        }
        catch (InvalidSalaryException e){
            System.out.println(e.getMessage());
        }
        catch (InvalidOrganizationException e){
            System.out.println(e.getMessage());
        }
        finally{
            System.out.println("Validation process completed");
        }
    }
}
