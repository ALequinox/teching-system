package com.alw.teching_system;

import com.alw.teching_system.uitl.FTPUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

@SpringBootTest
public class FTPUtilsTest {

    @Autowired
    FTPUtils ftpUtils;

    @Test
    void testProperties(){
        System.out.println(ftpUtils);
    }

    @Test
    void testFileupload(){
        File file = new File("\\D:\\New desktop\\青软\\实习日志8-27.docx");
        boolean b = false;
        try {
            b = ftpUtils.FileUploadToFTP(new FileInputStream(file), "/2021/8/27", "test.docx");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(b);
    }
}
