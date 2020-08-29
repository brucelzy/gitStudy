package com.aaa.service.impl;

import com.aaa.entity.Accommodation;
import com.aaa.dao.AccommodationDao;
import com.aaa.service.AccommodationService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author BruceLi
 * @since 2020-08-03
 */
@Service
public class AccommodationServiceImpl extends ServiceImpl<AccommodationDao, Accommodation> implements AccommodationService {
    @Autowired
    private AccommodationDao accommodationDao;

    @Override
    public PageInfo<HashMap> selectAccDept(Integer pageSize,Integer pageNum) {
        PageHelper.startPage(pageNum,pageSize);
        List<HashMap> list = accommodationDao.selectAccDept();
        for (HashMap map : list) {
            if (map.get("status").equals(1)){
                map.put("status","入住中");
            }
            else if (map.get("status").equals(0)){
                map.put("status","已退宿");
            }
            else if (map.get("status").equals(2)){
                map.put("status","申请中");
            }

        }
        PageInfo<HashMap> pageInfo=new PageInfo<>(list);

        return pageInfo;
    }
}
