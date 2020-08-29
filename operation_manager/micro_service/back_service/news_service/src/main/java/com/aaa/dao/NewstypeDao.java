package com.aaa.dao;

import com.aaa.entity.Newstype;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

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
public interface NewstypeDao extends BaseMapper<Newstype> {

}
