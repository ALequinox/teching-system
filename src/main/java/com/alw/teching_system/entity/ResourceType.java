package com.alw.teching_system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value = "resource_type")
public class ResourceType {
    private Integer rtId;
    private String rtName;
    private Date lastTime;
}
