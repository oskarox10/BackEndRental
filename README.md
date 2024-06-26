﻿# BackEndRental

 
Functionalities:
- Register a new car: Allows users to register a new car with details such as manufacturing year, brand, model, and status.
- Get a car by ID: Retrieves car details based on the provided car ID.
- Get all cars: Retrieves details of all registered cars.
- Update a car by ID: Allows users to update the details of a car based on the provided car ID.
- Delete a car by ID: Deletes a car record based on the provided car ID.

What it does:
The Car Management System is a Spring Boot application that allows users to manage car records effectively. It provides RESTful APIs to perform CRUD operations on car entities.

Key Features:
- Data Validation: Validates input data such as manufacturing year, brand, and car status to ensure data integrity.
- Error Handling: Handles errors such as resource not found and invalid request data gracefully.
- Database: Uses an H2 in-memory database for storing car records.
- Custom Converters: Utilizes custom converters to convert String values to Enum types (e.g., BrandEnumConverter, CarStatusEnumConverter).
- Custom Exception Handling: Implements custom exceptions for better error handling (e.g., NotFoundException).
- DTO to Entity Mapping: Uses MapStruct for mapping between DTOs and entities (e.g., CarMapper).
- RESTful Endpoints: Provides a set of RESTful endpoints for managing car records.

Technologies Used:
- Java 11
- Spring Boot
- Maven
- Lombok
- MapStruct
- H2 Database

Author:
Oskar Stachowski

Resources:
- Spring Boot Documentation
- MapStruct Documentation
- Hibernate Validator Documentation
- Lombok Documentation
- H2 Database Documentation
