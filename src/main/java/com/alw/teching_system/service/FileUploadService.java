package com.alw.teching_system.service;

import com.alw.teching_system.uitl.FTPUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Arrays;

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
            System.out.println(Arrays.toString(split));
            //suffix = "."+split[split.length-1];
        }
//
//        //生成新的文件名
//        String filename = originalFilename+ UUID.randomUUID().toString()+suffix;
//
//        //生成文件路径
//        String format = this.format.format(new Date());
//        String filePath = "/"+format.replaceAll("-","/");
//
//        try {
//            ftpUtils.FileUploadToFTP(file.getInputStream(),filePath,filename);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return filePath+filename;
        return null;
    }

}
