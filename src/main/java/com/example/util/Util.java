package com.example.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

@Service(value = "util1")
@ConfigurationProperties(prefix = "server")    //用于读取yml文件中的值
public class Util {
    private String port;

    private String tomcat;

    public String getPort() {
        return port;
    }

    public String getTomcat() {
        return tomcat;
    }

    public void setTomcat(String tomcat) {
        this.tomcat = tomcat;
    }

    public void setPort(String port) {
        this.port = port;

    }
}
