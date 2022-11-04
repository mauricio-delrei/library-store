Project developed with Java version 17 and Spring Boot and PostgreSQL database.

1) Clone the project.

2) Using IntelliJ as a development tool

3) To run the project, use the command: mvn spring-boot:run

4) To test via Postman:
retrieveBook(String reference)
GET http://localhost:8080/book/{reference}

getBookSummary(String reference)
GET http://localhost:8080/book/reference/{reference}
