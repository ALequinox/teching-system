package com.alw.teching_system.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value = "course_level")
public class CourseLevel {
    @TableId
    private Integer levelId;
    private String levelName;
    private Date lastTime;

}
