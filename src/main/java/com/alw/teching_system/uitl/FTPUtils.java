package com.alw.teching_system.uitl;

import lombok.Data;
import lombok.ToString;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@Component
@ToString
@Data
@ConfigurationProperties(prefix = "ftp")
public class FTPUtils {

    private String hostname;

    private String username;

    private String password;

    private Integer port = 21;

    private String basePath;

    public FTPClient getConnect(){
        FTPClient ftpClient = new FTPClient();

        try {
            ftpClient.connect(this.hostname,this.port);
            ftpClient.login(this.username,this.password);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ftpClient;
    }

    public void  closeConnect(FTPClient ftpClient){
        try {
            ftpClient.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean FileUploadToFTP(InputStream inputStream, String filePath, String filename){
        FTPClient ftpClient = getConnect();
        //ftpClient.setControlEncoding("utf-8");
        try {
            ftpClient.enterLocalPassiveMode();
            ftpClient.setDefaultTimeout(10000);
            if (!ftpClient.changeWorkingDirectory(this.basePath+filePath)) {
                String[] dirs = filePath.split("/");
                String tempPath = basePath;
                for (String dir : dirs) {
                    if (null == dir || "".equals(dir)) continue;
                    tempPath += "/" + dir;
                    if (!ftpClient.changeWorkingDirectory(tempPath)) {
                        if (!ftpClient.makeDirectory(tempPath)) {
                            return false;
                        } else {
                            ftpClient.changeWorkingDirectory(tempPath);
                        }
                    }
                }

            }

            //设置文件类型
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

            ftpClient.storeFile(filename, inputStream);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }finally {
            closeConnect(ftpClient);
        }
        return true;
    }

    public boolean FileDelete(String filePath){
        FTPClient ftpClient = getConnect();
        try {
            return ftpClient.deleteFile(filePath);

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }finally {
            closeConnect(ftpClient);
        }
    }

    public InputStream FileLoad(String filePath){
        FTPClient ftpClient = getConnect();

        InputStream is = null;
        try {
            int code = ftpClient.getReplyCode();
            System.out.println(FTPReply.isPositiveCompletion(code));
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            is = ftpClient.retrieveFileStream(new String(filePath.getBytes(StandardCharsets.UTF_8),
                    StandardCharsets.ISO_8859_1));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return is;
    }
}
