package com.aaa.service;

import com.aaa.entity.News;
import com.aaa.entity.NewsDto;
import com.aaa.entity.ResultData;
import com.baomidou.mybatisplus.service.IService;
import com.github.pagehelper.PageInfo;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author BruceLi
 * @since 2020-07-31
 */
public interface NewsService extends IService<News> {

    //1. 查新闻 信息 包含查询新闻类型
    public PageInfo<HashMap> newsInfos(Integer pageSize, Integer pageNum, String newsTitle, String newsType, String createTime);
    //2 .新增
    ResultData addNews(News news);

    //3.修改
    ResultData updateNews(News news);

    //4.根据id查要修改的数据
    News selectNewsById(Integer newsId);

    //5.根据id删除
    ResultData deleteNews(News news);

}
