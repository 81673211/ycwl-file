package com.fred.ycwl.file.component;

import java.io.File;
import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartException;

/**
 * 文件通用功能.
 */
@Component
public class FileCommonUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(FileCommonUtil.class);

    /**
     * 获取文件名.
     */
    public String renameFileName(String uploadPath) {
        int year = Calendar.getInstance().get(Calendar.YEAR);
        File file = new File(uploadPath + year);
        if (!file.exists() && !file.mkdirs()) {
            LOGGER.error("文件目录创建失败");
            throw new MultipartException("文件目录创建失败");
        }
        return year + "/" + System.currentTimeMillis();
    }

    public String getFilePath(String accessPathPrefix) {
        return accessPathPrefix;
    }

    /**
     * 获取文件扩展名.
     */
    public String getExtension(String fileName) {
        //扩展名起始下标
        int extensionStartLoc = fileName.lastIndexOf('.');
        if (extensionStartLoc <= 0) {
            LOGGER.error("文件名格式异常");
            throw new MultipartException("文件名格式异常");
        }
        //扩展名
        return fileName.substring(extensionStartLoc + 1);
    }

}
