package com.fred.ycwl.file.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fred.ycwl.common.exception.BusinessException;
import com.fred.ycwl.common.web.Response;
import com.fred.ycwl.common.web.ResponseCode;

/**
 *
 * <b>Description:.</b><br> 
 * @author <b>sil.zhou</b>
 * <br><b>ClassName:</b> 
 * <br><b>Date:</b> 2019/4/23 10:32
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Response handle(Exception e) {
        LOGGER.warn(String.format("global error, reason: %s", e.getMessage()));
        Response response;
        if (e instanceof BusinessException) {
            BusinessException businessException = (BusinessException) e;
            response = Response.getFailed(businessException.getResponseCode());
        } else {
            response = Response.getFailed(ResponseCode.ERROR_500);
        }
        return response;
    }
}
