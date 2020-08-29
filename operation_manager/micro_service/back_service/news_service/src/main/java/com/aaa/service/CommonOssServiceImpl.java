package com.aaa.service;

import com.aaa.property.OssProperties;
import com.aaa.util.OSSBootUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : bruceli
 * @version :$
 * @date :Created in 2020/8/3 10:58
 * @description :
 * @modified :
 */
@Service
public class CommonOssServiceImpl implements CommonOssService {
    @Autowired
    private OssProperties ossProperties;
    @Override
    public Map uploadOss(MultipartFile file) throws Exception {
        //高依赖版本oss上传工具
        String ossFileUrlBoot = null;
        ossFileUrlBoot = OSSBootUtil.upload(ossProperties,file,"upload/files");
        Map<String,Object> resultMap = new HashMap<>(16);
        resultMap.put("ossFileUrlBoot",ossFileUrlBoot);
        resultMap.put("oldFileName",file.getOriginalFilename());
        return resultMap;
    }
}
