package com.aaa.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

/**
 * @author : bruceli
 * @version :$
 * @date :Created in 2020/8/1 11:30
 * @description :
 * @modified :
 */
public class NewsDto implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 新闻id
     */
    @TableId(value = "news_id", type = IdType.AUTO)
    private Integer newsId;
    /**
     * 标题
     */
    @TableField("news_title")
    private String newsTitle;
    /**
     * 新闻类型
     */
    @TableField("news_type")
    private Integer newsType;
    /**
     * 新闻介绍
     */
    @TableField("news_introduce")
    private String newsIntroduce;
    /**
     * 添加人
     */
    @TableField("create_username")
    private String createUsername;
    /**
     * 添加时间
     */
    @TableField("create_time")
    private Date createTime;
    /**
     * 添加人id
     */
    @TableField("create_userid")
    private Integer createUserid;
    @TableField("create_usernumber")
    private String createUsernumber;
    @TableField("enclosure_path")
    private String enclosurePath;
    @TableField("enclosure_name")
    private String enclosureName;

    // 新闻类型属性
    private Newstype newstype;

    @Override
    public String toString() {
        return "NewsDto{" +
                "newsId=" + newsId +
                ", newsTitle='" + newsTitle + '\'' +
                ", newsType='" + newsType + '\'' +
                ", newsIntroduce='" + newsIntroduce + '\'' +
                ", createUsername='" + createUsername + '\'' +
                ", createTime=" + createTime +
                ", createUserid=" + createUserid +
                ", createUsernumber='" + createUsernumber + '\'' +
                ", enclosurePath='" + enclosurePath + '\'' +
                ", enclosureName='" + enclosureName + '\'' +
                ", newstype=" + newstype +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public Integer getNewsType() {
        return newsType;
    }

    public void setNewsType(Integer newsType) {
        this.newsType = newsType;
    }

    public String getNewsIntroduce() {
        return newsIntroduce;
    }

    public void setNewsIntroduce(String newsIntroduce) {
        this.newsIntroduce = newsIntroduce;
    }

    public String getCreateUsername() {
        return createUsername;
    }

    public void setCreateUsername(String createUsername) {
        this.createUsername = createUsername;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCreateUserid() {
        return createUserid;
    }

    public void setCreateUserid(Integer createUserid) {
        this.createUserid = createUserid;
    }

    public String getCreateUsernumber() {
        return createUsernumber;
    }

    public void setCreateUsernumber(String createUsernumber) {
        this.createUsernumber = createUsernumber;
    }

    public String getEnclosurePath() {
        return enclosurePath;
    }

    public void setEnclosurePath(String enclosurePath) {
        this.enclosurePath = enclosurePath;
    }

    public String getEnclosureName() {
        return enclosureName;
    }

    public void setEnclosureName(String enclosureName) {
        this.enclosureName = enclosureName;
    }

    public Newstype getNewstype() {
        return newstype;
    }

    public void setNewstype(Newstype newstype) {
        this.newstype = newstype;
    }
}
