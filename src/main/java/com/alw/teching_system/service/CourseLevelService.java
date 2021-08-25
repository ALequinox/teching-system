package com.alw.teching_system.service;

import com.alw.teching_system.entity.CourseLevel;

import java.util.List;

public interface CourseLevelService {

    /**
     * 查询全部课程等级
     * @return
     */
    public List<CourseLevel> getAllCourseLevel();
}
