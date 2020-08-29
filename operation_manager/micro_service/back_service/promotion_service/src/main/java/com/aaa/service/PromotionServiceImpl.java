package com.aaa.service;

import com.aaa.entity.Promotion;
import com.aaa.dao.PromotionDao;
import com.aaa.service.PromotionService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author BruceLi
 * @since 2020-08-05
 */
@Service
public class PromotionServiceImpl extends ServiceImpl<PromotionDao, Promotion> implements PromotionService {
    @Autowired
    private PromotionDao promotionDao;

    @Override
    public PageInfo<HashMap> promotionPageInfo(Map map) {
        //1 开启分页
        PageHelper.startPage((Integer) map.get("pageNum"),(Integer) map.get("pageSize"));
        //2 查要放入分页中的数据
        List<HashMap> resultMap = new ArrayList<>();
        List<HashMap> mapDepart = promotionDao.selectPromotionDepart((String)map.get("departmentName"));
        //从mapDepart中取出promotionId 去查 晋升角色名
        for (HashMap promotionMap:mapDepart) {
            Integer promotionId = (Integer) promotionMap.get("promotion_id");
            HashMap roleMaps = promotionDao.selectPromotionRole(promotionId);
            String roleName = (String) roleMaps.get("role_name");
            promotionMap.put("role_name",roleName);
        }
        //3 将数据放入封装的Page内
        PageInfo<HashMap> pageInfo = new PageInfo<>(mapDepart);


        return pageInfo;
    }
}
