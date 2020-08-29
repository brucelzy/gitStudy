package com.aaa.controller;

import com.aaa.entity.ResultData;
import com.aaa.entity.Salary;
import com.aaa.service.SalaryService;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * @author : bruceli
 * @version :$
 * @date :Created in 2020/8/11 16:10
 * @description :
 * @modified :
 */
@RestController
@RequestMapping("salary")
public class SalaryController {
    @Autowired
    private SalaryService salaryService;

    //查页面数据
    @GetMapping("salaryPageInfo")
    public PageInfo<HashMap> salaryPages(@Param("pageSize") Integer pageSize, @Param("pageNum")Integer pageNum ,
                                         @Param("role_name")String role_name, @Param("department_name")String department_name, @Param("login_name")String login_name){

        return salaryService.selectSalaryInfos(pageSize,pageNum,role_name,department_name,login_name);
    }

  /*  @Autowired
    private SalaryService salaryService;

    //进行定时批量新增salary表
    @Scheduled(cron = "0 1 0 0 * ? *")
    public ResultData addBatchSalary(){
        List<Salary> salaryList = salaryService.CalculatingSalary();
        boolean result = salaryService.insertBatch(salaryList);
        if (result){
            System.out.println("新增工资成功");
           return new ResultData(true,"新增工资成功",null);
        }else{
            System.out.println("新增工资失败");
            return new ResultData(false,"新增工资失败",null);
        }
    }*/

  @GetMapping("RoleName")
  public HashMap selectUserInfo( Integer roleId){
      return salaryService.selectRoleNameAndDepart(roleId);
  }

    @Scheduled(cron = "0 0 0 13 * ? ")
    public void testDemo(){
        List<Salary> salaryList = salaryService.CalculatingSalary();
        boolean b = salaryService.insertBatch(salaryList);
        if (b){
            System.out.println("成功了！");
        }else{
            System.out.println("失败了");
        }

    }
}
