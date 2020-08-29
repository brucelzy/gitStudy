package com.aaa.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.math.BigDecimal;
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
@TableName("tb_rolesalary")
public class Rolesalary extends Model<Rolesalary> {

    private static final long serialVersionUID = 1L;

    /**
     * 角色工资表
     */
    @TableId(value = "rolesalary_id", type = IdType.AUTO)
    private Integer rolesalaryId;
    @TableField("role_id")
    private Integer roleId;
    @TableField("role_salary")
    private BigDecimal roleSalary;
    @TableField("create_userid")
    private Integer createUserid;
    @TableField("create_time")
    private Date createTime;
    private Integer status;


    public Integer getRolesalaryId() {
        return rolesalaryId;
    }

    public void setRolesalaryId(Integer rolesalaryId) {
        this.rolesalaryId = rolesalaryId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public BigDecimal getRoleSalary() {
        return roleSalary;
    }

    public void setRoleSalary(BigDecimal roleSalary) {
        this.roleSalary = roleSalary;
    }

    public Integer getCreateUserid() {
        return createUserid;
    }

    public void setCreateUserid(Integer createUserid) {
        this.createUserid = createUserid;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    protected Serializable pkVal() {
        return this.rolesalaryId;
    }

    @Override
    public String toString() {
        return "Rolesalary{" +
        "rolesalaryId=" + rolesalaryId +
        ", roleId=" + roleId +
        ", roleSalary=" + roleSalary +
        ", createUserid=" + createUserid +
        ", createTime=" + createTime +
        ", status=" + status +
        "}";
    }
}
