
# GPS Tracking System


## Overview

The GPS Tracking System is a web application that allows users to manage vehicle information, track GPS data, and calculate distances traveled. This README provides an overview of the project's features, how to run the application, and more.

## Table of Contents

- [Features](#features)
- [Technologies Used](#technologies-used)
- [Setup](#setup)
- [Usage](#usage)
- [Screenshots](#screenshots)
- [UML Diagram](#uml-diagram)
- [Contributing](#contributing)
- [License](#license)

## Features

- Create and manage vehicle owners with details such as name, license number, address, phone number, and email.
- Add vehicles to owners with information like registration number, bike model, insurance expiry date, and purchase date.
- Record GPS data with latitude, longitude, and timestamp for vehicles.
- Calculate and display the distance traveled by a specific vehicle within a given date range.
- Web-based frontend interface for easy interaction with the system.

## Technologies Used

- Java
- Spring Boot
- Hibernate
- MySQL
- JSP (JavaServer Pages)

## Setup

1. Clone the repository:
git clone


2. Configure database settings in `src/main/resources/application.properties`:

properties
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/GPS
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

## Usage

1. Create vehicle owners using the API endpoint: `POST /api/owners/create`.
2. Add vehicles to owners using the API endpoint: `POST /api/owners/{OwnerId}/vehicles`.
3. Record GPS data for vehicles using the API endpoint: `POST /api/vehicles/{vehicleId}/gps`.
4. Access the frontend:
   - Visit http://localhost:8080/ to create owners.
   - Get a list of vehicles for an owner by providing the owner ID.
   - Calculate the distance traveled by a vehicle within a date range.

## Screenshots


![Owner Form](https://miro.medium.com/v2/resize:fit:1400/1*NoIOTwIOH7fiA3bLU2rH5Q.png)


![Vehicle List](https://miro.medium.com/v2/resize:fit:1400/1*bZLQo4rNUlPmgx6Ljpih3g.png)


![Distance Calculation](https://cdn-images-1.medium.com/max/800/1*-RVh2jR-lduaUxek-o-uiQ.png)

## UML Diagram

![UML Diagram](https://cdn-images-1.medium.com/max/800/1*tfzhHZBzUrfMlG-PxN3hKg.png)


## Contributing

Contributions are welcome! Please follow the [Contributing Guidelines](CONTRIBUTING.md) for details.

## License

This project is created by @Rajesh Pradhan.
