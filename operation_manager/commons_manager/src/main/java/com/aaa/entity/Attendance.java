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
@TableName("tb_attendance")
public class Attendance extends Model<Attendance> {

    private static final long serialVersionUID = 1L;

    /**
     * 考勤表id
     */
    @TableId(value = "attendance_id", type = IdType.AUTO)
    private Integer attendanceId;
    @TableField("user_number")
    private String userNumber;
    @TableField("user_name")
    private String userName;
    @TableField("department_id")
    private Integer departmentId;
    /**
     * 打卡时间
     */
    @TableField("punchclock_time")
    private Date punchclockTime;
    /**
     * 打卡状态
     */
    private Integer status;


    public Integer getAttendanceId() {
        return attendanceId;
    }

    public void setAttendanceId(Integer attendanceId) {
        this.attendanceId = attendanceId;
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

    public Date getPunchclockTime() {
        return punchclockTime;
    }

    public void setPunchclockTime(Date punchclockTime) {
        this.punchclockTime = punchclockTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    protected Serializable pkVal() {
        return this.attendanceId;
    }

    @Override
    public String toString() {
        return "Attendance{" +
        "attendanceId=" + attendanceId +
        ", userNumber=" + userNumber +
        ", userName=" + userName +
        ", departmentId=" + departmentId +
        ", punchclockTime=" + punchclockTime +
        ", status=" + status +
        "}";
    }
}
