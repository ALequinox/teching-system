package com.alw.teching_system.service;


import com.alw.teching_system.entity.Subsection;

import java.util.List;

public interface SubsectionService {
    /**
     * 修改小节
     * @param subsection
     * @return
     */
    public int updateSubsectionById(Subsection subsection);


    /**
     * 查询所有未删除的节
     * @param chId
     * @return
     */
    public List<Subsection> selectAllSubsectionByChId(int chId);


    /**
     * 删除节
     * @param ssid
     * @return
     */
    public int deleteSubsectionById(int ssid);


    /**
     * 添加节
     * @param subsection
     * @return
     */
    public int addSubsection(Subsection subsection);
}
