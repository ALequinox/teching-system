package com.alw.teching_system.mapper;

import com.alw.teching_system.entity.Subsection;
import com.alw.teching_system.service.SubsectionService;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SubsectionMapper extends BaseMapper<Subsection> {

    public int insertSubsection(Subsection subsection);
}
