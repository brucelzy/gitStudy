package com.aaa.controller;

import com.aaa.entity.Attendance;
import com.aaa.entity.ResultData;
import com.aaa.service.AttendanceService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author : bruceli
 * @version :$
 * @date :Created in 2020/8/7 15:58
 * @description :
 * @modified :
 */
@RestController
@RequestMapping("attendance")
public class AttendanceController {
    @Autowired
    private AttendanceService attendanceService;

    @RequestMapping("punchClock")
    public ResultData addAttendance(@RequestBody Attendance attendance){
        ResultData resultData = attendanceService.dynamicAddAttendace(attendance);
        return resultData;
    }
    @RequestMapping("attendancePage")
    public PageInfo<HashMap> selectAttendance(@RequestBody HashMap map){
        return attendanceService.attendancePageInfo(map);

    }
    @GetMapping("attendanceExist")
    public ResultData selectAttemdanceExist(String userNumber){
        ResultData resultData = attendanceService.attendanceDayOne(userNumber);
        return resultData;
    }




}
