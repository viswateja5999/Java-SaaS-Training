
package com.example.employeemanagement.service;

import com.example.employeemanagement.dto.CustomerRequest;
import com.example.employeemanagement.dto.CustomerResponse;
import com.example.employeemanagement.entity.Customer;
import com.example.employeemanagement.exception.DuplicateCustomerException;
import com.example.employeemanagement.exception.ResourceNotFoundException;
import com.example.employeemanagement.mapper.CustomerMapper;
import com.example.employeemanagement.repository.CustomerRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private CustomerMapper customerMapper;

    @InjectMocks
    private CustomerService customerService;

    private CustomerRequest request;
    private Customer customer;
    private CustomerResponse response;

    @BeforeEach
    void setUp() {
        request = new CustomerRequest(
                "Ravi",
                "ravi@example.com",
                new BigDecimal("125000.50")
        );

        customer = new Customer(
                "Ravi",
                "ravi@example.com",
                new BigDecimal("125000.50")
        );

        response = new CustomerResponse(
                1L,
                "Ravi",
                "ravi@example.com",
                new BigDecimal("125000.50")
        );
    }

    @Test
    void createShouldReturnCustomerResponse() {
        when(customerRepository.existsByEmail(request.email()))
                .thenReturn(false);

        when(customerMapper.toEntity(request))
                .thenReturn(customer);

        when(customerRepository.save(customer))
                .thenReturn(customer);

        when(customerMapper.toResponse(customer))
                .thenReturn(response);

        CustomerResponse result = customerService.create(request);

        assertEquals("Ravi", result.name());
        assertEquals("ravi@example.com", result.email());
        assertEquals(
                new BigDecimal("125000.50"),
                result.salary()
        );

        verify(customerRepository).save(customer);
    }

    @Test
    void createShouldRejectDuplicateEmail() {
        when(customerRepository.existsByEmail(request.email()))
                .thenReturn(true);

        assertThrows(
                DuplicateCustomerException.class,
                () -> customerService.create(request)
        );

        verify(customerRepository, never()).save(any());
    }

    @Test
    void getByIdShouldThrowWhenCustomerDoesNotExist() {
        when(customerRepository.findById(99L))
                .thenReturn(Optional.empty());

        assertThrows(
                ResourceNotFoundException.class,
                () -> customerService.getById(99L)
        );
    }
}
