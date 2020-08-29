package com.aaa.dao;

import com.aaa.entity.Salary;
import com.aaa.entity.SysUser;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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
public interface SalaryDao extends BaseMapper<Salary> {
    //1.拿着业务层查出的工号，去查员工信息
    SysUser userList(String userNumber);

    //2.新增
    Integer addBatchSalary(@Param("salaryList") List<Salary> salaryList);

    //3.封装页面数据
    List<HashMap> selectSalaryPage(@Param("role_name") String role_name,@Param("department_name") String department_name,@Param("login_name") String login_name);

    //4。查下首页信息
    HashMap selectRoleNameAndDepart(@Param("roleId") Integer roleId);
}
