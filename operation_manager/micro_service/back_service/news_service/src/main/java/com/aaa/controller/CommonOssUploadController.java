package com.aaa.controller;

import com.aaa.service.CommonOssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * @author : bruceli
 * @version :$
 * @date :Created in 2020/8/3 15:19
 * @description :
 * @modified :
 */
@RestController
@RequestMapping("commonOSS")
public class CommonOssUploadController {
    @Autowired
    private CommonOssService commonOssService;
    /**
     * create by: BruceLi
     * description: 上传文件至阿里云 oss
     * create time: 2020/8/3 15:20
     *params ：No such property: code for class: Script1
     * @return
     */
    @PostMapping(value = "/upload" , produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> uploadOss(@RequestParam(value = "file") MultipartFile file) throws Exception {
        Map result = commonOssService.uploadOss(file);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        return new ResponseEntity<>(result, httpHeaders, HttpStatus.CREATED);
    }
}
