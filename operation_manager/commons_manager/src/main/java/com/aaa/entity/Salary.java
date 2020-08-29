package com.aaa.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author BruceLi
 * @since 2020-08-05
 */
@TableName("tb_salary")
public class Salary extends Model<Salary> {

    private static final long serialVersionUID = 1L;

    /**
     * 工资表
     */
    @TableId(value = "salary_id", type = IdType.AUTO)
    private Integer salaryId;
    @TableField("department_id")
    private Integer departmentId;
    @TableField("role_id")
    private Integer roleId;
    @TableField("user_id")
    private Integer userId;
    /**
     * 应发工资
     */
    @TableField("should_salary")
    private BigDecimal shouldSalary;
    /**
     * 奖励
     */
    private BigDecimal rewards;
    /**
     * 五险一金
     */
    @TableField("five_insurancefund")
    private Double fiveInsurancefund;
    /**
     * 个人所得税
     */
    @TableField("individual_tax")
    private BigDecimal individualTax;
    /**
     * 实发工资
     */
    @TableField("actual_salary")
    private BigDecimal actualSalary;
    /**
     * 绩效
     */
    private Integer achievements;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @TableField("apply_time")
    private Date applyTime;

    private Integer status;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSalaryId() {
        return salaryId;
    }

    public void setSalaryId(Integer salaryId) {
        this.salaryId = salaryId;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public BigDecimal getShouldSalary() {
        return shouldSalary;
    }

    public void setShouldSalary(BigDecimal shouldSalary) {
        this.shouldSalary = shouldSalary;
    }

    public BigDecimal getRewards() {
        return rewards;
    }

    public void setRewards(BigDecimal rewards) {
        this.rewards = rewards;
    }

    public Double getFiveInsurancefund() {
        return fiveInsurancefund;
    }

    public void setFiveInsurancefund(Double fiveInsurancefund) {
        this.fiveInsurancefund = fiveInsurancefund;
    }

    public BigDecimal getIndividualTax() {
        return individualTax;
    }

    public void setIndividualTax(BigDecimal individualTax) {
        this.individualTax = individualTax;
    }

    public BigDecimal getActualSalary() {
        return actualSalary;
    }

    public void setActualSalary(BigDecimal actualSalary) {
        this.actualSalary = actualSalary;
    }

    public Integer getAchievements() {
        return achievements;
    }

    public void setAchievements(Integer achievements) {
        this.achievements = achievements;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.salaryId;
    }

    @Override
    public String toString() {
        return "Salary{" +
        "salaryId=" + salaryId +
        ", departmentId=" + departmentId +
        ", roleId=" + roleId +
        ", userId=" + userId +
        ", shouldSalary=" + shouldSalary +
        ", rewards=" + rewards +
        ", fiveInsurancefund=" + fiveInsurancefund +
        ", individualTax=" + individualTax +
        ", actualSalary=" + actualSalary +
        ", achievements=" + achievements +
        ", applyTime=" + applyTime +
        "}";
    }
}
