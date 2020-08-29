package com.aaa.service;

import com.aaa.dao.AttendanceDao;
import com.aaa.dao.RolesalaryDao;
import com.aaa.entity.*;
import com.aaa.dao.SalaryDao;
import com.aaa.service.SalaryService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author BruceLi
 * @since 2020-08-05
 */
@Service
public class SalaryServiceImpl extends ServiceImpl<SalaryDao, Salary> implements SalaryService {

    @Autowired
    private SalaryDao salaryDao;
    @Autowired
    private AttendanceService attendanceService;
    @Autowired
    private RolesalaryService rolesalaryService;

    //计算每个员工该发多少薪资的方法
    @Override
    public List<Salary> CalculatingSalary() {
        //1.进行业务处理
        //1.绩效部分  绩效一个月为300元
        // 算打卡次数：
        // 若迟到大于等于5天那么就无绩效,
        // 小于5每次扣绩效的30  30*x
        // 24天无迟到：绩效设置300
        //拿到考勤 等级的工号后，拿着工号去查员工信息，需要信息插入到工资表中
        List<HashMap> listLessFive = attendanceService.selectLaterLessFive();
        List<Attendance> listOutFive = attendanceService.selectLaterOutFivess();
        List<Attendance> listNoLater = attendanceService.selectNoLater();

        //此时工资表中所需要的前四列已经好了
        //然后去根据前四列的roleid去拿到，角色应发工资
        List<Salary> salaryList = new ArrayList<>();



        //查到员工信息后将 部门id 角色id 员工id 取出，再接着计算
        //设置列表存储 迟到超过五次的员工信息
        List<SysUser> userInfoMoreFiveList = new ArrayList<>();
        for (Attendance attendance:listOutFive) {
            String userNumber = attendance.getUserNumber();
            SysUser sysUsers = salaryDao.userList(userNumber);
            userInfoMoreFiveList.add(sysUsers);
            //迟到大于五次   然后 把 奖金 和 绩效 加入 salary
            //调用设值方法
            Salary salary = goToSetBasicSalary(sysUsers);

            //对该打卡迟到大于五次的奖金和绩效存入
            BigDecimal rewards = new BigDecimal(0);
            Integer achieveMents = 0;
            salary.setRewards(rewards);
            salary.setAchievements(achieveMents);
            //将基础信息 和 奖金和绩效  角色薪资  五险一金 个人所得税
            //取出角色薪资  来计算所交的五险一金部分
            BigDecimal shouldSalary = salary.getShouldSalary();
            Double roleSalarys = shouldSalary.doubleValue();
            //五险一金部分
            Double fiveInsurancefund = roleSalarys*0.175;
            salary.setFiveInsurancefund(fiveInsurancefund);
            //交完五险一金后的剩余工资
            Double surplusSalary = roleSalarys - fiveInsurancefund;

            if (surplusSalary<1500.00){

                BigDecimal individualTax = new BigDecimal(0);
                Double value = surplusSalary;
                individualTax = BigDecimal.valueOf(value);
                salary.setIndividualTax(individualTax);
            }else if(surplusSalary>5000.00&&surplusSalary<36000.00){
                surplusSalary = surplusSalary - 5000.00;
                BigDecimal individualTax = new BigDecimal(0);
                Double value = surplusSalary*0.03;
                individualTax = BigDecimal.valueOf(value);
                salary.setIndividualTax(individualTax);
            }else if(surplusSalary>36000.00&&surplusSalary<144000.00){
                surplusSalary = surplusSalary - 5000.00;
                Double value = surplusSalary*0.1 - 2520;
                BigDecimal individualTax = new BigDecimal(0);
                individualTax = BigDecimal.valueOf(value);
                salary.setIndividualTax(individualTax);
            }
            //往salary表中设置实际发放工资
           /* System.out.println(surplusSalary+5000.00);
            System.out.println((salary.getIndividualTax()));*/
            surplusSalary = (surplusSalary+5000.00) - ((salary.getIndividualTax()).doubleValue());
            BigDecimal individualTaxs = new BigDecimal(0);
            individualTaxs = BigDecimal.valueOf(surplusSalary);
            salary.setActualSalary(individualTaxs);
            //放时间
            salary.setApplyTime(new Date());
            //放状态
            salary.setStatus(1);
            salaryList.add(salary);

        }
        //设置列表存储 迟到小于五次的员工工号
        List<SysUser> userInfoLessFiveList = new ArrayList<>();
        for (HashMap resultMap:listLessFive) {
           String userNumber = (String) resultMap.get("user_number");
            SysUser sysUsers = salaryDao.userList(userNumber);
            userInfoLessFiveList.add(sysUsers);
            //迟到小于五次   然后 把 奖金 和 绩效 加入 salary
            //因为HashMap中存储的有迟到次数
            //调用设值方法
            Salary salary = goToSetBasicSalary(sysUsers);
            //迟到次数  一次扣30的绩效 绩效一共300 迟到也不给奖金
            Object times =resultMap.get("laterTimes");
            Number numbers = (Number) times;
            Integer laterTimes = numbers.intValue();
            //对该打卡迟到小于五次的奖金和绩效存入
            BigDecimal rewards = new BigDecimal(0);
            Integer achieveMents =(300- (30*laterTimes));
            salary.setRewards(rewards);
            salary.setAchievements(achieveMents);

            //将基础信息 和 奖金和绩效  角色薪资  五险一金 个人所得税
            //取出角色薪资  来计算所交的五险一金部分
            BigDecimal shouldSalary = salary.getShouldSalary();
            Double roleSalarys = shouldSalary.doubleValue();
            //五险一金部分
            Double fiveInsurancefund = roleSalarys*0.175;
            salary.setFiveInsurancefund(fiveInsurancefund);
            //交完五险一金后的剩余工资
            Double surplusSalary = roleSalarys - fiveInsurancefund;

            if (surplusSalary<5000.00){
                surplusSalary = surplusSalary - 5000.00;
                BigDecimal individualTax = new BigDecimal(0.00);
                salary.setIndividualTax(individualTax);
            }else if(surplusSalary>5000.00&&surplusSalary<36000.00){
                surplusSalary = surplusSalary - 5000.00;
                BigDecimal individualTax = new BigDecimal(0);
                Double value = surplusSalary*0.03;
                individualTax = BigDecimal.valueOf(value);
                salary.setIndividualTax(individualTax);
            }else if(surplusSalary>36000.00&&surplusSalary<144000.00){
                surplusSalary = surplusSalary - 5000.00;
                Double value = surplusSalary*0.1 - 2520;
                BigDecimal individualTax = new BigDecimal(0);
                individualTax = BigDecimal.valueOf(value);
                salary.setIndividualTax(individualTax);
            }
            System.out.println((salary.getIndividualTax()).doubleValue());
            //往salary表中设置实际发放工资
            surplusSalary = (surplusSalary+5000.00)- ((salary.getIndividualTax()).doubleValue());
            //加上绩效
            surplusSalary = surplusSalary + salary.getAchievements();

            BigDecimal individualTaxs = new BigDecimal(0);
            individualTaxs = BigDecimal.valueOf(surplusSalary);
            salary.setActualSalary(individualTaxs);
            //放时间
            salary.setApplyTime(new Date());
            //放状态
            salary.setStatus(1);


            salaryList.add(salary);
        }
        //设置列表存储 全勤人员信息
        List<SysUser> userInfoNoLaterList = new ArrayList<>();
        for (Attendance attendance:listNoLater) {
            String userNumber = attendance.getUserNumber();
            SysUser sysUsers = salaryDao.userList(userNumber);
            userInfoNoLaterList.add(sysUsers);


            //无迟到  然后 把 奖金 和 绩效 加入 salary
            //因为HashMap中存储的有迟到次数
            //调用设值方法
            Salary salary = goToSetBasicSalary(sysUsers);
            //对该打卡无迟到的奖金和绩效存入
            BigDecimal rewards = new BigDecimal(500);
            Integer achieveMents = 300;
            salary.setRewards(rewards);
            salary.setAchievements(achieveMents);

            //将基础信息 和 奖金和绩效  角色薪资  五险一金 个人所得税
            //取出角色薪资  来计算所交的五险一金部分
            BigDecimal shouldSalary = salary.getShouldSalary();
            Double roleSalarys = shouldSalary.doubleValue();
            //五险一金部分
            Double fiveInsurancefund = roleSalarys*0.175;
            salary.setFiveInsurancefund(fiveInsurancefund);
            //交完五险一金后的剩余工资
            Double surplusSalary = roleSalarys - fiveInsurancefund;

            if (surplusSalary<1500.00){
                BigDecimal individualTax = new BigDecimal(0);
                Double value = surplusSalary;
                individualTax = BigDecimal.valueOf(value);
                salary.setIndividualTax(individualTax);
            }else if(surplusSalary>5000.00&&surplusSalary<36000.00){
                surplusSalary = surplusSalary - 5000.00;
                BigDecimal individualTax = new BigDecimal(0);
                Double value = surplusSalary*0.03;
                individualTax = BigDecimal.valueOf(value);
                salary.setIndividualTax(individualTax);
            }else if(surplusSalary>36000.00&&surplusSalary<144000.00){
                surplusSalary = surplusSalary - 5000.00;
                Double value = surplusSalary*0.1 - 2520;
                BigDecimal individualTax = new BigDecimal(0);
                individualTax = BigDecimal.valueOf(value);
                salary.setIndividualTax(individualTax);
            }

            //往salary表中设置实际发放工资
            surplusSalary = (surplusSalary+5000.00)- ((salary.getIndividualTax()).doubleValue());
            //加上绩效
            surplusSalary = surplusSalary + salary.getAchievements();
            //加上奖金
            surplusSalary = surplusSalary + 500.00;

            BigDecimal individualTaxs = new BigDecimal(0);
            individualTaxs = BigDecimal.valueOf(surplusSalary);
            salary.setActualSalary(individualTaxs);
            //放时间
            salary.setApplyTime(new Date());
            //放状态
            salary.setStatus(1);


            salaryList.add(salary);


        }
//        salaryDao.addBatchSalary(salaryList);
        return salaryList;
    }
   /* @Override
    @Scheduled(cron = "0 1 0 0 * ? *")
    public Integer addBatchSalary(List<Salary> list) {
       int result =  salaryDao.addBatchSalary(list);
       if (result>0){
           System.out.println("新增成功");
       }else {
           System.out.println("新增失败");
       }
       return result;
    }*/



