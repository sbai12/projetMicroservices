# 👤 Royale Time - User Management Microservice

This microservice handles user registration, authentication, role-based access control, and user profile management.

---

## 🔧 Technologies Used

- Java 17
- Spring Boot
- Spring Security
- Spring Data JPA
- MySQL
- Keycloak (Authentication & Authorization)
- Maven
- Eureka Client

---

## 🗂️ Features

✅ Register new users  
✅ Login/Logout  
✅ Role-based authorization  
✅ Profile management  
✅ Keycloak integration for security

---

## 🚀 Getting Started

1. Clone the repository
2. Configure `application.properties` with your DB and Keycloak credentials
3. Run the project using your IDE or `mvn spring-boot:run`

---

## 🔁 API Endpoints

| Method | Endpoint               | Description             |
|--------|------------------------|-------------------------|
| POST   | `/users/register`      | Register a new user     |
| POST   | `/users/login`         | Authenticate user       |
| GET    | `/users/profile`       | Get current user info   |
| PUT    | `/users/profile`       | Update user profile     |

---

## ⚙️ Configuration

- Requires Keycloak running
- Connects to MySQL with schema `user_db`
- Registered to Eureka under the name `USER-SERVICE`

---


