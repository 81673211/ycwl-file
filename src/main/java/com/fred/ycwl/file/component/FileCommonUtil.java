package com.fred.ycwl.file.component;

import org.springframework.stereotype.Component;

import com.fred.ycwl.common.exception.BusinessException;
import com.fred.ycwl.file.common.FileResponseCode;

/**
 * 文件通用功能.
 */
@Component
public class FileCommonUtil {

    /**
     * 获取文件扩展名.
     */
    public String getExtension(String fileName) {
        //扩展名起始下标
        int extensionStartLoc = fileName.lastIndexOf('.');
        if (extensionStartLoc <= 0) {
            throw new BusinessException(FileResponseCode.FILE_EXTENSION_ILLEGAL);
        }
        //扩展名
        return fileName.substring(extensionStartLoc + 1);
    }

}
