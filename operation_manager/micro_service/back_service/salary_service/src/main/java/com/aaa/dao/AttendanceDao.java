package com.aaa.dao;

import com.aaa.entity.Attendance;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author BruceLi
 * @since 2020-08-05
 */
@Repository
@Mapper
public interface AttendanceDao extends BaseMapper<Attendance> {

    //1. 点击打卡  前台用户进行新增打卡记录  点击打卡签到  去新增
    Integer dynamicAddAttendace(Attendance attendance);

    //2. 去查询迟到次数大于等于5次的员工
    List<Attendance> selectLaterOutFive(String month);
    //3. 去查询迟到次数小于5次的员工
    List<HashMap> selectLaterLessFive(String month);
    //4. 去查询整月未迟到的人 24天 都没迟到就可以
    List<Attendance> selectNoLater();

    //5.查考勤页面信息
    List<HashMap> attendancePageInfo(HashMap map);
    //6.打卡信息每日一次 校验
    HashMap selectAttendanceDay(String userNumber);
}
