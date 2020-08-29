package com.aaa.controller;

import com.aaa.entity.News;
import com.aaa.entity.Newstype;
import com.aaa.service.NewstypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : bruceli
 * @version :$
 * @date :Created in 2020/8/1 16:01
 * @description :
 * @modified :
 */
@RestController
@RequestMapping("newsType")
public class NewstypeController {
    @Autowired
    private NewstypeService newstypeService;
    //1.查所有新闻类型
    @GetMapping("getNewsType")
    public List<Newstype> selectNewsType(){
        return newstypeService.selectNewsTypeOption();
    }
}
