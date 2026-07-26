# My Password Manager

A secure password manager built with Java Spring Boot.

## Features

* User authentication
* Password storage
* Password encryption and decryption
* REST API backend
* Database persistence
* Web-based user interface

## Tech Stack

* Java 17
* Spring Boot
* Maven
* Spring Security
* PostgreSQL
* Docker

## Project Status

This project is currently under development.

### Current Progress

* [x] Spring Boot project setup
* [x] Basic application startup
* [x] Landing page
* [x] User registration
* [x] User login
* [x] Password CRUD operations
* [x] AES encryption
* [x] PostgreSQL integration
* [x] JWT authentication
* [x] Docker deployment

#### Backend & Security
* [ ] Redis caching
* [ ] Audit logging
* [ ] Rate limiting (5 failed login attempts, 15-minute lock)
* [ ] Request validation
* [ ] Global exception handling
* [ ] Unit & integration testing

#### API & Database
* [ ] Swagger / OpenAPI documentation
* [ ] Flyway database migrations

#### DevOps & Deployment
* [ ] Docker Compose
* [ ] AWS EC2 deployment
* [ ] Nginx reverse proxy
* [ ] HTTPS (Let's Encrypt SSL)
* [ ] Jenkins CI/CD pipeline
* [ ] Environment variable & secret management

#### Event-Driven Architecture
* [ ] Apache Kafka integration
* [ ] User activity event producer
* [ ] Audit log event consumer

#### Monitoring & Observability
* [ ] Spring Boot Actuator
* [ ] Prometheus metrics
* [ ] Grafana dashboards
* [ ] Structured application logging

## Running the Application

```bash
mvn spring-boot:run
```

The application will be available at:

```
http://localhost:8080
```
