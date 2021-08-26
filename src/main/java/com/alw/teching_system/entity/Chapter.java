package com.alw.teching_system.entity;

import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Data
@ToString
public class Chapter {
    private Integer chid;
    private String chName;
    private Integer cid;
    private Date lastTime;
    private Boolean isDelete;
    private List<Subsection> subsections;
}
