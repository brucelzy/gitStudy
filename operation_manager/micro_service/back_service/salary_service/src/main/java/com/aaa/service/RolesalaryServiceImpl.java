package com.aaa.service;

import com.aaa.entity.Rolesalary;
import com.aaa.dao.RolesalaryDao;
import com.aaa.service.RolesalaryService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class RolesalaryServiceImpl extends ServiceImpl<RolesalaryDao, Rolesalary> implements RolesalaryService {
    @Autowired
    private RolesalaryDao rolesalaryDao;
    @Override
    public List<HashMap> userInfoAndRoleSalary() {
        return rolesalaryDao.userInfoAndRoleSalary();
    }

    @Override
    public List<HashMap> userAndRole() {
        return rolesalaryDao.userAndRole();
    }

    @Override
    public Rolesalary selectByRoleId(Integer roleId) {
        return rolesalaryDao.selectByRoleId(roleId);
    }
}
