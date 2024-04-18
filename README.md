# EmployeeManagement-SpringRestAPI
# Employee Management System

This project is an Employee Management System developed using Spring Boot framework.

## Project Overview
The project allows basic CRUD (Create, Read, Update, Delete) operations on employee data. Here's a breakdown of the key components:

- **Controller:** Handles incoming HTTP requests. Contains REST endpoints for CRUD operations on employees.
- **Entity:** Defines the Employee entity with attributes such as id, firstName, lastName, and email.
- **Exception:** Custom exception class `ResourceNotFoundException` to handle resource not found scenarios.
- **Repository:** Interface extending `JpaRepository` to interact with the database. Provides methods for CRUD operations on the Employee entity.
- **Service:** Interface `EmployeeService` defining methods for managing employees. Implementation class `EmployeeServiceImpl` providing implementations for service methods.

## Endpoints
- **GET /api/Employees:** Retrieve all employees.
- **GET /api/Employees/{id}:** Retrieve employee by ID.
- **POST /api/Employees:** Create a new employee.
- **PUT /api/Employees/{id}:** Update an existing employee.
- **DELETE /api/Employees/{id}:** Delete an employee by ID.

For detailed usage and examples, refer to the source code and Javadoc comments.


employee-management-system
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── employee
│   │   │           ├── controller
│   │   │           ├── entity
│   │   │           ├── exception
│   │   │           ├── repository
│   │   │           └── service
│   └── resources
│       └── application.properties
└── pom.xml


