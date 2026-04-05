# Spring Cloud Nacos Payment Demo

## Modules
- gateway: Spring Cloud Gateway + Nacos discovery
- payment-service: MySQL + Redis + simple payment API

## Prerequisites
- JDK 17
- Maven 3.9+
- Nacos 2.x running on 127.0.0.1:8848
- MySQL running on 127.0.0.1:3306
- Redis running on 127.0.0.1:6379

## Create database
```sql
CREATE DATABASE IF NOT EXISTS payment_db DEFAULT CHARACTER SET utf8mb4;
```

## Run
From repo root:
```bash
mvn -q -pl payment-service -am spring-boot:run
mvn -q -pl gateway -am spring-boot:run
```

## API
Create payment:
```bash
curl -X POST http://localhost:8080/api/payments \
  -H "Content-Type: application/json" \
  -d '{"orderNo":"ORD-1001","amount":99.50}'
```

Get by id:
```bash
curl http://localhost:8080/api/payments/1
```

Get by orderNo:
```bash
curl http://localhost:8080/api/payments/order/ORD-1001
```
