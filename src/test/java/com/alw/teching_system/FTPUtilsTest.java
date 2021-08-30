package com.alw.teching_system;

import com.alw.teching_system.uitl.FTPUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.FileCopyUtils;

import java.io.*;

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

    @Test
    void testFileLoad() throws UnsupportedEncodingException {
        InputStream is = ftpUtils.FileLoad("/test/2021/08/30/123456.pdf");
        System.out.println(is);
        //BufferedReader reader = new BufferedReader(new InputStreamReader(is, "gb2312"));
        try {
            //BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\test.pdf"));
            //int copy = FileCopyUtils.copy(reader, writer);
            int copy = FileCopyUtils.copy(is, new FileOutputStream(new File("D:\\test.pdf")));
            System.out.println(copy);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
