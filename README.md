# Face Recognition Attendance System

A web-based **Face Recognition Attendance System** that automates student attendance using **Java, Spring Boot, MySQL, and OpenCV**.

The system allows students/users to register, captures facial data, recognizes registered faces, and records attendance automatically in the database.

---

## 🔗 Live Demo

### 🌐 Live Application

https://evaluating-newspapers-foam-built.trycloudflare.com/

> **Note:** This demo is currently exposed using a Cloudflare Quick Tunnel. The application must be running on the host computer for the demo URL to remain accessible.

---

# 📌 Project Overview

The **Face Recognition Attendance System** is designed to reduce the time and effort required for manual attendance.

Traditional attendance systems require instructors to manually record attendance. This project uses **facial recognition technology** to identify registered students and automatically record their attendance.

The application provides a web interface connected to a **Spring Boot backend**, **MySQL database**, and **OpenCV face-recognition functionality**.

---

# 🎯 Objectives

- Automate the attendance process.
- Reduce manual attendance work.
- Identify students using facial recognition.
- Store attendance records digitally.
- Maintain student information in a centralized database.
- Provide a simple web-based attendance management system.
- Improve accuracy and reduce duplicate attendance entries.

---

# ✨ Features

## 👤 Student Management

- Add students
- View students
- Update student information
- Delete students
- Search students
- Store student details

## 📸 Face Recognition

- Register student face data
- Capture facial information
- Detect faces using OpenCV
- Recognize registered students
- Automatically identify students

## ✅ Attendance Management

- Automatically mark attendance
- Store attendance date and time
- Prevent duplicate attendance
- View attendance records
- Search attendance records

## 🔐 Authentication

- User login
- User registration
- Authentication-based access
- Logout functionality

## 🗄️ Database

- MySQL database integration
- Student records
- Face-related data
- Attendance records
- User information

## 🌐 Web Application

- Responsive web interface
- Spring Boot REST APIs
- Browser-based access
- Public demo deployment

---

# 🛠️ Technologies Used

## Backend

- Java
- Spring Boot
- Spring MVC
- REST API

## Database

- MySQL
- MySQL Workbench
- JDBC / Spring Data access

## Computer Vision

- OpenCV

## Frontend

- HTML
- CSS
- JavaScript
- Bootstrap

## Development Tools

- IntelliJ IDEA
- Maven
- Git
- GitHub
- MySQL Workbench

---

# 🏗️ System Architecture

