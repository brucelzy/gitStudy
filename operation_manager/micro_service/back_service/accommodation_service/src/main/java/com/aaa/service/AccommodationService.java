package com.aaa.service;

import com.aaa.entity.Accommodation;
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
 * @since 2020-08-03
 */
public interface AccommodationService extends IService<Accommodation> {
    PageInfo<HashMap> selectAccDept(Integer pageSize, Integer pageNum);
}
