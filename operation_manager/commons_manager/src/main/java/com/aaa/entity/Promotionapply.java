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
@TableName("tb_promotionapply")
public class Promotionapply extends Model<Promotionapply> {

    private static final long serialVersionUID = 1L;

    /**
     * 晋升申请人id
     */
    @TableId(value = "promotion_applyid", type = IdType.AUTO)
    private Integer promotionApplyid;
    @TableField("promotion_id")
    private Integer promotionId;
    @TableField("apply_userid")
    private Integer applyUserid;
    @TableField("apply_name")
    private Integer applyName;
    @TableField("work_name")
    private String workName;
    @TableField("apply_time")
    private Date applyTime;


    public Integer getPromotionApplyid() {
        return promotionApplyid;
    }

    public void setPromotionApplyid(Integer promotionApplyid) {
        this.promotionApplyid = promotionApplyid;
    }

    public Integer getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(Integer promotionId) {
        this.promotionId = promotionId;
    }

    public Integer getApplyUserid() {
        return applyUserid;
    }

    public void setApplyUserid(Integer applyUserid) {
        this.applyUserid = applyUserid;
    }

    public Integer getApplyName() {
        return applyName;
    }

    public void setApplyName(Integer applyName) {
        this.applyName = applyName;
    }

    public String getWorkName() {
        return workName;
    }

    public void setWorkName(String workName) {
        this.workName = workName;
    }

    public Date getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.promotionApplyid;
    }

    @Override
    public String toString() {
        return "Promotionapply{" +
        "promotionApplyid=" + promotionApplyid +
        ", promotionId=" + promotionId +
        ", applyUserid=" + applyUserid +
        ", applyName=" + applyName +
        ", workName=" + workName +
        ", applyTime=" + applyTime +
        "}";
    }
}
