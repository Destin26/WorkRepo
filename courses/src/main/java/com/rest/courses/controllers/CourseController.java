package com.rest.courses.controllers;

import com.rest.courses.models.Course;
import com.rest.courses.models.Student;
import com.rest.courses.services.CourseServices;
import com.rest.courses.services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
public class CourseController {


    private CourseServices courseServices;

    private StudentServices studentServices;

    @Autowired
    public CourseController(CourseServices courseServices,StudentServices studentServices){
        this.courseServices = courseServices;
        this.studentServices = studentServices;
    }

    @PostMapping()
    public Course addCourse(@RequestBody Course course){
        courseServices.saveCourse(course);
        return course;

        //change Course to CourseResponse
    }

    @GetMapping()
    public List<Course> allCourses(){
        return courseServices.getAllCourses();
    }

    @PutMapping("/{courseId}/student/{studentId}")
    public Course enrollStudentToCourse(@PathVariable Long courseId,
                                 @PathVariable Long studentId){
        Course course = courseServices.getCourseById(courseId);
        Student student = studentServices.getStudentById(studentId);
        course.enrollStudent(student);

        return courseServices.saveCourse(course);
    }


}
