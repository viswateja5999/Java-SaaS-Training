package com.example.employeemanagement;


import com.example.employeemanagement.dto.CustomerRequest;
import com.example.employeemanagement.dto.CustomerResponse;
import com.example.employeemanagement.entity.Customer;
import com.example.employeemanagement.repository.CustomerRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureTestRestTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.resttestclient.TestRestTemplate;
//import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;

import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestRestTemplate
@ActiveProfiles("test")
class CustomerControllerIntegrationTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private CustomerRepository customerRepository;

    private String baseUrl;

    @BeforeEach
    void setUp() {
        baseUrl = "http://localhost:" + port + "/api/v1/customers";
        customerRepository.deleteAll();
    }

    private CustomerRequest validRequest(String email) {
        return new CustomerRequest(
                "Ravi",
                email,
                new BigDecimal("125000.50")
        );
    }

    @Test
    void createCustomerShouldReturn201() {
        ResponseEntity<Map> response = restTemplate.postForEntity(
                baseUrl,
                validRequest("ravi@example.com"),
                Map.class
        );

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("Ravi", response.getBody().get("name"));
        assertEquals(
                "ravi@example.com",
                response.getBody().get("email")
        );
        assertEquals(
                125000.50,
                ((Number) response.getBody().get("salary")).doubleValue(),
                0.001
        );
    }

    @Test
    void duplicateEmailShouldReturn409() {
        restTemplate.postForEntity(
                baseUrl,
                validRequest("ravi@example.com"),
                Map.class
        );

        ResponseEntity<Map> response = restTemplate.postForEntity(
                baseUrl,
                validRequest("ravi@example.com"),
                Map.class
        );

        assertEquals(HttpStatus.CONFLICT, response.getStatusCode());
    }

    @Test
    void invalidEmailShouldReturn400() {
        CustomerRequest invalidRequest = new CustomerRequest(
                "Ravi",
                "not-an-email",
                new BigDecimal("125000.50")
        );

        ResponseEntity<Map> response = restTemplate.postForEntity(
                baseUrl,
                invalidRequest,
                Map.class
        );

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    void missingCustomerShouldReturn404() {
        ResponseEntity<Map> response = restTemplate.getForEntity(
                baseUrl + "/999999",
                Map.class
        );

        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void updateAndDeleteShouldWork() {
        ResponseEntity<Map> createResponse = restTemplate.postForEntity(
                baseUrl,
                validRequest("update@example.com"),
                Map.class
        );

        assertEquals(HttpStatus.CREATED, createResponse.getStatusCode());

        Number idValue = (Number) createResponse.getBody().get("id");
        long id = idValue.longValue();

        CustomerRequest updatedRequest = new CustomerRequest(
                "Updated Ravi",
                "updated@example.com",
                new BigDecimal("135000.75")
        );

        restTemplate.put(baseUrl + "/" + id, updatedRequest);

        ResponseEntity<Map> getResponse = restTemplate.getForEntity(
                baseUrl + "/" + id,
                Map.class
        );

        assertEquals(HttpStatus.OK, getResponse.getStatusCode());
        assertEquals(
                "Updated Ravi",
                getResponse.getBody().get("name")
        );

        restTemplate.delete(baseUrl + "/" + id);

        ResponseEntity<Map> deletedResponse = restTemplate.getForEntity(
                baseUrl + "/" + id,
                Map.class
        );

        assertEquals(
                HttpStatus.NOT_FOUND,
                deletedResponse.getStatusCode()
        );
    }
}

