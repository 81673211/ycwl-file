package com.fred.ycwl.file.component.uploader;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fred.ycwl.file.exception.FileException;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;

/**
 *
 * <b>Description:.</b><br> 
 * @author <b>sil.zhou</b>
 * <br><b>ClassName:</b> 
 * <br><b>Date:</b> 2019/4/17 14:02
 */
@Component("qiniuUploader")
public class QiniuUploader implements Uploader {

    @Value("${qiniu.accessKey}")
    private String accessKey;

    @Value("${qiniu.secretKey}")
    private String secretKey;

    @Value("${qiniu.bucketName}")
    private String bucketName;

    @Override
    public String upload(String fileName, byte[] content) {
        Zone z = Zone.huadong();
        Configuration c = new Configuration(z);
        //创建上传对象
        UploadManager uploadManager = new UploadManager(c);

        try {
            //调用put方法上传
            uploadManager.put(content, fileName, getUpToken());
        } catch (QiniuException e) {
            throw new FileException(e.getMessage());
        }
        return fileName;
    }

    private String getUpToken() {
        //密钥配置
        Auth auth = Auth.create(accessKey, secretKey);
        return auth.uploadToken(bucketName);
    }
}
