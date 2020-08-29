package com.aaa.dao;

import com.aaa.entity.Promotion;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author BruceLi
 * @since 2020-08-05
 */
@Repository
@Mapper
public interface PromotionDao extends BaseMapper<Promotion> {

    //1.查晋升和部门
    List<HashMap> selectPromotionDepart(String departmentName);
    //2.查晋升和角色
    HashMap selectPromotionRole(Integer promotionId);
}
