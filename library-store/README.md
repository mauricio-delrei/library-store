Project developed with Java version 17 and Spring Boot and PostgreSQL database
To run the project, use the command: mvn spring-boot:run
To test via Postman:

retrieveBook(String reference)
GET http://localhost:8080/book/{reference}

getBookSummary(String reference)
GET http://localhost:8080/book/reference/{reference}
