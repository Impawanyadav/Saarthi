# 🏠 Saarthi 

![Java](https://img.shields.io/badge/Java-25-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen)
![MySQL](https://img.shields.io/badge/MySQL-Database-blue)
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-UI-green)
![Status](https://img.shields.io/badge/Status-Active-yellow)

---

## 📌 Overview

Saarthi is a Spring Boot MVC-based web application that connects local users with essential services in their city.

It provides a platform for:

- 🏠 Room & PG listings  
- 👷 Local worker services  
- 🥛 Dairy suppliers  
- 🍱 Lunch / tiffin providers  

---

## 🧩 Modules

### 👤 User Module
- Session-based login system  
- User registration  
- Dashboard access  

### 🏠 Room Module
- Room listing (PG, 1BHK, 2BHK, etc.)  
- Location-based search  
- Likes & availability status  

### 👷 Worker Module
- Local worker listing  
- Professions like electrician, plumber, carpenter, etc.  
- Contact-based service system  

### 🥛 Dairy Module
- Milk/dairy suppliers listing  
- City-based availability  

### 🍱 Lunch Module
- Tiffin / home food providers  
- Menu price system  
- Location-based search  

---
## 📸 Project Screenshots
https://github.com/Impawanyadav/Saarthi/blob/main/images/Screenshot%20(1295).png
images/Screenshot(1296).png
images/Screenshot(1297).png
images/Screenshot(1298).png
images/Screenshot(1299).png
images/Screenshot(1301).png

---
## ⚙️ Tech Stack

- Spring Boot (MVC Architecture)  
- Spring Data JPA (Hibernate ORM)  
- MySQL (Database: project1)  
- Thymeleaf (Server-side UI)  
- HTML, CSS, JavaScript  
- Session-based authentication  
- Spring Security Crypto (Password encryption)  
- Java 25  
## 🗃️ Database Design

Database Name:
```
project1
```

Entities:
- User  
- Room  
- Worker  
- Dairy  
- Lunch  

Relationships:
- One User → Many Rooms  
- One User → Many Workers  
- One User → Many Dairy entries  
- One User → Many Lunch entries  

---

## 🔮 Future Enhancements

- Pagination for listings  
- Spring Security full implementation  
- Role-based access (Admin/User)  
- Admin dashboard  
- Chat system between users  
- Spring AI-based recommendations  

---

## 🚀 How to Run

```bash
git clone https://github.com/your-username/saarthi.git
cd saarthi
```

Configure database in:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/project1
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

Run project:
```bash
mvn spring-boot:run
```

---

## 👨‍💻 Author

**Pawan Yadav**  
Java Backend Developer (Student)
