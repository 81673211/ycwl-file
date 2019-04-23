package com.fred.ycwl.file.component.uploader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fred.ycwl.common.exception.BusinessException;
import com.fred.ycwl.file.common.FileResponseCode;
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

    private static final Logger LOGGER = LoggerFactory.getLogger(QiniuUploader.class);

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
            LOGGER.warn("调用七牛云API上传文件失败，原因：{}", e.getMessage());
            throw new BusinessException(FileResponseCode.UPLOAD_FILE_ERROR);
        }
        return fileName;
    }

    private String getUpToken() {
        //密钥配置
        Auth auth = Auth.create(accessKey, secretKey);
        return auth.uploadToken(bucketName);
    }
}
