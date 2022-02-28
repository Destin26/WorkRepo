package com.rest.courses.api;

import com.rest.courses.Repository.CourseRepository;
import com.rest.courses.models.Course;
import com.rest.courses.models.CourseResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseResponse {


    private CourseRepository courseRepository;

    @Autowired
    public CourseResponse(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }


    //Constructors
    public CourseResponse() {

    }


    public CourseResponseModel addedCourseDetailsResponse(Course course){
        CourseResponseModel courseAdded = new CourseResponseModel();
        courseAdded.setCourseName(course.getCourseName());
        courseAdded.setCourseCode(course.getCourseCode());

        return courseAdded;
    }

    public List<CourseResponseModel> allCourselist(){
        List<CourseResponseModel> courseList = new ArrayList<>();
        System.out.println("Size of list"+courseRepository.findAll().size());
        for (int i = 0; i < courseRepository.findAll().size(); i++) {
            CourseResponseModel tempModel = new CourseResponseModel();
            tempModel.setCourseName(courseRepository.findAll().get(i).getCourseName());
            tempModel.setCourseCode(courseRepository.findAll().get(i).getCourseCode());
            courseList.add(tempModel);
        }
        return courseList;
    }


}
