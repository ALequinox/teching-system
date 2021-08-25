package com.alw.teching_system.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value = "course")
public class Course {
    @TableId
    private Integer cid;
    private String cName;
    private String cDesc;
    private Integer cLevel;
    private String cLevelName;
    private Date lastTime;
    private Boolean isDelete;
    private Users user;
}
