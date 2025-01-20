# Spring Boot CRUD Project

This repository contains a Spring Boot project implementing a CRUD (Create, Read, Update, Delete) application. The project is designed using the **MVC (Model-View-Controller)** architecture and exposes RESTful APIs to manage products and images.

## Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Technologies Used](#technologies-used)
- [How to Run](#how-to-run)

## Overview

This project demonstrates the implementation of a basic CRUD system using Spring Boot. It provides RESTful APIs for managing:

- Products
- Images associated with products

The project follows best practices for designing RESTful APIs and utilizes Spring Boot's powerful tools for rapid development.

## Features

- **CRUD Operations**
  - Add, view, update, and delete products and images.
- **RESTful API Design**
  - APIs are designed to follow REST principles.
- **MVC Architecture**
  - Clear separation of concerns between models, controllers, and services.

## Technologies Used

- **Spring Boot**: Framework for building Java-based applications.
- **Spring Data JPA**: For database interactions.
- **H2 Database**: In-memory database for development and testing.
- **Maven**: Dependency management and build automation.
- **Postman**: API testing and documentation.

## How to Run

1. Clone the repository:

   ```bash
   git clone https://github.com/yourusername/springboot-crud.git
   ```

2. Navigate to the project directory:

   ```bash
   cd springboot-crud
   ```

3. Build the project:

   ```bash
   mvn clean install
   ```

4. Run the application:

   ```bash
   mvn spring-boot:run
   ```

5. Access the API at `http://localhost:8080` using tools like Postman.

## Future Plans

- Add validation for API requests.
- Implement user authentication and authorization.
- Integrate with a cloud storage solution for image management.
- Add Swagger documentation for APIs.

Thank you for visiting my repository! I hope this project demonstrates practical use cases for Spring Boot in building RESTful CRUD applications.
