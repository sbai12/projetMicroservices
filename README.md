# 📦 Royale Time - Order Management Microservice

This service handles order creation, payment status updates, and delivery tracking.

---

## 🔧 Technologies Used

- Java 17
- Spring Boot
- Spring Data JPA
- MySQL
- Eureka Client
- Kafka or RabbitMQ (for events)

---

## 🗂️ Features

✅ Create & manage orders  
✅ Update order status  
✅ Track shipping  
✅ Integration with Payment & Product Services

---

## 🚀 Getting Started

1. Clone this repo
2. Setup DB in `application.properties`
3. Run using Maven or your IDE

---

## 🔁 API Endpoints

| Method | Endpoint           | Description           |
|--------|--------------------|-----------------------|
| POST   | `/orders`          | Create new order      |
| GET    | `/orders/{id}`     | Get order details     |
| PUT    | `/orders/{id}`     | Update status         |
| DELETE | `/orders/{id}`     | Cancel order          |

---

