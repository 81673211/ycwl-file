package com.fred.ycwl.file;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 *
 * <b>Description:.</b><br> 
 * @author <b>sil.zhou</b>
 * <br><b>ClassName:</b> 
 * <br><b>Date:</b> 2019/4/16 16:10
 */
@SpringBootApplication
@EnableEurekaClient
public class FileServerApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(FileServerApplication.class)
                .web(WebApplicationType.SERVLET)
                .run(args);
    }
}
