package com.alw.teching_system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value = "course_level")
public class CourseLevel {
    private int levelId;
    private String levelName;
    private Date lastTime;

}
