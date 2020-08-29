package com.aaa.controller;


import com.aaa.entity.Accommodation;
import com.aaa.entity.LayUiTable;
import com.aaa.service.AccommodationService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.github.pagehelper.PageInfo;
import com.google.common.base.Equivalence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author BruceLi
 * @since 2020-08-03
 */
@RestController
@RequestMapping("/accommodation")
public class AccommodationController {
    @Autowired
    private AccommodationService service;
    @RequestMapping("/selectAll")
    public PageInfo<HashMap> selectAll(Integer pageSize, Integer pageNum){
        return service.selectAccDept(pageSize,pageNum);
    }
    @RequestMapping("/updateAccStatus")
    public Boolean updateAccStatus(Integer id){
        Accommodation accommodation = new Accommodation();
        accommodation.setStatus(2);
        accommodation.setAccommodationId(id);
        Boolean status=service.updateById(accommodation);
        return status;
    }

}

