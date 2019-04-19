package com.fred.ycwl.file.component.uploader;

/**
 *
 * <b>Description:.</b><br> 
 * @author <b>sil.zhou</b>
 * <br><b>ClassName:</b> 
 * <br><b>Date:</b> 2019/4/17 13:53
 */
public interface Uploader {

    String upload(String fileName, byte[] content);
}
