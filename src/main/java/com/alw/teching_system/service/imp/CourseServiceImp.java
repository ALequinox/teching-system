package com.alw.teching_system.service.imp;

import com.alw.teching_system.entity.Course;
import com.alw.teching_system.mapper.CourseMapper;
import com.alw.teching_system.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseServiceImp implements CourseService {
    @Autowired
    CourseMapper mapper;

    @Override
    public int deleteCourse(int id) {
        Course course = mapper.selectById(id);
        course.setIsDelete(0);
        return mapper.updateById(course);
    }

    @Override
    public List<Course> selectAllCourse() {
        return mapper.selectList(null);
    }

    @Override
    public int addCourse(Course course) {
        return mapper.insert(course);
    }

    @Override
    public Course selectCourseById(int id) {

        return mapper.selectById(id);
    }

    @Override
    public int updateCourse(Course course) {
        return mapper.updateById(course);
    }
}
