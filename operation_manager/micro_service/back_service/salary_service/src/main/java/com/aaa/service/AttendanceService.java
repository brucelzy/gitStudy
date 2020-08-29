package com.aaa.service;

import com.aaa.entity.Attendance;
import com.aaa.entity.ResultData;
import com.baomidou.mybatisplus.service.IService;
import com.github.pagehelper.PageInfo;

import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author BruceLi
 * @since 2020-08-05
 */
public interface AttendanceService extends IService<Attendance> {

    //1. 点击打卡  前台用户进行新增打卡记录  点击打卡签到  去新增
    ResultData dynamicAddAttendace(Attendance attendance);
    //2. 去查询迟到次数大于等于5次的员工
    List<Attendance> selectLaterOutFivess();
    //3. 去查询迟到次数小于5次的员工
    List<HashMap> selectLaterLessFive();
    //4. 去查询整月未迟到的人 24天 都没迟到就可以
    List<Attendance> selectNoLater();
    //5.查考勤页面信息
    PageInfo<HashMap> attendancePageInfo(HashMap map);

    ResultData attendanceDayOne(String userNumber);


}
