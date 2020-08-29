package com.aaa.entity;

import com.baomidou.mybatisplus.enums.IdType;
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
@TableName("tb_promotionaudit")
public class Promotionaudit extends Model<Promotionaudit> {

    private static final long serialVersionUID = 1L;

    /**
     * 晋升审核id
     */
    @TableId(value = "promotion_auditid", type = IdType.AUTO)
    private Integer promotionAuditid;
    @TableField("promotion_applyid")
    private Integer promotionApplyid;
    @TableField("agree_userid")
    private Integer agreeUserid;
    private Integer status;


    public Integer getPromotionAuditid() {
        return promotionAuditid;
    }

    public void setPromotionAuditid(Integer promotionAuditid) {
        this.promotionAuditid = promotionAuditid;
    }

    public Integer getPromotionApplyid() {
        return promotionApplyid;
    }

    public void setPromotionApplyid(Integer promotionApplyid) {
        this.promotionApplyid = promotionApplyid;
    }

    public Integer getAgreeUserid() {
        return agreeUserid;
    }

    public void setAgreeUserid(Integer agreeUserid) {
        this.agreeUserid = agreeUserid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    protected Serializable pkVal() {
        return this.promotionAuditid;
    }

    @Override
    public String toString() {
        return "Promotionaudit{" +
        "promotionAuditid=" + promotionAuditid +
        ", promotionApplyid=" + promotionApplyid +
        ", agreeUserid=" + agreeUserid +
        ", status=" + status +
        "}";
    }
}
