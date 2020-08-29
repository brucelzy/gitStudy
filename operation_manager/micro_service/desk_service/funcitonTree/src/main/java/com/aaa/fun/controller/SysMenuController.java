package com.aaa.fun.controller;


import com.aaa.entity.LayUiTree;
import com.aaa.entity.SysUser;
import com.aaa.fun.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <p>
 * 菜单权限表 前端控制器
 * </p>
 *
 * @author xiaobu
 * @since 2020-07-30
 */
@RequestMapping("sysMenu")
@RestController
public class SysMenuController {

    @Autowired
    private SysMenuService sysMenuService;
    @Autowired
    private RedisTemplate redisTemplate;
    /**
     * description: 异步响应给前台
     * @param:userid
     * return: java.util.List<com.aaa.entity.LayUiTree>
     */
    @RequestMapping("treelist")
    public List<LayUiTree> selecttree(String username){
        return sysMenuService.selectTree(username) ;
    }
}

