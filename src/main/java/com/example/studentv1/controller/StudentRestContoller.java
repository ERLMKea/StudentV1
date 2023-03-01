package com.example.studentv1.controller;

import com.example.studentv1.model.Student;
import com.example.studentv1.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
public class StudentRestContoller {

    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/students")
    public List<Student> students() {

        return studentRepository.findAll();
    }

    @GetMapping("/students2")
    public List<Student> students2() {

        return studentRepository.findAll();
    }

    @GetMapping("/teststudent")
    public List<Student> teststudent() {
        Student std = new Student();
        std.setBornDate(LocalDate.now());
        std.setBornTime(LocalTime.now());
        List<Student> lst = studentRepository.findAll();
        std.setName("Autogenerated size=" + lst.size());
        studentRepository.save(std);
        System.out.println("saved");
        return studentRepository.findAll();
    }

}

