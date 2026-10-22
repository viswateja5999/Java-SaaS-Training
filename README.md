# Employee Management System

## 1. Project Overview

The Employee Management System is a REST API application developed using Java, Spring Boot, Spring Data JPA, and Maven.

The application allows users to create, retrieve, update, and delete employee records. It also provides request validation, business rule enforcement, exception handling, and automated testing.

## 2. Technologies Used

- **Java:** 21
- **Spring Boot:** 4.1.1
- **Build Tool:** Maven
- **Spring Web:** To develop REST APIs
- **Spring Validation:** To validate request data
- **Spring Data JPA:** To interact with the database
- **Hibernate:** ORM framework
- **H2 Database:** In-memory database for local development and testing
- **JUnit:** Unit testing
- **MockMvc:** Testing HTTP requests and responses
- **Postman:** Manual API testing
- **Git and GitHub:** Version control and code management
- **IntelliJ IDEA:** Development environment

## 3. Project Objectives

- Create a Maven-based Spring Boot application.
- Understand Spring Boot auto-configuration and dependency injection.
- Organize code using controller, service, repository, entity, DTO, and exception packages.
- Develop REST APIs for employee management.
- Validate employee request data.
- Implement database persistence using Spring Data JPA.
- Handle business rules and exceptions consistently.
- Write automated tests using JUnit and MockMvc.
- Verify application functionality and document project setup.

## 4. Project Structure

```text
demo/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/employeemanagement/
│   │   │       ├── EmployeeManagementApplication.java
│   │   │       ├── controller/
│   │   │       ├── service/
│   │   │       ├── repository/
│   │   │       ├── entity/
│   │   │       ├── dto/
│   │   │       └── exception/
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/
│           └── com/example/employeemanagement/
├── pom.xml
└── README.md
```

### Package Responsibilities

- **controller:** Handles incoming HTTP requests and returns responses.
- **service:** Contains employee business logic and transactional operations.
- **repository:** Communicates with the database through Spring Data JPA.
- **entity:** Defines the employee database entity and its mappings.
- **dto:** Defines request and response data transfer objects.
- **exception:** Contains custom exceptions and global exception handling.
- **resources:** Contains application configuration.
- **test:** Contains unit and integration tests.

## 5. Application Architecture

The application follows a layered architecture:

```text
Client / Postman
       |
       v
   Controller
       |
       v
     Service
       |
       v
   Repository
       |
       v
  H2 Database
```

The controller receives HTTP requests, the service applies business rules, the repository performs database operations, and the database stores employee records.

DTOs transfer request and response data, while validation and exception handling provide predictable API behavior.

## 6. API Endpoints

Base URL: `http://localhost:8080`

| Method | Endpoint | Purpose |
|---|---|---|
| GET | `/api/v1/employees` | Retrieve all employees |
| POST | `/api/v1/employees` | Create a new employee |
| GET | `/api/v1/employees/{id}` | Retrieve an employee by ID |
| PUT | `/api/v1/employees/{id}` | Update an employee |
| DELETE | `/api/v1/employees/{id}` | Delete an employee |
| GET | `/actuator/health` | Check application health, if Actuator is configured |

## 7. Sample API Requests

### Create an Employee

**Method:** POST

**URL:** `http://localhost:8080/api/v1/employees`

**Request Body:**

```json
{
  "name": "Ravi Kumar",
  "email": "ravi@example.com",
  "salary": 35000
}
```

Expected result: A successful HTTP response with the created employee details.

### Retrieve All Employees

**Method:** GET

**URL:** `http://localhost:8080/api/v1/employees`

Expected result: A list of employee records.

### Retrieve an Employee by ID

**Method:** GET

**URL:** `http://localhost:8080/api/v1/employees/1`

Expected result: The employee details if the employee exists.

### Update an Employee

**Method:** PUT

**URL:** `http://localhost:8080/api/v1/employees/1`

**Request Body:**

```json
{
  "name": "Ravi Kumar",
  "email": "ravi@example.com",
  "salary": 40000
}
```

Expected result: The employee record is updated if the employee exists and the request is valid.

### Delete an Employee

**Method:** DELETE

**URL:** `http://localhost:8080/api/v1/employees/1`

Expected result: A successful deletion response if the employee exists.

*Note: Actual response status codes depend on the controller implementation.*

## 8. Request Validation

The application uses DTOs and Bean Validation to validate incoming employee data.

Validation rules include:

- Employee name must not be blank.
- Email must have a valid email format.
- Salary must be greater than zero.
- Required request fields must be supplied.

### Invalid Request Example

```json
{
  "name": "",
  "email": "wrong-email",
  "salary": -35000
}
```

Expected result: HTTP `400 Bad Request` when validation is configured and triggered correctly.

