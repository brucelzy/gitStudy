package com.aaa.service;

import com.aaa.entity.Rolesalary;
import com.baomidou.mybatisplus.service.IService;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author BruceLi
 * @since 2020-08-05
 */
public interface RolesalaryService extends IService<Rolesalary> {
    //1. 查角色对应其用户的薪资 用户表 角色薪资表
    List<HashMap> userInfoAndRoleSalary();
    //2.查角色名  用户表 角色表
    List<HashMap> userAndRole();
    //3.查角色工资
    Rolesalary selectByRoleId(Integer roleId);

}
