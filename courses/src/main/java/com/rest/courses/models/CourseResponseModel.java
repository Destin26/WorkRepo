package com.rest.courses.models;

import org.springframework.stereotype.Component;

@Component
public class CourseResponseModel {

    private String courseName;
    private Integer courseCode;

    public CourseResponseModel() {
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(Integer courseCode) {
        this.courseCode = courseCode;
    }
}
