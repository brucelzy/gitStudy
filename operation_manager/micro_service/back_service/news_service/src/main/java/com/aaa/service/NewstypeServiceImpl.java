package com.aaa.service;

import com.aaa.entity.Newstype;
import com.aaa.dao.NewstypeDao;
import com.aaa.service.NewstypeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author BruceLi
 * @since 2020-07-31
 */
@Service
public class NewstypeServiceImpl extends ServiceImpl<NewstypeDao, Newstype> implements NewstypeService {

    @Autowired
    private NewstypeDao newstypeDao;
    @Override
    public List<Newstype> selectNewsTypeOption() {
        return newstypeDao.selectList(null);
    }
}
