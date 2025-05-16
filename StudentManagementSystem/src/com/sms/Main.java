package com.sms;

import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== Student Management System ===");

        // Login System
        System.out.print("Enter username: ");
        String username = sc.nextLine();

        System.out.print("Enter password: ");
        String password = sc.nextLine();

        if (!Login.validate(username, password)) {
            System.out.println("Invalid username or password. Exiting...");
            return;
        }

        System.out.println("\nLogin successful!\n");

        int choice;
        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Export to Excel");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    exportData();
                    break;
                case 4:
                    System.out.println("Exiting system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 4);
    }

    private static void addStudent() {
        System.out.println("\n--- Add Student ---");
        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Course: ");
        String course = sc.nextLine();

        System.out.print("Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        Student s = new Student();
        s.setName(name);
        s.setCourse(course);
        s.setAge(age);

        int status = StudentDAO.save(s);
        if (status > 0) {
            System.out.println("Student added successfully!");
        } else {
            System.out.println("Failed to add student.");
        }
    }

    private static void viewStudents() {
        System.out.println("\n--- All Students ---");
        List<Student> list = StudentDAO.getAllStudents();
        for (Student s : list) {
            System.out.println("ID: " + s.getId() + ", Name: " + s.getName()
                    + ", Course: " + s.getCourse() + ", Age: " + s.getAge());
        }
    }

    private static void exportData() {
        System.out.println("\n--- Export to Excel ---");
        List<Student> list = StudentDAO.getAllStudents();
        System.out.print("Enter file path to export (e.g., D:\\\\students.xlsx): ");
        String path = sc.nextLine();

    }
}
