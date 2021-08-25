package com.alw.teching_system.service.impl;

import com.alw.teching_system.entity.CourseLevel;
import com.alw.teching_system.mapper.CourseLevelMapper;
import com.alw.teching_system.service.CourseLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CourseLevelServiceImp  implements CourseLevelService {
    @Autowired
    CourseLevelMapper mapper;
    @Override
    public List<CourseLevel> getAllCourseLevel() {
        return mapper.selectList(null);
    }
}
