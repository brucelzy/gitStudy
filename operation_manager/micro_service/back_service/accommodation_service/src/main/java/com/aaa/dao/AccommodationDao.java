package com.aaa.dao;

import com.aaa.entity.Accommodation;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author BruceLi
 * @since 2020-08-03
 */
@Mapper
@Repository
public interface AccommodationDao extends BaseMapper<Accommodation> {
    List<HashMap> selectAccDept();
}
