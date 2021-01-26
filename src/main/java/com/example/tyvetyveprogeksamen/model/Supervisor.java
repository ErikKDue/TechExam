package com.example.tyvetyveprogeksamen.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name= "supervisors")
public class Supervisor {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int supervisorId;

    private String name;

    @OneToMany(mappedBy = "supervisor")
    @JsonBackReference
    private Set<Student> students;

    public String getName() {
        return name;
    }

    public int getSupervisorId() {
        return supervisorId;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSupervisorId(int supervisorId) {
        this.supervisorId = supervisorId;
    }

    public void setStudents(Set<Student> types) {
        this.students = types;
    }

    public Supervisor(){

    }
}
