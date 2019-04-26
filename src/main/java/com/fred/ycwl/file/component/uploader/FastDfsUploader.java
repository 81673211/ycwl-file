package com.fred.ycwl.file.component.uploader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger LOGGER = LoggerFactory.getLogger(FastDfsUploader.class);

    @Override
    public String upload(String fileName, byte[] content) {
        LOGGER.info("i am FastDFS Uploader");
        return null;
    }
}
