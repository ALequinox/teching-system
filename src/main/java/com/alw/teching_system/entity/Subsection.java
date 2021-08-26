package com.alw.teching_system.entity;

import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Data
@ToString
public class Subsection {
    private Integer ssid;
    private String ssName;
    private Integer chid;
    private Date lastTime;
    private Boolean isDelete;
    private List<Resource> resources;

}
