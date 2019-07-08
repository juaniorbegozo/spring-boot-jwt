# Spring Boot JWT

run with mvn spring-boot:run

To login as admin:
hit POST http://localhost:8080/users/signin
with request body as
{
"username":"Savy Admin",
"password":"S3cuR3 P4ssW0rD"
}


To login as non admin:
hit POST http://localhost:8080/users/signin
with request body as
{
"username":"Best Candidate",
"password":"Team Player"
}

Use response token as Authentication header to hit:
GET /users/list
GET /users/greeting

