package com.aaa.fun.service;

import com.aaa.entity.LayUiTree;
import com.aaa.entity.SysMenu;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * 菜单权限表 服务类
 * </p>
 *
 * @author xiaobu
 * @since 2020-07-30
 */
public interface SysMenuService extends IService<SysMenu> {
    public List<LayUiTree> selectTree(String username);

}
