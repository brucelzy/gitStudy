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
 * @since 2020-08-03
 */
@TableName("tb_accommodsignout")
public class Accommodsignout extends Model<Accommodsignout> {

    private static final long serialVersionUID = 1L;

    /**
     * 退宿id
     */
    @TableId(value = "signoutaccommodation_id", type = IdType.AUTO)
    private Integer signoutaccommodationId;
    /**
     * 住宿id
     */
    @TableField("accommodation_id")
    private Integer accommodationId;
    private Integer status;


    public Integer getSignoutaccommodationId() {
        return signoutaccommodationId;
    }

    public void setSignoutaccommodationId(Integer signoutaccommodationId) {
        this.signoutaccommodationId = signoutaccommodationId;
    }

    public Integer getAccommodationId() {
        return accommodationId;
    }

    public void setAccommodationId(Integer accommodationId) {
        this.accommodationId = accommodationId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    protected Serializable pkVal() {
        return this.signoutaccommodationId;
    }

    @Override
    public String toString() {
        return "Accommodsignout{" +
        "signoutaccommodationId=" + signoutaccommodationId +
        ", accommodationId=" + accommodationId +
        ", status=" + status +
        "}";
    }
}