## 9. Exception Handling

The application uses centralized exception handling with `@RestControllerAdvice`.

It can handle errors such as:

- Employee not found.
- Invalid request data.
- Duplicate employee email.
- Database constraint violations.
- Missing or malformed request bodies.

Example error response:

```json
{
  "error": "Salary must be greater than zero"
}
```

The actual error response fields depend on the implemented exception handler.

## 10. Database Configuration

The application uses an H2 in-memory database for local development.

Example configuration for `src/main/resources/application.properties`:

```properties
spring.application.name=employee-management

spring.datasource.url=jdbc:h2:mem:demodb
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
```

The H2 console can be accessed at:

`http://localhost:8080/h2-console`

Use the JDBC URL `jdbc:h2:mem:demodb`, username `sa`, and the configured password.

**Important:** H2 in-memory database records are lost when the application stops. This configuration is intended for development and testing, not production.

## 11. Testing

The project uses JUnit and, where configured, MockMvc to verify application behavior.

Test scenarios include:

- Creating an employee with valid data.
- Retrieving employee records.
- Updating an existing employee.
- Deleting an employee.
- Rejecting invalid email addresses.
- Rejecting blank names and non-positive salaries.
- Returning an appropriate response for a missing employee.
- Verifying error response structures.

## 12. How to Run the Project

### Prerequisites

- Java Development Kit (JDK) 21.
- IntelliJ IDEA.
- Maven, or the Maven Wrapper included in the project.
- Postman for manual API testing.

### Steps

1. Open the project in IntelliJ IDEA.
2. Verify the Java SDK and Maven configuration.
3. Allow Maven to download the required dependencies.
4. Check `application.properties`.
5. Run `EmployeeManagementApplication.java`.
6. Confirm that the application starts successfully on port `8080`.
7. Open Postman and send requests to the endpoints listed above.
8. Run the automated tests before committing changes.

## 13. Maven Commands

Run these commands in the IntelliJ Terminal from the project root directory.

Run tests:

```bash
mvn clean test
```

Build the project:

```bash
mvn clean package
```

Run the application:

```bash
mvn spring-boot:run
```

Check Git status:

```bash
git status
```

Stage the README and other intended changes:

```bash
git add README.md
```

Commit the changes:

```bash
git commit -m "docs: add employee management README"
```

Push the current branch:

```bash
git push
```

If the branch has no upstream configured, use:

```bash
git push -u origin <branch-name>
```

Replace `<branch-name>` with your actual branch name.

## 14. Work Summary: 12-Oct to 16-Oct

### 12-Oct — Spring Boot and Dependency Injection

- Created a Maven-based Spring Boot project.
- Reviewed the application entry point and auto-configuration.
- Organized the application into layered packages.
- Practiced constructor-based dependency injection and health endpoints.

### 13-Oct — REST APIs and DTO Validation

- Implemented POST and GET employee endpoints.
- Created DTOs for request and response data.
- Added validation for required fields, email format, and positive salary.
- Tested valid and invalid API requests.

### 14-Oct — JPA and CRUD Operations

- Mapped the Employee entity.
- Created a Spring Data JPA repository.
- Configured the local database.
- Implemented get-by-ID, update, and delete operations.
- Tested missing employee and database constraint scenarios.

### 15-Oct — Business Rules, Errors, and Tests

- Organized business rules in the service layer.
- Implemented centralized exception handling.
- Standardized API error responses.
- Added JUnit and MockMvc tests where configured.

### 16-Oct — Integration and Review

- Reviewed end-to-end CRUD flows.
- Checked database persistence and constraints.
- Documented API endpoints and setup instructions.
- Ran Maven test and package commands.
- Reviewed the controller-to-service-to-repository-to-database flow.

*This work summary describes the planned scope of the five-day task. Confirm that each item has been implemented and tested before reporting it as completed.*

## 15. Known Limitations

- H2 in-memory data is not retained after application restart.
- Duplicate email handling requires appropriate service logic and exception mapping.
- Validation may return only the first error if the exception handler is implemented that way.
- Production database configuration and authentication are outside the current scope.
- Test coverage depends on the test cases actually implemented in the project.

## 16. Future Improvements

- Add pagination and sorting for employee listings.
- Improve duplicate email error handling.
- Return field-specific validation messages.
- Add integration tests for database operations.
- Configure a persistent database such as PostgreSQL or MySQL.
- Add API documentation using OpenAPI/Swagger.
- Add authentication and authorization.

## 17. Conclusion

This project demonstrates the fundamentals of building a Spring Boot REST API using layered architecture, dependency injection, DTO validation, Spring Data JPA, exception handling, and automated testing.

The project also provides a foundation for learning advanced Spring Boot topics, including transactions, pagination, entity relationships, query optimization, and microservices.
