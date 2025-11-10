# Student-Management-System
The Student Management System is a desktop-based application developed using Java Swing for the user interface and MySQL for backend data storage. The purpose of this system is to simplify the process of managing student records efficiently and securely, making it ideal for schools, colleges, or coaching institutions.

This application allows administrators to add, view, update, and delete student information such as Name, Course, and Age. It offers a user-friendly interface and provides real-time interaction with the database to ensure that the data remains consistent and accurate

🎯 Objectives:
To create a simple and intuitive GUI for managing student data.

To store and retrieve student details from a database.

To enable CRUD operations (Create, Read, Update, Delete).

To demonstrate database connectivity using JDBC.

🔧 Technologies Used:
Programming Language: Java (JDK 8+)

GUI Framework: Java Swing (AWT/Swing)

Database: MySQL

Database Connectivity: JDBC

IDE: Eclipse

🧩 Modules/Features:
Module	Description
Add Student	Insert new student records into the database.
View Students	Display all student data in a table format (optional).
Update Student	Modify existing student information (optional extension).
Delete Student	Remove student records (optional extension).
Export to Excel	Export the student data to an Excel file (optional).

🖥️ User Interface (UI):
Simple form with labeled fields: Name, Course, Age

“Add Student” button submits data to the database

Form resets automatically on successful data submission


🗄️ Database Schema:

CREATE DATABASE studentdb;

USE studentdb;

CREATE TABLE students (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    course VARCHAR(100),
    age INT
);

CREATE TABLE admin (
    username VARCHAR(50) PRIMARY KEY,
    password VARCHAR(50)
);

INSERT INTO admin VALUES ('admin', 'admin123');

CREATE TABLE students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    course VARCHAR(50),
    age INT
);

StudentManagementSystem/
├── src/com/sms/
│   ├── DBConnection.java
│   ├── Student.java
│   ├── StudentDAO.java
│   ├── Login.java
│   ├── StudentManagement.java
│   ├── ExportToExcel.java
│   └── Main.java
