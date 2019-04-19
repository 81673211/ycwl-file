package com.fred.ycwl.file.component.validator;

import org.springframework.web.multipart.MultipartFile;

/**
 *
 * <b>Description:.</b><br> 
 * @author <b>sil.zhou</b>
 * <br><b>ClassName:</b> 
 * <br><b>Date:</b> 2019/4/17 09:28
 */
public abstract class AbstractUploadValidator implements UploadValidator {

    @Override
    public void check(MultipartFile multipartFile) {
        checkNull(multipartFile);
        checkFileName(multipartFile);
        checkFileType(multipartFile);
    }

    /**
     * 检查是否为空
     */
    protected abstract void checkNull(MultipartFile multipartFile);

    /**
     * 检查文件名的合法性
     */
    protected abstract void checkFileName(MultipartFile multipartFile);

    /**
     * 检查文件类型的合法性
     */
    protected abstract void checkFileType(MultipartFile multipartFile);
}
