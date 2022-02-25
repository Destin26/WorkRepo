package com.rest.courses.services.impl;

import com.rest.courses.Repository.StudentRepository;
import com.rest.courses.models.CustomResponses;
import com.rest.courses.models.Student;
import com.rest.courses.services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentServicesImpl implements StudentServices {

    private final Integer SAVE_SUCESS = 101;
    //private final Integer STUDENT_ALREADY_EXISTS = 104;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CustomResponses customResponses;

    @Override
    public CustomResponses saveStudent(Student student) {
        studentRepository.save(student);
        return new CustomResponses("Save Succesful",SAVE_SUCESS);
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
