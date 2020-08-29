package com.aaa.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * @author : bruceli
 * @version :$
 * @date :Created in 2020/8/3 10:58
 * @description : 文件上传服务
 * @modified :
 */
public interface CommonOssService {
    /**
     * 上传文件至阿里云 oss
     *
     * @param file  上传的源文件
     * @return  返回值ossFileUrlBoot oss地址  oldFileName 源文件名称
     * @throws Exception
     */
    Map uploadOss(MultipartFile file) throws Exception;

}
