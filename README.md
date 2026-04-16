# Spring Boot Login & Registration System

This is a simple Spring Boot project that implements user registration and login functionality using Thymeleaf for frontend UI. The project uses Bootstrap for styling and does not include Spring Security; authentication is handled manually.

---

## Features
- User Registration (Name, Email, Password)
- User Login (Manual Authentication)
- Email Notification after Registration
- Dynamic UI using Thymeleaf
- Responsive Design using Bootstrap
- MySQL Database Integration
- Simple backend logic (No Spring Security)

---

## Frontend Technologies
- Thymeleaf (Server-side rendering)
- HTML
- Bootstrap 5

Thymeleaf is used to dynamically render data from Spring Boot backend to frontend pages.

---

## Technologies Used
- Java
- Spring Boot
- Spring Data JPA
- MySQL
- Spring Boot Mail
- Thymeleaf
- Bootstrap 5

---

## How It Works

### Registration Flow
- User opens registration page
- Enters name, email, password
- Data is saved into MySQL database
- Welcome email is sent after successful registration

### Login Flow
- User enters email and password
- System validates credentials manually from database
- If correct → user is redirected to home page

---

## 📧 Email Feature
A welcome email is automatically sent to the user after successful registration using Spring Boot Mail service.

---

## Database Configuration

Update `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/your_db_name
spring.datasource.username=your_database_username
spring.datasource.password=your_database_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
