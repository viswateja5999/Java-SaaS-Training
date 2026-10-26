
package com.example.employeemanagement.service;


import com.example.employeemanagement.dto.CustomerRequest;
import com.example.employeemanagement.dto.CustomerResponse;
import com.example.employeemanagement.entity.Customer;
import com.example.employeemanagement.exception.DuplicateCustomerException;
import com.example.employeemanagement.exception.ResourceNotFoundException;
import com.example.employeemanagement.mapper.CustomerMapper;
import com.example.employeemanagement.repository.CustomerRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerService(
            CustomerRepository customerRepository,
            CustomerMapper customerMapper
    ) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Transactional
    public CustomerResponse create(CustomerRequest request) {

        if (customerRepository.existsByEmail(request.email())) {
            throw new DuplicateCustomerException(request.email());
        }

        Customer customer = customerMapper.toEntity(request);

        Customer savedCustomer = customerRepository.save(customer);

        return customerMapper.toResponse(savedCustomer);
    }

    @Transactional(readOnly = true)
    public List<CustomerResponse> getAll() {

        return customerRepository.findAll()
                .stream()
                .map(customerMapper::toResponse)
                .toList();
    }

    @Transactional(readOnly = true)
    public CustomerResponse getById(Long id) {

        Customer customer = findCustomer(id);

        return customerMapper.toResponse(customer);
    }

    @Transactional
    public CustomerResponse update(
            Long id,
            CustomerRequest request
    ) {
        Customer customer = findCustomer(id);

        boolean duplicateEmail =
                customerRepository.existsByEmailAndIdNot(
                        request.email(),
                        id
                );

        if (duplicateEmail) {
            throw new DuplicateCustomerException(request.email());
        }

        customerMapper.updateEntity(customer, request);

        Customer savedCustomer = customerRepository.save(customer);

        return customerMapper.toResponse(savedCustomer);
    }

    @Transactional
    public void delete(Long id) {

        Customer customer = findCustomer(id);

        customerRepository.delete(customer);
    }

    private Customer findCustomer(Long id) {

        return customerRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Customer not found with ID: " + id
                        )
                );
    }
}
