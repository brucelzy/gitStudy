package com.aaa.fun.dao;

import com.aaa.entity.SysMenu;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 菜单权限表 Mapper 接口
 * </p>
 *
 * @author xiaobu
 * @since 2020-07-30
 */
@Mapper
public interface SysMenuDao extends BaseMapper<SysMenu> {
    List<SysMenu> selectTree(String username);

}
