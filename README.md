# 💳 Royale Time - Payment Microservice

Handles payment processing through multiple gateways (Stripe, PayPal, Crypto).

---

## 🔧 Technologies Used

- Node.js / Spring Boot
- REST APIs
- Payment Gateway SDKs (clicktopay, PayPal)
- Kafka/RabbitMQ
- Eureka Client

---

## 🗂️ Features

✅ Initiate and verify payments  
✅ Support for credit cards, crypto, and bank transfers  
✅ Send confirmation events to Order Service  

---

## 🔁 API Endpoints

| Method | Endpoint             | Description              |
|--------|----------------------|--------------------------|
| POST   | `/payments/initiate` | Start payment process    |
| GET    | `/payments/status`   | Check payment status     |
| POST   | `/payments/webhook`  | Handle gateway callbacks |

---

