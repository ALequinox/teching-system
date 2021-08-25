package com.alw.teching_system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value = "course")
public class Course {
    private Integer cid;
    private String cName;
    private String cDesc;
    private Integer cLevel;
    private Date lastTime;
    private Integer isDelete;


}
