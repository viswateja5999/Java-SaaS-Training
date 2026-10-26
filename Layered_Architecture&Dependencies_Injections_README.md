# Customer Management API

## 1. Project Overview

The Customer Management API is a RESTful backend application built using Java, Spring Boot, Spring Data JPA, and H2 Database.

It supports creating, retrieving, updating, and deleting customers. Each customer contains an ID, name, email, and salary.

## 2. Objectives

- Implement layered architecture.
- Configure dependency injection using constructor injection.
- Separate controllers, services, repositories, entities, DTOs, and exceptions.
- Implement CRUD operations for customers.
- Validate incoming request data.
- Handle errors consistently using a global exception handler.
- Use transactional service methods.
- Verify application behavior through unit and integration tests.

## 3. Technology Stack

- Java 21
- Spring Boot
- Spring Web MVC
- Spring Data JPA
- Hibernate ORM
- H2 In-Memory Database
- Jakarta Bean Validation
- JUnit and Mockito
- Maven
- Postman
- Git and GitHub

## 4. Project Structure

```text
src/main/java/com/example/employeemanagement/
├── EmployeeManagementApplication.java
├── config/
├── controller/
│   └── CustomerController.java
├── dto/
│   ├── CustomerRequest.java
│   ├── CustomerResponse.java
│   └── ApiError.java
├── entity/
│   └── Customer.java
├── exception/
│   ├── ResourceNotFoundException.java
│   ├── EmployeeNotFoundException.java
│   ├── DuplicateCustomerException.java
│   └── GlobalExceptionHandler.java
├── mapper/
│   └── CustomerMapper.java
├── repository/
│   └── CustomerRepository.java
└── service/
    └── CustomerService.java
```

The package structure above describes the intended organization. Keep only files and packages that exist in the actual project.

## 5. Layered Architecture

### Controller Layer

Receives HTTP requests, validates request bodies, and returns API responses.

### Service Layer

Contains business logic, duplicate-email checks, customer lookup, and transaction boundaries.

### Repository Layer

Uses Spring Data JPA to perform database operations.

### Entity Layer

The `Customer` entity represents the `customers` database table and contains:

- `id` — primary key
- `name` — customer name
- `email` — unique email address
- `salary` — decimal salary value

### DTO Layer

`CustomerRequest` validates incoming data, while `CustomerResponse` defines the data returned by the API.

### Mapper Layer

Converts request DTOs into entities and entities into response DTOs.

### Exception Layer

Handles missing customers, duplicate email addresses, invalid request data, and database constraint violations.

## 6. API Endpoints

Base URL: `http://localhost:8080/api/v1/customers`

| HTTP Method | Endpoint | Description | Expected Status |
|---|---|---|---|
| POST | `/api/v1/customers` | Create a customer | 201 Created |
| GET | `/api/v1/customers` | Retrieve all customers | 200 OK |
| GET | `/api/v1/customers/{id}` | Retrieve a customer by ID | 200 OK |
| PUT | `/api/v1/customers/{id}` | Update a customer | 200 OK |
| DELETE | `/api/v1/customers/{id}` | Delete a customer | 204 No Content |

A request for a customer ID that does not exist should return `404 Not Found`.

## 7. Sample Request

Use the following JSON body for creating or updating a customer:

```json
{
  "name": "Ravi",
  "email": "ravi@example.com",
  "salary": 125000.50
}
```

Example successful response:

```json
{
  "id": 1,
  "name": "Ravi",
  "email": "ravi@example.com",
  "salary": 125000.50
}
```

The generated ID may differ.

## 8. Validation Rules

- Name is required and cannot exceed 100 characters.
- Email is required, must have a valid email format, and cannot exceed 150 characters.
- Email addresses must be unique.
- Salary is required and must be greater than zero.
- Salary supports up to 10 integer digits and 2 decimal places.

## 9. Error Handling

The global exception handler returns a consistent error response.

Example:

```json
{
  "timestamp": "2026-10-26T08:35:08Z",
  "status": 404,
  "error": "Not Found",
  "message": "Customer not found with ID: 999",
  "path": "/api/v1/customers/999"
}
```

The timestamp and message depend on the actual request.

| Scenario | HTTP Status |
|---|---|
| Invalid request data | 400 Bad Request |
| Customer not found | 404 Not Found |
| Duplicate email | 409 Conflict |
| Database constraint violation | 409 Conflict |

## 10. Database Configuration

The development configuration uses an H2 in-memory database.

Example properties:

```properties
spring.datasource.url=jdbc:h2:mem:demodb
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.h2.console.enabled=true
```

Hibernate generates the database schema from the entity mapping when the application starts.

**Note:** H2 in-memory data is normally lost when the application stops. Do not use this configuration for production data.

## 11. How to Run the Application

### Prerequisites

- JDK 21
- Maven
- IntelliJ IDEA or another Java IDE
- Postman for API testing

### Step 1: Open the project

Open the project root directory in IntelliJ IDEA.

### Step 2: Run tests

```bash
mvn clean test
```

### Step 3: Start the application

```bash
mvn spring-boot:run
```

Alternatively, run `EmployeeManagementApplication.java` from IntelliJ IDEA.

### Step 4: Test using Postman

Send requests to:

`http://localhost:8080/api/v1/customers`

Select the required HTTP method and provide the JSON body for POST and PUT requests.

## 12. Testing

The intended test coverage includes:

- Successful customer creation.
- Duplicate email rejection.
- Invalid request validation.
- Retrieving customers.
- Handling nonexistent customer IDs.
- Updating customer details.
- Deleting customers.
- Verifying the expected HTTP status codes.

Run `mvn clean test` to check the tests. Record only the test results that have actually been verified.

## 13. Design Decisions

- Constructor injection is used to supply dependencies.
- Controllers delegate business logic to services.
- Repositories handle persistence.
- DTOs separate API contracts from database entities.
- `BigDecimal` represents salary values.
- Transactional annotations define service transaction boundaries.
- A unique email constraint provides database-level duplicate protection.
- Centralized exception handling keeps error responses consistent.

## 14. Limitations and Future Improvements

- The current H2 in-memory database does not retain data across restarts.
- Authentication and authorization are not implemented.
- PostgreSQL and Testcontainers integration can be added.
- Versioned database migrations can be introduced using Flyway or Liquibase.
- Validation currently reports the first field error.
- Additional integration and failure-path tests can improve coverage.
- OpenAPI documentation and production observability can be added.

## 15. Git Workflow

Create a feature branch and commit the implementation:

```bash
git switch -c feature/customer-salary-crud
git status
git add .
git commit -m "Add customer CRUD with salary and validation"
git push -u origin feature/customer-salary-crud
```

Review the staged changes before committing. Do not commit generated build output, credentials, or secrets.

## 16. Conclusion

This project demonstrates a layered Spring Boot REST API with customer CRUD operations, salary handling, dependency injection, request validation, JPA persistence, centralized error handling, and automated testing.

The implementation can be extended with persistent database storage, security, migration scripts, API documentation, and additional integration tests.
