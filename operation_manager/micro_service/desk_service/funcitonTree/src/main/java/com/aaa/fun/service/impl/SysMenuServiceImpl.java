package com.aaa.fun.service.impl;


import com.aaa.entity.LayUiTree;
import com.aaa.entity.SysMenu;
import com.aaa.fun.dao.SysMenuDao;
import com.aaa.fun.service.SysMenuService;
import com.aaa.util.TreeUtil;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 菜单权限表 服务实现类
 * </p>
 *
 * @author xiaobu
 * @since 2020-07-30
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuDao, SysMenu> implements SysMenuService {

    @Autowired
    private SysMenuDao sysMenuDao;

    /**
     * description: 获取权限树
     * @param:userid
     * return: java.util.List<com.aaa.entity.LayUiTree>
     */
    @Override
    public List<LayUiTree> selectTree(String username) {
        List<SysMenu> sysMenus = sysMenuDao.selectTree(username);
        //System.out.println(sysMenus);
        List<LayUiTree> layUiTreeList = TreeUtil.fromMenuListToTreeList(sysMenus);
        return layUiTreeList;
    }
}
