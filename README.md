

# Insurance Policy Management API
This project is an implementation of a RESTful API for managing insurance policies.

## endpoint link (may be after 15 apr this link is destroy)
<a href="https://insurance-management-system-production.up.railway.app/swagger-ui/index.html"> click here to live demo </a>
 </h2>

## Table of Contents
- Features
- Technologies Used
- Getting Started
- API Documentation
- Testing
- Contributing
- License


## Features
 The API supports the following features:

- Creating and managing clients
- updating deleteing and retriving a particular clients by id
- Retrieving a list of all clients
- Creating and managing insurance policies for clients
- updating deleteing and retriving a particular insurance policies by id
- Retrieving a list of all insurance policies
- Creating and managing claim for insurance policies
- updating deleteing and retriving a particular claim by id
- Retrieving a list of all claim
- Retrieving a list of all claim for a client
- Authenticating users and generating JWT tokens for authorization
- Documentation all api using swaagger-ui



## Technologies Used
The project is built using the following technologies:

- Java 17
- Spring Boot 3.0.5
- Spring Security
- JWT for authentication
- Hibernate for ORM mapping
- MySQL for the database
- Swagger for API documentation


## Getting Started
To get started with the project, you will need to have the following tools installed on your machine:

- JDK 11 or later
- Maven
- MySQL


To set up the project, follow these steps:

1. Clone the project repository: git clone [https://github.com/your-username/insurance-policy-management](https://github.com/VINAYKUMARKUNDER/Insurance-Management-System).git
2. Navigate to the project directory: cd insurance-policy-management
3. Open the application.properties file and configure your MySQL database settings
4. Build the project using Maven: mvn clean install
5. Run the project: mvn spring-boot:run


The API will be accessible at http://localhost:8080.

## API Documentation
API documentation is available using Swagger. To access the documentation, run the project and navigate to http://localhost:8080/swagger-ui.html.

## Testing
Tests have been implemented for the API using JUnit and Mockito. To run the tests, use the following command: mvn test.

## Contributing
If you would like to contribute to the project, please follow these steps:

1. Fork the project repository
2. Create a new branch for your changes: git checkout -b my-new-feature
3. Make your changes and commit them: git commit -am 'Add some feature'
4. Push the changes to your branch: git push origin my-new-feature
5. Submit a pull request


## License
This project is licensed under the MIT License. See the LICENSE file for details.







