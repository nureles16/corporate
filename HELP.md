# Corporate Website Backend

Backend часть корпоративного сайта.

## 🚀 Стек технологий

- Java 17
- Spring Boot
- Spring Security
- JWT Authentication
- PostgreSQL
- JPA / Hibernate
- Maven
- Flyway
- Swagger (OpenAPI)

---

## 📦 Функциональность

### 🔐 Авторизация
- JWT-based authentication
- Регистрация и логин
- Роли:
    - ADMIN — полный доступ (CRUD + управление пользователями)
    - USER — только просмотр опубликованного контента

---

### 📚 Модули

- News (Новости)
- Portfolio (Наши работы)
- Services (Услуги)
- About (О нас)
- Contacts (Контакты)
- Banner (Главная страница)

---

## 🛠 Требования для запуска

- Java 17+
- PostgreSQL
- Maven

---

## ⚙️ Настройка базы данных

Создать базу данных в PostgreSQL:

```sql
CREATE DATABASE corporate_db;
```
В application.yml или application.properties указать:
```
spring.datasource.url=jdbc:postgresql://localhost:5432/corporate_db
spring.datasource.username=postgres
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=validate
spring.jpa.show-sql=true

spring.flyway.enabled=true
```
---

## ▶️ Запуск приложения

Через Maven:
```
mvn clean install
mvn spring-boot:run
```
Или:
```
mvn clean package
java -jar target/corporate-0.0.1-SNAPSHOT.jar
```
---

## 🔐 Авторизация
Регистрация

POST /api/auth/register
```
{
"email": "admin@example.com",
"password": "123456",
"role": "ADMIN"
}
```
Логин

POST /api/auth/login
```
{
"email": "admin@example.com",
"password": "123456"
}
```
Ответ:
```
{
"token": "JWT_TOKEN"
}
```
Использование токена

Добавить в Header:
```
Authorization: Bearer YOUR_JWT_TOKEN
```
---

## 📖 Swagger

Swagger доступен по адресу:

http://localhost:8080/swagger-ui/index.html

---

## 📬 Основные эндпоинты
News
```
GET /api/news

GET /api/news/{id}

POST /api/news (ADMIN)

PUT /api/news/{id} (ADMIN)

DELETE /api/news/{id} (ADMIN)
```
Portfolio
```
GET /api/portfolio

POST /api/portfolio (ADMIN)

PUT /api/portfolio/{id} (ADMIN)

DELETE /api/portfolio/{id} (ADMIN)
```
Services
```
GET /api/services

POST /api/services (ADMIN)

PUT /api/services/{id} (ADMIN)

DELETE /api/services/{id} (ADMIN)
```
Contacts
```
GET /api/contacts

PUT /api/contacts/{id} (ADMIN)
```
---

## 📬 Postman Collection

Файл коллекции находится в папке:

postman/corporate-api.postman_collection.json

Импорт:
1. Открыть Postman
2. Нажать Import
3. Выбрать файл из проекта
---
 
## 🧠 Архитектура

Проект построен по слоистой архитектуре:
```
Controller

Service

Repository

DTO

Mapper

Entity
```
Глобальная обработка ошибок:
```
@ControllerAdvice

NotFoundException

Validation handling
```
---

## 👨‍💻 Автор

Nureles Almazbek uulu

Junior Java Backend Developer