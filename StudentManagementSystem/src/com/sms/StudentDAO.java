package com.sms;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    public static int save(Student s) {
        int status = 0;
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("INSERT INTO students(name, course, age) VALUES (?, ?, ?)");
            ps.setString(1, s.getName());
            ps.setString(2, s.getCourse());
            ps.setInt(3, s.getAge());
            status = ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return status;
    }

    public static List<Student> getAllStudents() {
        List<Student> list = new ArrayList<>();
        try {
            Connection con = DBConnection.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM students");
            while (rs.next()) {
                Student s = new Student();
                s.setId(rs.getInt("id"));
                s.setName(rs.getString("name"));
                s.setCourse(rs.getString("course"));
                s.setAge(rs.getInt("age"));
                list.add(s);
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    // Add update, delete, search by ID...
}
