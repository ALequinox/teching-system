package com.alw.teching_system.service;

import com.alw.teching_system.entity.Resource;
import com.alw.teching_system.entity.ResourceType;

import java.util.List;

public interface ResourceService {

    public List<ResourceType> queryAllResourceType();

    public int saveResource(Resource resource);
}
