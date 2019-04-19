package com.fred.ycwl.file.web;

import java.io.IOException;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fred.ycwl.common.web.Response;
import com.fred.ycwl.file.component.rename.RenameFileName;
import com.fred.ycwl.file.component.uploader.Uploader;
import com.fred.ycwl.file.component.validator.UploadValidator;
import com.fred.ycwl.file.web.request.FileUploadRequest;
import com.fred.ycwl.file.web.response.FileUploadDto;

/**
 *
 * <b>Description:.</b><br> 
 * @author <b>sil.zhou</b>
 * <br><b>ClassName:</b> 
 * <br><b>Date:</b> 2019/4/16 16:31
 */
@RestController
@RequestMapping("/file")
public class FileController {

    @Value("${file.store.type}")
    private String fileStoreType;

    @Resource
    private Uploader qiniuUploader;

    @Resource
    private Uploader fastDfsUploader;

    @Autowired
    private UploadValidator validator;

    @Autowired
    private RenameFileName renameFileName;

    @RequestMapping(value = "/hi", method = RequestMethod.GET)
    public String upload(String name) {
        return name + "， " + fileStoreType;
    }

    @PostMapping(value = "/upload")
    public Response<FileUploadDto> upload(FileUploadRequest request) throws IOException {
        MultipartFile multipartFile = request.getFile();
        validator.check(multipartFile);
        FileUploadDto dto = new FileUploadDto();
        dto.setFileName(getUploader().upload(renameFileName.rename(multipartFile.getOriginalFilename()),
                                             multipartFile.getBytes()));
        return Response.getSuccess(dto);
    }

    private Uploader getUploader() {
        return "local".equals(fileStoreType) ? fastDfsUploader : qiniuUploader;
    }

}
