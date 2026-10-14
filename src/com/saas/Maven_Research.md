Research Maven


1.What is Maven?

   Maven is a build automation tool used in Java and Spring Boot projects. It helps us download libraries, compile code, run tests, and package applications.
   Example: Instead of downloading every Java library manually, Maven downloads the required libraries based on the pom.xml file.

2. What is pom.xml?
   
   pom.xml stands for Project Object Model. It is the main configuration file of a Maven project.
   It contains:
- Project information
- Dependencies
- Plugins
- Build configuration

Example :

<dependencies>
<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-web</artifactId>
</dependency>
</dependencies>

This dependency provides the components needed to build web applications and REST APIs using Spring Boot.

3. What are Dependencies?

   Dependencies are external libraries that our application needs to work.
   For example, in your SaaS Employee Management application:
- Spring Web: To create REST APIs.
- Spring Boot Validation: To validate employee details such as email and salary.
- Spring Data JPA: To interact with a database.
  
  Maven downloads these libraries and makes them available to the project.

4. What are Plugins? 

   Plugins help Maven perform specific tasks during the build process.
   Examples:
- maven-compiler-plugin – compiles Java code.
- maven-surefire-plugin – runs tests.
- spring-boot-maven-plugin – helps run and package a Spring Boot application.
  Difference: Dependencies are libraries used by application code, whereas plugins perform build-related tasks.

5. What are Maven Repositories?
   
   Repositories are locations where Maven stores or downloads libraries and other project artifacts.
   There are three common types:
- Local repository: Stores downloaded libraries on your computer.
- Central repository: Provides publicly available Java libraries.
- Remote repository: Can store company-specific or privately shared libraries.
  
  Maven can reuse libraries from the local repository instead of downloading them again.

6. What is the Maven Lifecycle?

   The Maven lifecycle defines the sequence of steps used to build a project.
 
    Phase	                --------  Explanation

   validate -----	Checks whether the project is configured correctly.
     
   compile ------	Compiles Java source code.
       
   test	Runs ----- automated tests.
       
   package ---	Creates a JAR or WAR file.
       
   install -----	Stores the built artifact in the local Maven repository.
       
   deploy ----	Publishes the artifact to a remote repository.
       
    For example, when you run mvn package, Maven performs the earlier required phases before creating the package.


7.Important Maven Commands
   
   mvn clean
   
   Removes previous build output, usually from the target folder.
   
   mvn test
   
   Runs the project's automated tests to check whether the code behaves as expected.
   
   mvn package
   
   Compiles the application, runs tests as configured, and packages it into a JAR or WAR file.
   
   mvn spring-boot:run
   
   Starts the Spring Boot application directly from the project.
   
   For your project, run these commands in the IntelliJ terminal from the folder containing pom.xml.