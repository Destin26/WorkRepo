package com.rest.courses.controllers;

import com.rest.courses.models.CourseResponseModel;
import com.rest.courses.api.CourseResponse;
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

    private CourseResponse courseResponse;


    @Autowired
    public CourseController(CourseServices courseServices, StudentServices studentServices, CourseResponse courseResponse){
        this.courseServices = courseServices;
        this.studentServices = studentServices;
        this.courseResponse = courseResponse;
    }

    @PostMapping()
    public CourseResponseModel addCourse(@RequestBody Course course){
        courseServices.saveCourse(course);
        CourseResponseModel addedCourseResponse = courseResponse.addedCourseDetailsResponse(course);
        return addedCourseResponse;
        //change Course to CourseResponse
    }

    @GetMapping()
    public List<CourseResponseModel> allCourses(){
        return courseResponse.allCourselist();
    }

    @PutMapping("/{courseId}/student/{studentId}")
    public String enrollStudentToCourse(@PathVariable Long courseId,
                                 @PathVariable Long studentId){
        Course course = courseServices.getCourseById(courseId);
        Student student = studentServices.getStudentById(studentId);
        course.enrollStudent(student);
        courseServices.saveCourse(course);

        return String.format("Student %s is enrolled in course %s",studentId,course.getCourseName());
    }


}
