package com.alw.teching_system.controller;

import com.alw.teching_system.entity.Message;
import com.alw.teching_system.entity.ResourceType;
import com.alw.teching_system.service.FileUploadService;
import com.alw.teching_system.service.ResourceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@Slf4j
public class ResourceController {

    @Autowired
    ResourceService resourceService;

    @Autowired
    FileUploadService fileUploadService;

    @GetMapping("/resource-type")
    public List<ResourceType> getResourceTypes(){
        return resourceService.queryAllResourceType();
    }

    @PostMapping("/resources")
    public Message uploadResource(@RequestParam("resourceFile")MultipartFile file,
                                  @RequestParam("resourceName") String resourceName,
                                  @RequestParam("resourceType") String resourceType) throws IOException {
        Message message = new Message();
        log.info("上传文件的原始名为={},文件名为={},文件类型为={}",file.getOriginalFilename(),resourceName,resourceType);

        String filePath = fileUploadService.uploadFile(file);

        log.info("文件路径为={}",filePath);

        return null;
    }
}
