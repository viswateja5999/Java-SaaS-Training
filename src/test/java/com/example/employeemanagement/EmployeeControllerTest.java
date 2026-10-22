package com.example.employeemanagement;

import com.example.employeemanagement.entity.Employee;
import com.example.employeemanagement.repository.EmployeeRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private EmployeeRepository repository;

    @BeforeEach
    void cleanDatabase() {
        repository.deleteAll();
    }

    @Test
    void createEmployeeSuccessfully() throws Exception {
        String json = """
                {
                  "name": "Ravi",
                  "email": "ravi@example.com",
                  "salary": 35000
                }
                """;

        mockMvc.perform(post("/api/v1/employees")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("Ravi"));
    }

    @Test
    void rejectInvalidEmployee() throws Exception {
        String json = """
                {
                  "name": "",
                  "email": "wrong-email",
                  "salary": -100
                }
                """;

        mockMvc.perform(post("/api/v1/employees")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isBadRequest());
    }

    @Test
    void rejectDuplicateEmail() throws Exception {
        repository.save(new Employee(
                "Ravi", "ravi@example.com", 35000.0));

        String json = """
                {
                  "name": "Kiran",
                  "email": "ravi@example.com",
                  "salary": 40000
                }
                """;

        mockMvc.perform(post("/api/v1/employees")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isConflict());
    }

    @Test
    void rejectMissingEmployee() throws Exception {
        mockMvc.perform(get("/api/v1/employees/999999"))
                .andExpect(status().isNotFound());
    }
}