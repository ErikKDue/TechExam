package com.example.tyvetyveprogeksamen.repository;

import com.example.tyvetyveprogeksamen.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
