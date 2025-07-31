package com.example.STUDENT.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long roll;
    private String name;
    private String mark;
    private String subject;

    public Student() {
    }

    public Student(long id, long roll, String name, String mark, String subject) {
        this.id = id;
        this.roll = roll;
        this.name = name;
        this.mark = mark;
        this.subject = subject;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getRoll() {
        return roll;
    }

    public void setRoll(long roll) {
        this.roll = roll;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}


