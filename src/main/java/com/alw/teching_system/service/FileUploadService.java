package com.alw.teching_system.service;

import com.alw.teching_system.uitl.FTPUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Service
public class FileUploadService {

    private final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    FTPUtils ftpUtils;


    public String uploadFile(MultipartFile file){

        //获取文件后缀名
        String suffix = "";
        String originalFilename = file.getOriginalFilename();
        System.out.println(originalFilename);
        if(StringUtils.hasLength(originalFilename)){
            String[] split = originalFilename.split("\\.");
            //System.out.println(Arrays.toString(split));
            suffix = "."+split[split.length-1];
            originalFilename = split[0];
        }

        //生成新的文件名
        String filename = originalFilename+ UUID.randomUUID().toString()+suffix;
        filename = filename.replaceAll("\\*","-");

        //生成文件路径 使用当前的日期作为文件路径名
        String format = this.format.format(new Date());
        String filePath = "/"+format.replaceAll("-","/");
        String url = "";
        try {
            if (ftpUtils.FileUploadToFTP(file.getInputStream(),filePath,
                    new String(filename.getBytes(StandardCharsets.UTF_8),StandardCharsets.ISO_8859_1))) {
                url += ftpUtils.getBasePath()+filePath+"/"+filename;
                return url;
            }else{
                return url;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return url;
        }
    }

}
