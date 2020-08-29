package com.aaa.controller;


import com.aaa.entity.Accommodation;
import com.aaa.entity.Accommodsignout;
import com.aaa.service.AccommodationService;
import com.aaa.service.AccommodsignoutService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author BruceLi
 * @since 2020-08-03
 */
@RestController
@RequestMapping("/accommodsignout")
public class AccommodsignoutController {
    @Autowired
    private AccommodsignoutService outservice;
    @Autowired
    private AccommodationService service;
    @RequestMapping("/updateaccout")
    public Boolean updateAccout(Integer id){
        Accommodation accommodation=new Accommodation();
        accommodation.setAccommodationId(id);
        accommodation.setStatus(0);
        return service.updateById(accommodation);
    }

}

