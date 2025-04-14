# 🚚 Royale Time - Livraison (Shipping) Microservice

This microservice manages the shipping and delivery operations of the Royale Time platform. It handles assigning delivery status, tracking packages, and integrating with external logistics services.

---

## 🔧 Technologies Used

- Java 17
- Spring Boot
- Spring Data JPA
- MySQL / PostgreSQL
- Kafka or RabbitMQ (for asynchronous updates)
- Eureka Client
- REST APIs

---

## 🗂️ Features

✅ Manage delivery creation & updates  
✅ Assign delivery personnel (optional)  
✅ Track order shipment status  
✅ Integrate with order and return services for updates  
✅ Notify other services on status changes

---

## 🚀 Getting Started

1. Clone this microservice
2. Configure `application.properties` with your database and Kafka/Eureka settings
3. Run using your IDE or with `mvn spring-boot:run`

---

## 📦 Delivery Entity Fields

- `id` : Unique delivery ID  
- `orderId` : Linked order ID  
- `address` : Delivery address  
- `deliveryDate` : Expected delivery date  
- `status` : Delivery status (`PENDING`, `IN_TRANSIT`, `DELIVERED`, `FAILED`)  
- `trackingNumber` : Tracking number (if using external logistics)

---

## 🔁 API Endpoints

| Method | Endpoint               | Description                        |
|--------|------------------------|------------------------------------|
| POST   | `/delivery`            | Create a new delivery              |
| GET    | `/delivery/{id}`       | Get delivery by ID                 |
| GET    | `/delivery/order/{oid}`| Get delivery by order ID           |
| PUT    | `/delivery/{id}`       | Update delivery status or details  |
| DELETE | `/delivery/{id}`       | Cancel a delivery                  |

---

## 🧩 Integration

This service subscribes to:

- **OrderService**: to receive new orders for delivery  
- **ReturnService**: for pickup of returned items (optional)

And publishes delivery events back via Kafka/RabbitMQ topics like:

- `delivery.created`
- `delivery.status.updated`

---

## ⚙️ Configuration

- Runs as a Eureka client under `DELIVERY-SERVICE`  
- Kafka topics must be configured in `application.properties`  
- Connects to `delivery_db` schema in MySQL/PostgreSQL

---
