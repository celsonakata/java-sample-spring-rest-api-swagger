[![Build Status](https://travis-ci.com/celsonakata/java-sample-spring-rest-api-swagger.svg)](https://travis-ci.com/celsonakata/java-sample-spring-rest-api-swagger)

# Sample Java REST API with Spring framework and Swagger UI

## Description
This code is a sample of Java REST API using Spring framework and other technologies, like:

* [Spring Initializr](https://start.spring.io/) - Create Spring Boot Java projects;
* Startup with Spring Boot (@SpringBootApplication);
* REST API - Endpoints with CRUD operations (create, read, update and delete);
* [Swagger 2 documentation](https://swagger.io/) - Simplify REST API documentation;
* Controller, Service, DAO and Model class layers with Spring framework; 
* DAO class using CRUD Operations Interface from Spring Data (CrudRepository);
* [H2 Database](https://www.h2database.com/html/main.html) - Open-source in-memory SQL Database;
* [Project Lombok](https://projectlombok.org/) - Java library that abstract getter and setter methods in POJO classes.
* Unit tests with JUnit4 and Mockito - test code for coverage application java code.

## Build and Run
To build and run the application, type:

```
mvn spring-boot:run
```

## Testing REST API operations using Swagger UI

Use your favorite browser and type:

```
http://localhost:8080/swagger-ui.html
```

Open the Spring Swagger Controller to view the operations, and selected and testing each operation (GET, POST, PUT, DELETE);  
Click in `Try it out` and `Execute` to testing the application;  

For the POST operation, you can use this json sample below:

```
{
	"id": 4, 
	"title": "From Earth to Moon", 
	"description": "Jules Verne's classic tale of the first trip from the Earth to the Moon", 
	"author": "Jules Verne", 
	"edition": "1st Edition", 
	"pages": 112, 
	"launchDate": "1950-01-01", 
	"status": "Available", 
	"publisher": "Longman"
}
```

For the PUT operation, you can use this json sample below:

```
{
	"id": 2, 
	"title": "Cosmos", 
	"description": "This book is about science in its broadest human context, how science and  civilization grew up together", 
	"author": "Carl Sagan", 
	"edition": "1st Edition", 
	"pages": 365, 
	"launchDate": "1980-01-01", 
	"status": "Unavailable", 
	"publisher": "Random House"
}
```