```text
                    ┌─────────────────────┐
                    │       User          │
                    │   Web Browser       │
                    └──────────┬──────────┘
                               │
                               ▼
                    ┌─────────────────────┐
                    │    Web Interface    │
                    │ HTML / CSS / JS     │
                    └──────────┬──────────┘
                               │
                               ▼
                    ┌─────────────────────┐
                    │    Spring Boot      │
                    │      Backend        │
                    └──────────┬──────────┘
                               │
              ┌────────────────┼────────────────┐
              │                │                │
              ▼                ▼                ▼
      ┌──────────────┐ ┌──────────────┐ ┌──────────────┐
      │ Authentication│ │   OpenCV     │ │    MySQL     │
      │    Module     │ │Face Detection│ │   Database   │
      └──────────────┘ └──────────────┘ └──────────────┘
                               │
                               ▼
                    ┌─────────────────────┐
                    │ Face Recognition    │
                    │ & Attendance        │
                    └─────────────────────┘

📂 Project Structure

FaceRecognitionAttendance/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── attendance/
│   │   │           ├── controller/
│   │   │           ├── service/
│   │   │           ├── repository/
│   │   │           ├── model/
│   │   │           └── config/
│   │   │
│   │   └── resources/
│   │       ├── application.properties
│   │       ├── static/
│   │       └── templates/
│   │
│   └── test/
│
├── pom.xml
├── mvnw
├── mvnw.cmd
├── .gitignore
└── README.md

🗃️ Database Structure

The system uses MySQL to store application data.

The main database entities are:
Users
   │
   │
   ▼
Students
   │
   │
   ├──────────────► Face Data
   │
   │
   ▼
Attendance

🔄 Attendance Workflow

Student
   │
   ▼
Face Registration
   │
   ▼
Face Data Stored
   │
   ▼
Camera Captures Face
   │
   ▼
Face Detection
   │
   ▼
Face Recognition
   │
   ▼
Student Identified
   │
   ▼
Check Existing Attendance
   │
   ├── Already Marked → No Duplicate Entry
   │
   └── Not Marked
          │
          ▼
   Attendance Recorded
          │
          ▼
      MySQL Database

📸 Face Recognition Process
The system uses OpenCV for facial recognition.
Camera
  ↓
Capture Image
  ↓
Face Detection
  ↓
Face Extraction
  ↓
Feature Comparison
  ↓
Student Identification
  ↓
Attendance Marking

🔌 API Structure

The backend exposes REST APIs for different application functions.
Example API structure:
/api/
│
├── users
│   ├── login
│   └── register
│
├── students
│   ├── GET
│   ├── POST
│   ├── PUT
│   └── DELETE
│
├── attendance
│   ├── GET
│   └── POST
│
└── face
    ├── register
    └── recognize

⚙️ Requirements

Install the following software before running the project:

Java JDK
IntelliJ IDEA
MySQL Server
MySQL Workbench
cloudflared-windows-amd64.exe
OpenCV
Github

🗄️ Database Setup
*Step 1 — Start MySQL

Open MySQL Server / MySQL Workbench.

*Step 2 — Create Database

Example:

CREATE DATABASE attendance;
*Step 3 — Select Database
USE attendance;
*Step 4 — Configure Spring Boot

Open:

src/main/resources/application.properties

Configure your database connection:

spring.datasource.url=jdbc:mysql://localhost:3306/attendance
spring.datasource.username=root
spring.datasource.password=123456

▶️ How to Run the Project
1. Clone Repository
git clone https://github.com/sanjanard11/FaceRecognitionAttendance.git
2. Open in IntelliJ IDEA

Open the cloned project in IntelliJ IDEA.

3. Configure Database

Make sure MySQL is running and the database configuration is correct.

4. Build Project

Using Maven:

./mvnw clean package

On Windows:

mvnw.cmd clean package

🌐 Public Demo

The project can be exposed publicly using Cloudflare Tunnel.

Example:

https://evaluating-newspapers-foam-built.trycloudflare.com/

Run:

cloudflared tunnel --url http://localhost:8080

Cloudflare then provides a public URL.

📱 Application Modules
1. Login
2. Registration
3. Dashboard
4. Student Management
5. Face Registration
6. Face Recognition
7. Attendance
8. Attendance Records
9. Profile
10. Settings
11. Logout


🔒 Security Considerations

Sensitive information should not be stored directly in a public GitHub repository.

Do not commit:

Database passwords
API keys
Secret keys
Private credentials

Use environment variables for production deployments.

Example:

spring.datasource.username=${root}
spring.datasource.password=${123456}


🚀 Deployment

The application can be deployed using:

GitHub
   ↓
Hosting / Server
   ↓
Spring Boot
   ↓
MySQL
   ↓
OpenCV

For development and demonstration, Cloudflare Tunnel can provide temporary public access.

🎯 Advantages
* Reduces manual attendance work.
* Faster attendance recording.
* Digital attendance records.
* Face-based identification.
* Easy student management.
* Centralized database.
* Web-based access.
* Reduces duplicate attendance entries.

🔮 Future Enhancements
* Permanent cloud deployment
* Mobile application
* Email notifications
* SMS notifications
* Attendance analytics
* PDF attendance reports
* Excel export
* Admin dashboard
* Advanced face recognition
* Multiple camera support
* Cloud database integration
* Role-based access control


👩‍💻 Developer

Sanjana R D
Computer Science and Engineering

📄 License

This project is developed for educational and academic purposes.
