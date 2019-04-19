package com.fred.ycwl.file.exception;

/**
 *
 * <b>Description:.</b><br> 
 * @author <b>sil.zhou</b>
 * <br><b>ClassName:</b> 
 * <br><b>Date:</b> 2019/4/19 10:24
 */
public class FileException extends RuntimeException {

    public FileException() {
        super();
    }

    public FileException(String message) {
        super(message);
    }

    public FileException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
