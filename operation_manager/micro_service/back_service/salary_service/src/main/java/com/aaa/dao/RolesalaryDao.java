package com.aaa.dao;

import com.aaa.entity.Rolesalary;
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
public interface RolesalaryDao extends BaseMapper<Rolesalary> {

    //1. 查角色对应其用户的薪资 用户表 角色薪资表
    List<HashMap> userInfoAndRoleSalary();
    //2.查角色名  用户表 角色表
    List<HashMap> userAndRole();
    //3.查角色工资
    Rolesalary selectByRoleId(Integer roleId);

}
