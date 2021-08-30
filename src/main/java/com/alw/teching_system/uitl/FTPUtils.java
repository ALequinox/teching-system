package com.alw.teching_system.uitl;

import lombok.Data;
import lombok.ToString;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

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

    public boolean FileUploadToFTP(InputStream inputStream, String filePath, String filename){
        FTPClient ftpClient = new FTPClient();
        try {
            //开启被动模式
            ftpClient.enterLocalPassiveMode();

            ftpClient.setDefaultTimeout(10000);

            ftpClient.connect(this.hostname,this.port);

            ftpClient.login(this.username,this.password);

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

            ftpClient.disconnect();

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


}
