package com.aaa.property;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author : bruceli
 * @version :$
 * @date :Created in 2020/8/3 11:01
 * @description :
 * @modified :
 */
@Component
@PropertySource("classpath:projects.properties")
@ConfigurationProperties(prefix = "oss")
public class OssProperties {
    // 阿里云 oss 站点
    private String endpoint;
    //阿里云 oss 资源访问 url
    private String url;
    //阿里云 oss 公钥
    private String accessKeyId;
    //阿里云 oss 私钥
    private String accessKeySecret;
    //阿里云 oss 文件根目录
    private String bucketName;

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public String getAccessKeySecret() {
        return accessKeySecret;
    }

    public void setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
    }

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }
}
