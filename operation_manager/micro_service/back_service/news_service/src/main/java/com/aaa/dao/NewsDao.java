package com.aaa.dao;

import com.aaa.entity.News;
import com.aaa.entity.NewsDto;
import com.aaa.entity.ResultData;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author BruceLi
 * @since 2020-07-31
 */
@Mapper
@Repository
public interface NewsDao extends BaseMapper<News> {

    //1. 查新闻 信息 包含查询新闻类型
    List<HashMap> newsInfos(@Param("newsTitle") String newsTitle,@Param("newsType") String newsType,@Param("createTime") String createTime);

    //2. 新增新闻信息









}
