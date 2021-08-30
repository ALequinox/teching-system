package com.alw.teching_system.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Data
@ToString
public class Subsection {
    @TableId
    private Integer ssid;
    private String ssName;
    private Integer chid;
    private Date lastTime;
    private Boolean isDelete;
    private List<Resource> resources;

}
