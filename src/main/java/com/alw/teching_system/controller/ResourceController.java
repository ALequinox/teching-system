package com.alw.teching_system.controller;

import com.alw.teching_system.entity.Message;
import com.alw.teching_system.entity.Resource;
import com.alw.teching_system.entity.ResourceType;
import com.alw.teching_system.service.FileUploadService;
import com.alw.teching_system.service.ResourceService;
import com.alw.teching_system.uitl.FTPUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

@RestController
@Slf4j
public class ResourceController {

    @Autowired
    ResourceService resourceService;

    @Autowired
    FileUploadService fileUploadService;

    @Autowired
    FTPUtils ftpUtils;

    @GetMapping("/resource-type")
    public List<ResourceType> getResourceTypes(){
        return resourceService.queryAllResourceType();
    }

    @PostMapping("/resources")
    public Message uploadResource(@RequestParam("resourceFile")MultipartFile file,
                                  @RequestParam("resourceName") String resourceName,
                                  @RequestParam("ssid") Integer ssid,
                                  @RequestParam("resourceType") Integer resourceType) throws IOException {
        Message message = new Message();
        log.info("上传文件的原始名为={},文件名为={},文件类型为={},章节id={}"
                ,file.getOriginalFilename(),resourceName,resourceType,ssid);
        //file.transferTo(new File("D:\\test.pdf"));

        //上传文件返回文件路径
        String filePath = fileUploadService.uploadFile(file);
        //如果上传成功
        if(StringUtils.hasLength(filePath)){
            Resource resource = new Resource();
            resource.setRid(0);
            resource.setLastTime(new Date());
            resource.setRName(resourceName);
            resource.setRType(resourceType);
            resource.setSsid(ssid);
            resource.setRPath(filePath);
            if (resourceService.saveResource(resource)>0) {
                message.setCode(0);
                message.setMessage("上传成功");
            }else{
                message.setCode(1);
                message.setMessage("上传失败");
                ftpUtils.FileDelete(filePath);
            }
        }else{
            message.setCode(1);
            message.setMessage("上传失败");
        }

        return message;
    }

    @GetMapping("/view-pdf/{path}")
    public void preview(@PathVariable("path") String path,
                        HttpServletResponse response){
       // log.info("需要预览的路径为={}",path);
        path = path.replaceAll("\\*","/");
        log.info("需要预览的路径为={}",path);
        byte[] data = null;
        InputStream is = null;
        try {
            is = ftpUtils.FileLoad(path);
            if(!ObjectUtils.isEmpty(is)){
                int copy = FileCopyUtils.copy(is, response.getOutputStream());
                log.info("文件长度为={}",copy);
                response.getOutputStream().flush();
                response.getOutputStream().close();
            }else{
                throw new FileNotFoundException("文件不存在");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (!ObjectUtils.isEmpty(is)){
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
