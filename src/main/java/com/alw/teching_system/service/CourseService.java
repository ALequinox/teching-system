package com.alw.teching_system.service;

import com.alw.teching_system.entity.Course;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CourseService {

    /**
     * 根据id删除
     * @param id
     * @return
     */
    public int deleteCourse(int id);

    /**
     * 查询所有课程
     * @return
     */
    public List<Course> selectAllCourse();

    /**
     * 添加课程
     * @param course
     * @return
     */
    public int addCourse(Course course);

    /**
     * 根据id查询课程信息
     * @param id
     * @return
     */
    public Course selectCourseById(int id);

    /**
     * 更新课程信息
     * @return
     */
    public int updateCourse(Course course);


}
