Research SpringBoot

1.What is Spring Framework?

Spring Framework is an open-source Java framework used to build enterprise and backend applications.

It provides features such as:

* Dependency Injection (DI)

* Inversion of Control (IoC)

* Web application development

* Database access

* Transaction management

* Security integration

*Application configuration

Spring helps developers build applications that are modular, maintainable, and easier to test.

2. What problem does Spring solve?

In traditional Java applications, classes often create their own dependencies. This can create tight coupling.

Example:

class EmployeeService {
    private EmployeeRepository repository = new EmployeeRepository();
}

Spring solves this problem using Dependency Injection.

class EmployeeService {
private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }
}

Spring can create the required object and provide it to EmployeeService.

Benefits

* Reduces tight coupling.

* Improves maintainability.

* Makes testing easier.

* Promotes reusable components.

* Manages object creation and dependencies.

3. What is Spring Boot?

Spring Boot is built on top of the Spring Framework and makes it faster and easier to create Spring applications.

Spring Boot provides:

* Auto-configuration

* Starter dependencies

* Embedded servers

* Production-ready features

* Minimal configuration

Example REST controller:

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @GetMapping
    public String getEmployees() {
        return "Employee list";
    }
}

4. Spring vs Spring Boot

Spring Framework                                   

* Core Java application framework

* More configuration may be required

* Server setup may require additional configuration

* Developers configure dependencies

* More setup

Spring Boot

* Built on top of Spring

* Reduces configuration

* Faster application development

* Provides convenient starter dependencies

* Provides embedded server support.


5. What is Dependency Injection?

Dependency Injection (DI) is a design technique where an object's dependencies are provided to it instead of the object creating them itself.

Without DI

class EmployeeService {
private EmployeeRepository repository =
new EmployeeRepository();
}

With DI

class EmployeeService {
private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }
}

Spring example

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }
}

Spring creates the dependency and injects it into the service.

6. What is IoC?

IoC stands for Inversion of Control.

Normally, the developer controls object creation:

EmployeeService service = new EmployeeService();

With Spring, the Spring IoC container manages object creation and dependencies.

@Service
public class EmployeeService {
}

Spring detects the class, creates a bean, and manages its lifecycle.

Simple explanation: IoC means giving control of object creation and management to the Spring container.

IoC and DI relationship

* IoC is the overall principle.

* Dependency Injection is one of the main ways Spring implements IoC.

7. What is a Spring Bean?

A Spring Bean is an object that is created, configured, and managed by the Spring IoC container.

Example:

@Service
public class EmployeeService {
}

Spring creates and manages an instance of EmployeeService.

Common annotations used to register beans include:

@Component

@Service

@Repository

@Controller

@RestController

@Bean

Example:

@Configuration
public class AppConfig {

    @Bean
    public EmployeeService employeeService() {
        return new EmployeeService();
    }
}

8. What is @SpringBootApplication?

@SpringBootApplication is the main annotation used on the main class of a Spring Boot application.

Example:

@SpringBootApplication
public class SaaSApplication {

    public static void main(String[] args) {
        SpringApplication.run(SaaSApplication.class, args);
    }
}

It combines three important annotations:

@SpringBootApplication
|
+-- @SpringBootConfiguration
|
+-- @EnableAutoConfiguration
|
+-- @ComponentScan

@SpringBootConfiguration

Indicates that the class is a Spring Boot configuration class.

@EnableAutoConfiguration

Allows Spring Boot to automatically configure components based on the project's dependencies.

@ComponentScan

Tells Spring to scan packages for components such as @Controller, @Service, and @Repository.

9. What is a Controller?

A Controller handles HTTP requests from clients such as web applications, mobile applications, or API clients.

In REST applications, @RestController is commonly used.

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @GetMapping
    public String getEmployees() {
        return "Employee list";
    }
}

Common annotations:

@Controller

@RestController

@RequestMapping

@GetMapping

@PostMapping

@PutMapping

@DeleteMapping

Responsibility

* A Controller generally:

* Receives HTTP requests.

* Accepts request data.

* Calls the Service layer.

* Returns an HTTP response.


10. What is a Service?

A Service contains the application's business logic.

Example:

@Service
public class EmployeeService {

    public String getEmployeeDetails() {
        return "Employee details";
    }
}

The Controller can call the Service:

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping
    public String getEmployees() {
        return service.getEmployeeDetails();
    }
}

Responsibility

The Service layer generally:

* Contains business rules.

* Performs business calculations.

* Coordinates repositories and other services.

* Keeps business logic out of the Controller.

11. What is a Repository?

A Repository is responsible for data access.

It is commonly used to communicate with a database.

With Spring Data JPA, a repository can be defined as:

public interface EmployeeRepository
extends JpaRepository<Employee, Long> {
}

Spring Data JPA provides many database operations automatically.

Common responsibilities

* Save data.

* Retrieve data.

* Update data.

* Delete data.

* Query database records.

12. What is Spring Data JPA?

Spring Data JPA is a Spring project that simplifies database access using the Java Persistence API (JPA).

It reduces the amount of database-related code developers need to write.

Example:

public interface EmployeeRepository
extends JpaRepository<Employee, Long> {
}

Common methods include:

save()
findById()
findAll()
deleteById()

Benefits

* Reduces boilerplate code.

* Provides CRUD operations.

* Supports custom query methods.

* Integrates with JPA and Hibernate.

* Simplifies database access.