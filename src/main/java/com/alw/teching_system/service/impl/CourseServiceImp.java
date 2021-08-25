package com.alw.teching_system.service.impl;

import com.alw.teching_system.entity.Course;
import com.alw.teching_system.entity.Users;
import com.alw.teching_system.mapper.CourseMapper;
import com.alw.teching_system.mapper.UserMapper;
import com.alw.teching_system.service.CourseService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class CourseServiceImp implements CourseService {
    @Autowired
    CourseMapper mapper;

    @Autowired
    UserMapper userMapper;

    @Override
    public int deleteCourse(int id) {
        Course course = mapper.selectById(id);
        course.setIsDelete(false);
        return mapper.updateById(course);
    }

    @Override
    public List<Course> selectAllCourse(String username) {
        QueryWrapper<Users> wrapper = new QueryWrapper<>();
        wrapper.eq("username",username);
        Users users = userMapper.selectOne(wrapper);
        return mapper.selectByUid(users.getUid());
    }

    @Override
    public int addCourse(Course course) {
        return 0;
    }

    @Override
    public int addCourse(Course course,String username) {
        //添加课程
        int flag = mapper.insertSelective(course);
        QueryWrapper<Users> wrapper = new QueryWrapper<>();
        wrapper.eq("username",username);
        Users users = userMapper.selectOne(wrapper);
        course.setUser(users);
        System.out.println(users);
        flag = mapper.insertUserAndCourse(course);
        //System.out.println(course);
        return flag;
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
