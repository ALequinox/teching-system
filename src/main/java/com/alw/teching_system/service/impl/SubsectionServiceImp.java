package com.alw.teching_system.service.impl;

import com.alw.teching_system.entity.Subsection;
import com.alw.teching_system.mapper.SubsectionMapper;
import com.alw.teching_system.service.SubsectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class SubsectionServiceImp implements SubsectionService {
    @Autowired
    SubsectionMapper subsectionMapper;


    @Override
    public int updateSubsectionById(Subsection subsection) {
        return subsectionMapper.updateById(subsection);
    }

    @Override
    public List<Subsection> selectAllSubsectionByChId(int chId) {

        Map<String,Object> columnMap = new HashMap<>();
        columnMap.put("is_delete",1);
        columnMap.put("chid",chId);
        return subsectionMapper.selectByMap(columnMap);
    }

    @Override
    public int deleteSubsectionById(int ssid) {
        Subsection subsection = subsectionMapper.selectById(ssid);
        subsection.setIsDelete(false);
        return subsectionMapper.updateById(subsection);
    }

    @Override
    public int addSubsection(Subsection subsection) {
        return subsectionMapper.insertSubsection(subsection);
    }


}
