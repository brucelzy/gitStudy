package com.aaa.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * fileName: UserService.java
 * description: 
 * author: ygh
 * createTime: 2020/8/2 14:51
 */
@FeignClient(name = "singleLoginService")
public interface UserService {

    /**
     * 验证token是否正确（远程调用）
     * @param:acessToke
     */
    @RequestMapping("/slss/token")
    boolean  checkToken(@RequestParam("acessToken") String acessToken);
}
