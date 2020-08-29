package com.aaa.util;

import com.aaa.property.OssProperties;
import com.aliyun.oss.ClientConfiguration;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.common.auth.DefaultCredentialProvider;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.UUID;

/**
 * fileName:OSSBootUtil
 * description:
 * author:zz
 * createTime:2020/3/20 14:57
 * version:1.0.0
 */
public class OSSBootUtil {
    private OSSBootUtil(){};
    /**
     * oss 工具客户端
     */
    private volatile static OSSClient ossClient = null;
    /**
     * 上传文件至阿里云 OSS
     * 文件上传成功,返回文件完整访问路径
     * 文件上传失败,返回 null
     *
     * @param ossConfig oss 配置信息
     * @param file 待上传文件
     * @param fileDir 文件保存目录
     * @return oss 中的相对文件路径
     */
    public static String upload(OssProperties ossConfig, MultipartFile file, String fileDir){
        initOSS(ossConfig);
        StringBuilder fileUrl = new StringBuilder();
        try {
            //获取后缀  asdfadsfadsfas.jpg  =  .jpg
            String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf('.'));
            //组装新的文件名称   4897984548487-FAKDSFLAJDSFOIUWER.txt
            //String fileName = System.currentTimeMillis() + "-" + UUID.randomUUID().toString().substring(0,18) + suffix;
            String fileName = (new Date()).getTime()  + "-" + UUID.randomUUID().toString().substring(0,18) + suffix;
            //"upload/files" =  "upload/files/"
            if (!fileDir.endsWith("/")) {
                fileDir = fileDir.concat("/");
            }
            // "upload/files/4897984548487-FAKDSFLAJDSFOIUWER.jpg"
            fileUrl = fileUrl.append(fileDir + fileName);

            ossClient.putObject(ossConfig.getBucketName(), fileUrl.toString(), file.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        //"upload/files/4897984548487-FAKDSFLAJDSFOIUWER.jpg"
        // fileUrl.insert   ossConfig.getUrl()=https://aaachenjian.oss-cn-beijing.aliyuncs.com/
        //fileUrl=https://aaachenjian.oss-cn-beijing.aliyuncs.com/upload/files/4897984548487-FAKDSFLAJDSFOIUWER.jpg
        fileUrl = fileUrl.insert(0,ossConfig.getUrl());
        return fileUrl.toString();
    }

    /**
     * 初始化 oss 客户端
     * @param ossConfig
     * @return
     */
    private static OSSClient initOSS(OssProperties ossConfig) {
        if (ossClient == null ) {
            synchronized (OSSBootUtil.class) {
                if (ossClient == null) {
                    ossClient = new OSSClient(ossConfig.getEndpoint(),
                            new DefaultCredentialProvider(ossConfig.getAccessKeyId(), ossConfig.getAccessKeySecret()),
                            new ClientConfiguration());
                }
            }
        }
        return ossClient;
    }

}
