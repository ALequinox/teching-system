package com.alw.teching_system.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;
@Data
@TableName(value = "resource")
public class Resource {
    private Integer rid;
    private String rName;
    private String rPath;
    private Integer ssid;
    private Integer rType;
    private String rtName;
    private Date lastTime;
}
