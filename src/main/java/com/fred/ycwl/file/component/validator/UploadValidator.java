package com.fred.ycwl.file.component.validator;

import org.springframework.web.multipart.MultipartFile;

/**
 *
 * <b>Description:.</b><br> 
 * @author <b>sil.zhou</b>
 * <br><b>ClassName:</b> 
 * <br><b>Date:</b> 2019/4/17 09:28
 */
public interface UploadValidator {

    void check(MultipartFile multipartFile);
}
