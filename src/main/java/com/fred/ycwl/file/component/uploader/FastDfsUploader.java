package com.fred.ycwl.file.component.uploader;

import org.springframework.stereotype.Component;

/**
 *
 * <b>Description:.</b><br> 
 * @author <b>sil.zhou</b>
 * <br><b>ClassName:</b> 
 * <br><b>Date:</b> 2019/4/17 14:06
 */
@Component("fastDfsUploader")
public class FastDfsUploader implements Uploader {

    @Override
    public String upload(String fileName, byte[] content) {
        System.out.println("i am FastDFS Uploader");
        return null;
    }
}
