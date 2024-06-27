# Calculator Application

## Overview
This project is a simple web-based calculator application built using Spring Boot. It allows users to perform basic arithmetic operations such as addition, subtraction, multiplication, and division. The current value is stored in session memory, allowing continuous operations.

## Technologies and Architecture Used
- **Spring Boot**: Framework used to create the web application.
- **Thymeleaf**: Template engine used for rendering HTML.
- **Maven**: Build automation tool.
- **Java**: Programming language used for development.

## Getting Started
To run this application, you need to have Java and Maven installed. You can check if you have them installed by running the following commands:

`java --version`

`mvn --version`

## How the App Works
- The CalculatorApplication class is the entry point of the application. It initializes the Spring Boot application.
- The MathOperationsController handles HTTP requests and processes the calculator operations.
- The OperationMemory class is a session-scoped component that stores the current value of the calculator.
- The calculator_view.html file is the front-end of the application where users can input numbers and operations.

## Generating Javadoc with Maven
You can generate the Javadoc for this project using Maven by running the following command:

`mvn javadoc:javadoc`

This will generate the documentation in the target/site/apidocs directory.

## Software Architecture Diagram

```
+------------------------+
|   CalculatorApplication|
|     (Spring Boot App)  |
+-----------+------------+
            |
            v
+-----------+------------+
|  MathOperationsController|
|        (Controller)     |
+-----------+------------+
            |
            v
+-----------+------------+
|    OperationMemory     |
|   (Session-scoped Bean)|
+-----------+------------+
            |
            v
+-----------+------------+
|   calculator_view.html |
|     (Thymeleaf View)   |
+------------------------+
```

## How to Deply with Maven 
To build and deploy the application using Maven, run the following command:

`maven clean package`


This will create a jar file in the target directory. You can then run the application using:

`java -jar target/calculator-application-0.0.1-SNAPSHOT.jar`

## Author
Hann Jang