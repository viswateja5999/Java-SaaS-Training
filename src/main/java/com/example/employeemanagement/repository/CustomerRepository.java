package com.example.employeemanagement.repository;

import com.example.employeemanagement.entity.Customer;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository
        extends JpaRepository<Customer, Long> {

    boolean existsByEmail(String email);

    boolean existsByEmailAndIdNot(String email, Long id);

    //boolean existsByEmailAndIdNot(@NotBlank(message = "Customer email is required") @Email(message = "Please provide a valid email address") @Size(max = 150, message = "Email cannot exceed 150 characters") String email, Long id);
}