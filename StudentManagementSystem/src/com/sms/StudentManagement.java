package com.sms;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class StudentManagement {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Student Management System");

        JLabel nameLbl = new JLabel("Name:");
        JLabel courseLbl = new JLabel("Course:");
        JLabel ageLbl = new JLabel("Age:");
        JTextField nameField = new JTextField();
        JTextField courseField = new JTextField();
        JTextField ageField = new JTextField();
        JButton saveBtn = new JButton("Add Student");

        nameLbl.setBounds(30, 30, 100, 30);
        nameField.setBounds(130, 30, 200, 30);
        courseLbl.setBounds(30, 80, 100, 30);
        courseField.setBounds(130, 80, 200, 30);
        ageLbl.setBounds(30, 130, 100, 30);
        ageField.setBounds(130, 130, 200, 30);
        saveBtn.setBounds(130, 180, 120, 30);

        
        saveBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Student s = new Student();
                s.setName(nameField.getText());
                s.setCourse(courseField.getText());
                s.setAge(Integer.parseInt(ageField.getText()));

                int status = StudentDAO.save(s);
                if(status > 0) {
                    JOptionPane.showMessageDialog(frame, "Student added successfully!");
                } else {
                    JOptionPane.showMessageDialog(frame, "Error saving student.");
                }
            }
        });

        
        frame.add(nameLbl); frame.add(nameField);
        frame.add(courseLbl); frame.add(courseField);
        frame.add(ageLbl); frame.add(ageField);
        frame.add(saveBtn);
        frame.setSize(400, 300);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     
    }
    
   
}
