package com.attendance.entity;

import jakarta.persistence.*;

@Entity
@Table(name="attendance")
public class Attendance {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private int studentId;

    private String studentName;

    private String date;

    private String status;


    public Attendance() {

    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public int getStudentId() {
        return studentId;
    }


    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }


    public String getStudentName() {
        return studentName;
    }


    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }


    public String getDate() {
        return date;
    }


    public void setDate(String date) {
        this.date = date;
    }


    public String getStatus() {
        return status;
    }


    public void setStatus(String status) {
        this.status = status;
    }

}