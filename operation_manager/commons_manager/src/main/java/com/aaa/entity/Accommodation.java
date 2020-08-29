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
 * @since 2020-08-03
 */
@TableName("tb_accommodation")
public class Accommodation extends Model<Accommodation> {

    private static final long serialVersionUID = 1L;

    /**
     * 住宿信息表id
     */
    @TableId(value = "accommodation_id", type = IdType.AUTO)
    private Integer accommodationId;
    @TableField("user_id")
    private Integer userId;
    @TableField("user_number")
    private String userNumber;
    @TableField("user_name")
    private String userName;
    @TableField("department_id")
    private Integer departmentId;
    @TableField("user_gender")
    private String userGender;
    /**
     * 楼号
     */
    @TableField("floor_num")
    private String floorNum;
    /**
     * 房间号
     */
    @TableField("room_number")
    private String roomNumber;
    /**
     * 入住时间
     */
    @TableField("checkin_time")
    private Date checkinTime;
    private Integer status;


    public Integer getAccommodationId() {
        return accommodationId;
    }

    public void setAccommodationId(Integer accommodationId) {
        this.accommodationId = accommodationId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public String getFloorNum() {
        return floorNum;
    }

    public void setFloorNum(String floorNum) {
        this.floorNum = floorNum;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckinTime() {
        return checkinTime;
    }

    public void setCheckinTime(Date checkinTime) {
        this.checkinTime = checkinTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    protected Serializable pkVal() {
        return this.accommodationId;
    }

    @Override
    public String toString() {
        return "Accommodation{" +
        "accommodationId=" + accommodationId +
        ", userId=" + userId +
        ", userNumber=" + userNumber +
        ", userName=" + userName +
        ", departmentId=" + departmentId +
        ", userGender=" + userGender +
        ", floorNum=" + floorNum +
        ", roomNumber=" + roomNumber +
        ", checkinTime=" + checkinTime +
        ", status=" + status +
        "}";
    }
}
