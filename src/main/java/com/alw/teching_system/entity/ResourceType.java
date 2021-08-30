package com.alw.teching_system.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value = "resource_type")
public class ResourceType {
    @TableId
    private Integer rtId;
    private String rtName;
    private Date lastTime;
}
