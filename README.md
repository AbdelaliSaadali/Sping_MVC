# Spring Boot Web JEE Application

A complete Spring Boot MVC application featuring Product Management and a Medical domain (Patient, Medecin, RendezVous, Consultation), with full CRUD, pagination, search, form validation, Thymeleaf templates, Bootstrap 5 UI, and role-based Spring Security.

## Tech Stack

- **Spring Boot 3.x**
- **Spring Web (MVC)**
- **Spring Data JPA / Hibernate**
- **Spring Security** (role-based, BCrypt)
- **Spring Validation**
- **Thymeleaf** + Layout Dialect
- **Bootstrap 5**
- **Lombok**
- **H2** (dev) / **MySQL** (production profile)

## Project Structure

```
src/main/java/com/example/demo
├── entities/          # JPA entities (Product, Patient, Medecin, RendezVous, Consultation, AppUser, AppRole)
├── repositories/      # Spring Data JPA repositories
├── services/          # Business logic (AccountService)
├── web/               # MVC Controllers
├── security/          # Spring Security configuration & UserDetailsService
└── DemoApplication.java
```

## Features

- **CRUD** for Products, Patients, and Medecins
- **Search** by keyword
- **Pagination**
- **Form validation** with error display
- **Thymeleaf layout** with shared navbar
- **Bootstrap 5** responsive styling
- **Role-based security** (`ROLE_USER`, `ROLE_ADMIN`)
- **Custom login page**
- **Access denied page**
- **BCrypt password encoding**
- **H2 in-memory database** (default) with **MySQL profile** for production

## Getting Started

### Prerequisites

- Java 21+
- Maven 3.9+

### Run with H2 (default)

```bash
./mvnw spring-boot:run
```

App starts at **http://localhost:8080**

H2 Console: **http://localhost:8080/h2-console** (JDBC URL: `jdbc:h2:mem:products-db`)

### Run with MySQL

```bash
./mvnw spring-boot:run -Dspring-boot.run.profiles=mysql
```

Make sure MySQL is running with a database `products-db` on `localhost:3306`.

## Default Users

| Username | Password | Roles |
|----------|----------|-------|
| `user1`  | `1234`   | `ROLE_USER` |
| `admin`  | `1234`   | `ROLE_ADMIN`, `ROLE_USER` |

## Access Control

| Path | Required Role |
|------|---------------|
| `/user/**` | `ROLE_USER` or `ROLE_ADMIN` |
| `/admin/**` | `ROLE_ADMIN` |
| `/login` | Public |

## Sample Data

The application seeds sample data on startup:
- 12 products
- 3 patients
- 2 medecins
- 2 rendez-vous
- 1 consultation
