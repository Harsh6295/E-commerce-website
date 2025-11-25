🛒 E-Commerce Website – Java Web Application
Technologies: Java | Servlets | JSP | JDBC | MySQL | MVC | Bootstrap | Spring Boot

A complete E-Commerce web application built using Java Servlets, JSP, JDBC, and MySQL, along with a Spring Boot version included for modern implementation.

✨ Features Overview
👤 User Features
Browse all products

View individual product details

Add products to cart

Update/remove cart items

Secure checkout system

User registration & login

Session-based cart handling

🛠 Admin Features
Admin authentication

Add new products

Edit existing products

Delete products

Inventory management

Dedicated admin dashboard (/admin/products)

🧱 Technologies Used
✔ Java Servlet/JSP Version
Java (JDK 11+)

Servlets & JSP

JDBC (PreparedStatement + Transactions)

MySQL

Bootstrap 5 (UI)

Apache Tomcat 9/10

Maven Project Structure

BCrypt password hashing

✔ Spring Boot Version
Spring Boot 3

Spring MVC

Spring Data JPA (Hibernate)

Thymeleaf Templates

H2/MySQL Database Support

📦 Folder Structure
```

ecommerce-java-project
│
├── servlet-version/                  # Main Java Servlet/JSP/JDBC implementation
│   ├── pom.xml
│   ├── db/
│   │   └── schema.sql                # Complete MySQL database schema
│   └── src/
│       ├── main/java/com/example/ecom/
│       │   ├── model/                # Product, User, Cart, Order models
│       │   ├── dao/                  # DBUtil + DAO classes
│       │   └── servlet/              # All servlets (product, cart, admin CRUD)
│       └── main/webapp/
│           ├── admin/                # Admin JSP pages (CRUD)
│           ├── products.jsp
│           ├── product.jsp
│           ├── cart.jsp
│           ├── checkout.jsp
│           └── WEB-INF/web.xml
│
├── springboot-version/               # Optional modern Spring Boot version
│   ├── pom.xml
│   └── src/
│       ├── main/java/com/example/ecom/
│       │   ├── controller/
│       │   ├── model/
│       │   └── repository/
│       └── main/resources/
│           ├── templates/            # Thymeleaf views
│           └── application.properties
│
├── docs/
│   ├── Ecommerce_Project_Presentation.pptx   # Project PPT (for submission)
│   └── ER_Diagram.png (optional)
│
└── README.md
```
Database Setup (MySQL)

Open MySQL Workbench

Open file:

servlet-version/db/schema.sql


Run the script to create:

user_account

product

orders

order_item

cart_item

Open file:

servlet-version/src/main/java/com/example/ecom/dao/DBUtil.java


Update:

private static final String USER = "root";
private static final String PASS = "Harsh@6295";


If my MySQL password is empty:

private static final String PASS = "";

▶️ How to Run the Servlet/JSP Version
✔ 1. Open IntelliJ IDEA

Click Open Project

Select folder: servlet-version/

Let Maven download dependencies

✔ 2. Configure Tomcat

Run → Edit Configurations

Add Tomcat Server → Local

Add Artifact: ecommerce-servlet:war exploded

✔ 3. Build Project
mvn clean package

✔ 4. Start Tomcat

Click Run ▶
Then open:

http://localhost:8080/ecommerce-servlet

▶️ How to Run the Spring Boot Version (Optional)
✔ Steps:
cd springboot-version
mvn spring-boot:run


Then open:

http://localhost:8080/

