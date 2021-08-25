package com.alw.teching_system.mapper;

import com.alw.teching_system.entity.Course;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CourseMapper extends BaseMapper<Course> {

    /**
     * 插入新的数据，主键通过数据库自增
     * @param course 加入的数据
     * @return 1 插入成功 0 插入失败
     */
    public int insertSelective(Course course);

    public int insertUserAndCourse(Course course);
}
