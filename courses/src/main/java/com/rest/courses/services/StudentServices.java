package com.rest.courses.services;

import com.rest.courses.models.Student;
import java.util.List;


public interface StudentServices {
    Student saveStudent(Student student);

    Student getStudentById(Long id);

    List<Student> getAllStudents();
}
