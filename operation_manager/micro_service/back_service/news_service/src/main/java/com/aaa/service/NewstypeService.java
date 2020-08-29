package com.aaa.service;

import com.aaa.entity.Newstype;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author BruceLi
 * @since 2020-07-31
 */
public interface NewstypeService extends IService<Newstype> {

    List<Newstype> selectNewsTypeOption();
}
