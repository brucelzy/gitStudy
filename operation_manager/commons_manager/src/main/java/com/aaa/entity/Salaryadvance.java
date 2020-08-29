package com.aaa.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author BruceLi
 * @since 2020-08-05
 */
@TableName("tb_salaryadvance")
public class Salaryadvance extends Model<Salaryadvance> {

    private static final long serialVersionUID = 1L;

    /**
     * 提前发放工资
     */
    @TableId("advance_salaryid")
    private Integer advanceSalaryid;
    /**
     * 提前领工资员工
     */
    @TableField("user_id")
    private Integer userId;
    /**
     * 所属部门
     */
    @TableField("department_id")
    private Integer departmentId;
    /**
     * 角色
     */
    @TableField("role_id")
    private Integer roleId;
    /**
     * 结算日期
     */
    @TableField("settle_time")
    private Date settleTime;


    public Integer getAdvanceSalaryid() {
        return advanceSalaryid;
    }

    public void setAdvanceSalaryid(Integer advanceSalaryid) {
        this.advanceSalaryid = advanceSalaryid;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public Date getSettleTime() {
        return settleTime;
    }

    public void setSettleTime(Date settleTime) {
        this.settleTime = settleTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.advanceSalaryid;
    }

    @Override
    public String toString() {
        return "Salaryadvance{" +
        "advanceSalaryid=" + advanceSalaryid +
        ", userId=" + userId +
        ", departmentId=" + departmentId +
        ", roleId=" + roleId +
        ", settleTime=" + settleTime +
        "}";
    }
}
