package com.aaa.service;

import com.aaa.entity.ResultData;
import com.aaa.entity.Salary;
import com.baomidou.mybatisplus.service.IService;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.scheduling.annotation.Scheduled;

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
public interface SalaryService extends IService<Salary> {

    //每个月封装每个salary对象
    List<Salary> CalculatingSalary();

    //1.查页面数据
    PageInfo<HashMap> selectSalaryInfos(@Param("pagaSize") Integer pageSize ,@Param("pageNum") Integer pageNum ,@Param("role_name") String role_name, @Param("department_name") String department_name, @Param("login_name") String login_name);

    //4。查下首页信息
    HashMap selectRoleNameAndDepart(Integer roleId);

}
