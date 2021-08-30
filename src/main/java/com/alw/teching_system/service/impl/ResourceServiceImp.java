package com.alw.teching_system.service.impl;

import com.alw.teching_system.entity.Resource;
import com.alw.teching_system.entity.ResourceType;
import com.alw.teching_system.mapper.ResourceMapper;
import com.alw.teching_system.mapper.ResourceTypeMapper;
import com.alw.teching_system.service.ResourceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ResourceServiceImp implements ResourceService {

    @Autowired
    ResourceTypeMapper resourceTypeMapper;
    @Autowired
    ResourceMapper resourceMapper;


    @Override
    public List<ResourceType> queryAllResourceType() {

        return resourceTypeMapper.selectList(null);
    }

    @Override
    public int saveResource(Resource resource) {
        return resourceMapper.insertResource(resource);
    }
}
