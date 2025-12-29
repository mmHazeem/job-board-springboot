# Job Board API
Ein Showcase-Projekt mit **Spring Boot**, **PostgreSQL**, **JWT Security** und **Swagger**.
Dieses Projekt demonstriert meine Fähigkeiten in der Entwicklung von RESTful APIs, Datenbankdesign, Authentifizierung und Dokumentation.

<<<<<<< HEAD
## Features 
- CRUD für Jobs und Companies 
- REST API mit Swagger-Dokumentation 
- JWT-Authentifizierung für Recruiter & Kandidaten 
- Docker-Deployment 
- Unit- und Integrationstests mit JUnit 5 & Mockito

## Tech Stack 
- **Backend:** Java 17, Spring Boot 3, Spring Security, Hibernate 
- **Datenbank:** PostgreSQL 
- **DevOps:** Docker, Docker Compose, GitHub Actions 
- **Testing:** JUnit 5, Mockito 
=======
## Features
- CRUD für Jobs und Companies
- REST API mit Swagger-Dokumentation
- JWT-Authentifizierung für Recruiter & Kandidaten
- Docker-Deployment
- Unit- und Integrationstests mit JUnit 5 & Mockito

## Tech Stack
- **Backend:** Java 17, Spring Boot 3, Spring Security, Hibernate
- **Datenbank:** PostgreSQL
- **DevOps:** Docker, Docker Compose, GitHub Actions
- **Testing:** JUnit 5, Mockito
>>>>>>> 96feb6c (Job Board API)
- **Dokumentation:** Swagger/OpenAPI

## Projektstruktur
job-board-springboot/
├── src/
│   ├── main/java/com/example/jobboard/
│   │   ├── controller/
│   │   ├── service/
│   │   ├── repository/
│   │   └── model/
│   └── resources/application.yml
├── test/java/com/example/jobboard/
├── Dockerfile
├── docker-compose.yml
├── README.md
└── pom.xml

## Setup & Installation
### Lokale Entwicklung
```bash
# Projekt bauen
mvn clean install

# Anwendung starten
mvn spring-boot:run

## Docker
docker-compose up --build

Swagger UI ist erreichbar unter:
 http://localhost:8080/swagger-ui.html

## Tests
<<<<<<< HEAD
mvn test
=======
mvn test
>>>>>>> 96feb6c (Job Board API)
```
![Build Status](https://github.com/mmHazeem/job-board-springboot/actions/workflows/build.yml/badge.svg)

