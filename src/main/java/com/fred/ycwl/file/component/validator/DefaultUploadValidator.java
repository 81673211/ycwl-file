package com.fred.ycwl.file.component.validator;

import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.fred.ycwl.common.exception.BusinessException;
import com.fred.ycwl.file.common.FileExtensionEnum;
import com.fred.ycwl.file.common.FileResponseCode;
import com.fred.ycwl.file.component.FileCommonUtil;

/**
 *
 * <b>Description:.</b><br> 
 * @author <b>sil.zhou</b>
 * <br><b>ClassName:</b> 
 * <br><b>Date:</b> 2019/4/18 14:14
 */
@Component
public class DefaultUploadValidator extends AbstractUploadValidator {

    //文件名正则匹配规则,只能包含中文字母和数字
    private static final Pattern PATTERN = Pattern.compile("^[\\u4e00-\\u9fa5_a-zA-Z0-9]+$");

    @Autowired
    private FileCommonUtil fileCommonUtil;

    @Override
    protected void checkNull(MultipartFile multipartFile) {
        if (multipartFile == null || multipartFile.isEmpty()) {
            throw new BusinessException(FileResponseCode.MULTIPART_FILE_NULL);
        }
    }

    @Override
    protected void checkFileName(MultipartFile multipartFile) {
        String originalFilename = multipartFile.getOriginalFilename();
        if (StringUtils.isBlank(originalFilename)) {
            throw new BusinessException(FileResponseCode.MULTIPART_FILE_NAME_BLANK);
        }
        String filename = originalFilename.substring(0, originalFilename.lastIndexOf('.'));
        if (!PATTERN.matcher(filename).matches()) {
            throw new BusinessException(FileResponseCode.MULTIPART_FILE_NAME_ILLEGAL);
        }
    }

    @Override
    protected void checkFileType(MultipartFile multipartFile) {
        String extension = fileCommonUtil.getExtension(multipartFile.getOriginalFilename());
        FileExtensionEnum[] values = FileExtensionEnum.values();
        for (FileExtensionEnum value : values) {
            if (value.toString().equalsIgnoreCase(extension)) {
                return;
            }
        }
        throw new BusinessException(FileResponseCode.MULTIPART_FILE_EXTENSION_ILLEGAL);
    }
}
