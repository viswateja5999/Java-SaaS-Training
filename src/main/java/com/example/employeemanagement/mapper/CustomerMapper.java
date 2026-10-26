package com.example.employeemanagement.mapper;


import com.example.employeemanagement.dto.CustomerRequest;
import com.example.employeemanagement.dto.CustomerResponse;
import com.example.employeemanagement.entity.Customer;

public class CustomerMapper {

    public Customer toEntity(CustomerRequest request) {
        return new Customer(
                request.name(),
                request.email(),
                request.salary()
        );
    }

    public CustomerResponse toResponse(Customer customer) {
        return new CustomerResponse(
                customer.getId(),
                customer.getName(),
                customer.getEmail(),
                customer.getSalary()
        );
    }

    public void updateEntity(
            Customer customer,
            CustomerRequest request
    ) {
        customer.setName(request.name());
        customer.setEmail(request.email());
        customer.setSalary(request.salary());
    }
}
