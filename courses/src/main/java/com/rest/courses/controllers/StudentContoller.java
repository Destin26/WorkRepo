package com.rest.courses.controllers;


import com.rest.courses.models.CustomResponses;
import com.rest.courses.models.Student;
import com.rest.courses.services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentContoller {

    @Autowired
    StudentServices studentServices;

    @PostMapping("/student/add")
    public CustomResponses addStudent(@RequestBody Student student){
        CustomResponses response = studentServices.saveStudent(student);
        return response;
    }

    @GetMapping("/student/all")
    public List<Student> studentList(){
        return studentServices.getAllStudents();
    }

}
