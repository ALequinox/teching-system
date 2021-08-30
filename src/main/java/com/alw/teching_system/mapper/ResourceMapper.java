package com.alw.teching_system.mapper;

import com.alw.teching_system.entity.Resource;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ResourceMapper extends BaseMapper<Resource> {

     int insertResource(Resource resource);
}
