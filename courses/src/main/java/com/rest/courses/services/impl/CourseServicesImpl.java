package com.rest.courses.services.impl;

import com.rest.courses.Repository.CourseRepository;
import com.rest.courses.models.Course;
import com.rest.courses.services.CourseServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CourseServicesImpl implements CourseServices {

    @Autowired
    CourseRepository courseRepository;

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course getCourseById(Long Id) {
        return courseRepository.findById(Id).get();
    }

}
