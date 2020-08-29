package com.aaa.service;

import com.aaa.entity.News;
import com.aaa.dao.NewsDao;
import com.aaa.entity.NewsDto;
import com.aaa.entity.ResultData;
import com.aaa.service.NewsService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author BruceLi
 * @since 2020-07-31
 */
@Service
public class NewsServiceImpl extends ServiceImpl<NewsDao, News> implements NewsService {
    @Autowired
    private NewsDao newsDao;
    //1. 查新闻 信息 包含查询新闻类型
    @Override
    public PageInfo<HashMap> newsInfos(Integer pageSize,Integer pageNum ,String newsTitle, String newsType, String createTime) {
        //开启分页
        PageHelper.startPage(pageNum,pageSize);

        //查出要放入分页内的数据
        List<HashMap> newsList = newsDao.newsInfos(newsTitle,newsType,createTime);
        //将数据放入封装的Page内
        PageInfo<HashMap> pageInfo = new PageInfo<>(newsList);
        return pageInfo;
    }
    //2 .新增
    @Override
    public ResultData addNews(News news) {
        ResultData resultData;
        int result = newsDao.insert(news);
        if (result>0){
            return resultData = new ResultData(true,"新增成功",null);
        }else{
            return resultData = new ResultData(false,"新增失败",null);

        }
    }
    //3.修改
    @Override
    public ResultData updateNews(News news) {
        ResultData resultData;
        int result = newsDao.updateById(news);
        if (result>0){
            return resultData = new ResultData(true,"修改成功",null);
        }else{
            return resultData = new ResultData(false,"修改失败",null);
        }
    }
    //4.根据id查要修改的数据
    @Override
    public News selectNewsById(Integer newsId) {
        News news = newsDao.selectById(newsId);
        return news;
    }
    //5.根据id删除
    @Override
    public ResultData deleteNews(News news) {
        ResultData resultData;
        Integer result = newsDao.updateById(news);
        if(result>0){
            return resultData = new ResultData(true,"删除成功",null);
        }else{
            return resultData = new ResultData(false,"删除失败",null);
        }
    }







}
