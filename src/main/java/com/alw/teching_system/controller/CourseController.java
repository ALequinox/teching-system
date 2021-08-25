package com.alw.teching_system.controller;

import com.alw.teching_system.entity.CourseLevel;
import com.alw.teching_system.service.CourseLevelService;
import com.alw.teching_system.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseService courseService;

    @Autowired
    CourseLevelService courseLevelService;

    @GetMapping("/getCourseLevel")
    public List<CourseLevel> getCourseLevel(){
        return courseLevelService.getAllCourseLevel();
    }


}
