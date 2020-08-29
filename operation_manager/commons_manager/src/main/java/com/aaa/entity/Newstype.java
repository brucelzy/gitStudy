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
 * @since 2020-07-31
 */
@TableName("tb_newstype")
public class Newstype extends Model<Newstype> {

    private static final long serialVersionUID = 1L;

    /**
     * 新闻类型id
     */
    @TableId(value = "newstype_id", type = IdType.AUTO)
    private Integer newstypeId;
    @TableField("newstype_name")
    private String newstypeName;
    @TableField("newstype_remark")
    private String newstypeRemark;
    private Integer status;


    public Integer getNewstypeId() {
        return newstypeId;
    }

    public void setNewstypeId(Integer newstypeId) {
        this.newstypeId = newstypeId;
    }

    public String getNewstypeName() {
        return newstypeName;
    }

    public void setNewstypeName(String newstypeName) {
        this.newstypeName = newstypeName;
    }

    public String getNewstypeRemark() {
        return newstypeRemark;
    }

    public void setNewstypeRemark(String newstypeRemark) {
        this.newstypeRemark = newstypeRemark;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    protected Serializable pkVal() {
        return this.newstypeId;
    }

    @Override
    public String toString() {
        return "Newstype{" +
        "newstypeId=" + newstypeId +
        ", newstypeName=" + newstypeName +
        ", newstypeRemark=" + newstypeRemark +
        ", status=" + status +
        "}";
    }
}
