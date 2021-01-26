package com.example.tyvetyveprogeksamen.controller;

import com.example.tyvetyveprogeksamen.model.Student;
import com.example.tyvetyveprogeksamen.repository.StudentRepository;
import com.example.tyvetyveprogeksamen.repository.SupervisorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentRepository SRepo;

    @Autowired
    SupervisorRepository SPRepo;

    @GetMapping("/gibStudentsPlz")
    public List<Student> gibStudents(){
        List<Student> studentList = SRepo.findAll();
        return studentList;}

    @GetMapping("/student")
    public Iterable<Student> index(){
        return SRepo.findAll();
    }

    @GetMapping("/")
    public ModelAndView home()
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("studentIndex.html");
        return modelAndView;
    }/*
    public String index(){
        List<Student> listaStuffs = SRepo.findAll();

       //just for testing purposes
        for (Student student:listaStuffs
             ) {
            System.out.println(student.getName());
            System.out.println(student.getSupervisor().getName());

        }
        return "studentIndex.html";
    }*/

    @PostMapping("/create")
    public String create(@RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("superID") int superId){
        System.out.println("Create student hit");
        Student student = new Student(name, email);
        student.setSupervisor(SPRepo.findById(superId).get());

        SRepo.save(student);

        return "studentIndex.html";
    }

    @PostMapping("/delete{id}")
    public String delete(@RequestParam("id") int id){
        System.out.println("Delete hit with "+id);
        SRepo.deleteById(id);

        return "studentIndex.html";
    }

    @PostMapping("/update{id}")
    public String update(@RequestParam("id") int id, @RequestParam("name") String name, @RequestParam("email") String email, @RequestParam("superID") int superId){
        System.out.println("Update hit");
        Student readStudent = SRepo.findById(id).get();
        if(!name.equals("")) {
            readStudent.setName(name);//add checks for null values so you don't need to re-enter
        }
        if(!email.equals("")){readStudent.setEmail(email);}
        if(superId>0){
        readStudent.setSupervisor(SPRepo.findById(superId).get());}
        SRepo.save(readStudent);

        return "studentIndex.html";
    }
}
