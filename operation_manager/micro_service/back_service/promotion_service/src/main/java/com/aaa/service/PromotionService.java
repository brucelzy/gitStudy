package com.aaa.service;

import com.aaa.entity.Promotion;
import com.baomidou.mybatisplus.service.IService;
import com.github.pagehelper.PageInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author BruceLi
 * @since 2020-08-05
 */
public interface PromotionService extends IService<Promotion> {
    //1. 查发布晋升页面信息  参数 包括分页信息和 模糊查询
    PageInfo<HashMap> promotionPageInfo(Map map);
}
