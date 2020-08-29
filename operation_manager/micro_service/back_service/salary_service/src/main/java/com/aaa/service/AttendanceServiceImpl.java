package com.aaa.service;

import com.aaa.entity.Attendance;
import com.aaa.dao.AttendanceDao;
import com.aaa.entity.ResultData;
import com.aaa.service.AttendanceService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author BruceLi
 * @since 2020-08-05
 */
@Service
public class AttendanceServiceImpl extends ServiceImpl<AttendanceDao, Attendance> implements AttendanceService {
    @Autowired
    private AttendanceDao attendanceDao;

    @Override
    public ResultData dynamicAddAttendace(Attendance attendance) {
        ResultData resultData ;
        Integer result = attendanceDao.dynamicAddAttendace(attendance);
        if (result>0){
            resultData = new ResultData(true,"新增打卡信息成功",null);
            return resultData;
        }else{
            resultData = new ResultData(false,"新增打卡信息失败",null);
            return resultData;
        }
    }

    @Override
    public List<Attendance> selectLaterOutFivess() {
        //拿到当前月
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format =  simpleDateFormat.format(new Date());
        String month = format.substring(5,7);
        List<Attendance> outFive = attendanceDao.selectLaterOutFive(month);
        return outFive;
    }

    @Override
    public List<HashMap> selectLaterLessFive() {
        //拿到当前月
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format =  simpleDateFormat.format(new Date());
        String month = format.substring(5,7);
        List<HashMap> lessFive = attendanceDao.selectLaterLessFive(month);
        return lessFive;
    }

    @Override
    public List<Attendance> selectNoLater() {
        List<Attendance> list = attendanceDao.selectNoLater();
        return list;
    }

    @Override
    public PageInfo<HashMap> attendancePageInfo(HashMap map) {
        Integer pageSize = (Integer) map.get("pageSize");
        Integer pageNum = (Integer) map.get("pageNum");
        //1.开启分页
        PageHelper.startPage(pageNum,pageSize);
        //2.查出要放入分页内的数据
        List<HashMap> list = attendanceDao.attendancePageInfo(map);
        //3。数据放入pageinfo
        PageInfo<HashMap> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public ResultData attendanceDayOne(String userNumber) {
        HashMap map = attendanceDao.selectAttendanceDay(userNumber);
        if (map!=null){
            return new ResultData(true,"您今日已完成打卡了不能再次打卡了，明天再来吧",null);
        }else{
            return new ResultData(false,"打卡",null);
        }

    }
}
