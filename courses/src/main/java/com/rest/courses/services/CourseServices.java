package com.rest.courses.services;

import java.util.List;

import com.rest.courses.models.Course;


public interface CourseServices {

    List<Course> getAllCourses();
    Course saveCourse(Course course);
    Course getCourseById(Long Id);

}
