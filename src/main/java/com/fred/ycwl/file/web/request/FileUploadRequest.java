package com.fred.ycwl.file.web.request;

import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

/**
 *
 * <b>Description:.</b><br> 
 * @author <b>sil.zhou</b>
 * <br><b>ClassName:</b> 
 * <br><b>Date:</b> 2019/4/19 14:40
 */
@Data
public class FileUploadRequest {

    @NotNull
    private MultipartFile file;
}
