package com.rest.courses.services;

import com.rest.courses.models.CustomResponses;
import com.rest.courses.models.Student;
import java.util.List;


public interface StudentServices {
    CustomResponses saveStudent(Student student);

    Student getStudentById(Long id);

    List<Student> getAllStudents();
}
