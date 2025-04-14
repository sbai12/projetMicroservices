# 🔁 Royale Time - Returns & Exchanges Microservice

Manages return requests, approvals, exchanges, and tracking.

---

## 🔧 Technologies Used

- Java 17
- Spring Boot
- Spring Data JPA
- Kafka/RabbitMQ (for notifications)
- MySQL
- Eureka Client

---

## 🗂️ Features

✅ Submit a return/exchange request  
✅ Track request status  
✅ Approve or reject return  

---

## 🔁 API Endpoints

| Method | Endpoint               | Description                  |
|--------|------------------------|------------------------------|
| POST   | `/returns`             | Submit new return request    |
| GET    | `/returns/{id}`        | Track status                 |
| PUT    | `/returns/{id}`        | Update/approve request       |
| DELETE | `/returns/{id}`        | Cancel return request        |

---

