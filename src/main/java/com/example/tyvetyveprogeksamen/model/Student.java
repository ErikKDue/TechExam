package com.example.tyvetyveprogeksamen.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int studentId;

    private String name;
    private String email;

    @ManyToOne
    @JsonManagedReference
    private Supervisor supervisor;

    public Student(String name, String email){
        this.name = name;
        this.email = email;
    }

    public Student(){}

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getStudentId() {
        return studentId;
    }

    public Supervisor getSupervisor() {
        return supervisor;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setSupervisor(Supervisor supervisor) {
        this.supervisor = supervisor;
    }
}
