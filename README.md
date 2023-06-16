This repository demonstrates a simple Spring Boot application that showcases a one-to-one relationship between two entities using JPA and Hibernate.

## Overview

The project consists of two entities: `User` and `Address`, where each user has only one address and each address belongs to only one user. The application demonstrates how to create, retrieve, update, and delete entities with a one-to-one relationship.

## Features

- Create a `Employee` entity without an associated `Address`.
- Associate an `Address` with an existing `Employee`.
- Retrieve `Employee` and `Address` entities.
- Update and delete `Employee` and `Address` entities.

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- H2 Database (in-memory database)

## Usage

Follow these steps to run the application:

1. Clone the repository:

2. Navigate to the project directory:
cd springboot-one-to-one-relationship

3. Build and run the application using Maven:
	mvn spring-boot:run
4. Open your web browser and visit http://localhost:8080 to access the application.

## caoution
I attached application.properties just for demo, don't do it when in production !

License
This project is licensed under the MIT License, which means you are free to use it for any purpose, commercial or non-commercial, without any restrictions.
Contributing
Contributions are welcome! If you find any issues or want to add new features, please submit a pull request.
Acknowledgments
* Spring Boot
* Hibernate
* H2 Database
Feel free to use this project as a starting point for your own applications or for learning purposes.
If you have any questions or feedback, please feel free to reach out.
Happy coding!
