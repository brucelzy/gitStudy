package com.aaa.controller;

import com.aaa.service.PromotionService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : bruceli
 * @version :$
 * @date :Created in 2020/8/12 18:19
 * @description :
 * @modified :
 */
@RestController
@RequestMapping("promotion")
public class PromotionController {

    @Autowired
    private PromotionService promotionService;

    //查页面数据
    @GetMapping("proPage")
    public PageInfo<HashMap> promotionPage(@RequestBody Map map){
        return promotionService.promotionPageInfo(map);
    }

}
