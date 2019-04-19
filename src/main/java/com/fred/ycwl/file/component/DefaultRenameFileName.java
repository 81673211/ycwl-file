package com.fred.ycwl.file.component;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fred.ycwl.file.component.rename.RenameFileName;

/**
 *
 * <b>Description:.</b><br> 
 * @author <b>sil.zhou</b>
 * <br><b>ClassName:</b> 
 * <br><b>Date:</b> 2019/4/19 09:56
 */
@Component
public class DefaultRenameFileName implements RenameFileName {

    @Value("${spring.profiles.active}")
    private String env;

    @Override
    public String rename(String originalFileName) {
        String format = originalFileName.substring(originalFileName.lastIndexOf("."));
        return env + "-" + UUID.randomUUID() + format;
    }
}