    //salary的设值方法
        public  Salary goToSetBasicSalary(SysUser sysUsers){
            //2.获取到一个员工对象后，将其roleid取出，去查下对应薪资
            Integer roleId = sysUsers.getRoleId();
            Rolesalary rolesalary = rolesalaryService.selectByRoleId(roleId);
            //3.将对应薪资 和 其他信息放入Salary实体
            Salary salary = new Salary();
            salary.setDepartmentId(sysUsers.getDepartmentId());
            salary.setRoleId(sysUsers.getRoleId());
            salary.setUserId(sysUsers.getUserId());
            //角色工资
           // System.out.println("角色工资："+rolesalary.getRoleSalary());
            salary.setShouldSalary(rolesalary.getRoleSalary());
            return salary;
        }
        //查页面数据
    @Override
    public PageInfo<HashMap> selectSalaryInfos(Integer pageSize,Integer pageNum,String role_name,String department_name,String login_name) {
        //1 开启分页
        PageHelper.startPage(pageNum,pageSize);
        //2.查分页的填充数据

        List<HashMap> resultMap = salaryDao.selectSalaryPage(role_name,department_name,login_name);
        //3.放入数据
        PageInfo<HashMap> pageInfo = new PageInfo<>(resultMap);
        return pageInfo;
    }

    @Override
    public HashMap selectRoleNameAndDepart(Integer roleId) {
        return salaryDao.selectRoleNameAndDepart(roleId);
    }


}
