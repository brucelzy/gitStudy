package com.aaa.entity;

import com.baomidou.mybatisplus.enums.IdType;
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
@TableName("tb_promotion")
public class Promotion extends Model<Promotion> {

    private static final long serialVersionUID = 1L;

    /**
     * 晋升信息id
     */
    @TableId(value = "promotion_id", type = IdType.AUTO)
    private Integer promotionId;
    @TableField("department_id")
    private Integer departmentId;
    @TableField("need_people")
    private Integer needPeople;
    private String describe;
    private String postduty;
    @TableField("work_position")
    private Integer workPosition;
    @TableField("create_time")
    private Date createTime;
    private Integer status;


    public Integer getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(Integer promotionId) {
        this.promotionId = promotionId;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getNeedPeople() {
        return needPeople;
    }

    public void setNeedPeople(Integer needPeople) {
        this.needPeople = needPeople;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getPostduty() {
        return postduty;
    }

    public void setPostduty(String postduty) {
        this.postduty = postduty;
    }

    public Integer getWorkPosition() {
        return workPosition;
    }

    public void setWorkPosition(Integer workPosition) {
        this.workPosition = workPosition;
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
        return this.promotionId;
    }

    @Override
    public String toString() {
        return "Promotion{" +
        "promotionId=" + promotionId +
        ", departmentId=" + departmentId +
        ", needPeople=" + needPeople +
        ", describe=" + describe +
        ", postduty=" + postduty +
        ", workPosition=" + workPosition +
        ", createTime=" + createTime +
        ", status=" + status +
        "}";
    }
}
