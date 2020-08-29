package com.aaa.sls.controller;

import com.aaa.sls.entitiy.ResultData;
import com.aaa.sls.entitiy.SysUser;
import com.aaa.sls.service.SysUserService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import org.apache.shiro.crypto.hash.Sha512Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.concurrent.TimeUnit;


@RequestMapping("slss")
@RestController
public class LoginController {
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private RedisTemplate redisTemplate;

    @RequestMapping("login")
    public String login(@RequestParam("username") String username, @RequestParam("pwd") String pwd){
        Wrapper<SysUser> wrapper = new EntityWrapper<>();
        wrapper.eq("user_name",username);
        List<SysUser> sysUsers = sysUserService.selectList(wrapper);
        System.out.println(sysUsers.toString());
        if (sysUsers!=null&&sysUsers.size()>0){
            SysUser sysUser = sysUsers.get(0);
            String salt = sysUser.getSalt();
            Sha512Hash saltpwd = new Sha512Hash(pwd,salt,1024);
//            System.out.println(sysUser.getPassword()+"----11111111");
//            System.out.println(saltpwd);
//            System.out.println(saltpwd.toString().equals(sysUser.getPassword()));
            if (saltpwd.toString().equals(sysUser.getPassword())){
                String token = username+System.currentTimeMillis();
                //把生成的token和用户信息存入redis key就是token  value就是用户信息
                redisTemplate.opsForValue().set(token,sysUser,30, TimeUnit.MINUTES);
                return token;
            }
        }
        return "nologin";
    }
    /**
     * description: 验证token是否存在
     * @param:accessToken
     * return: boolean
     */
    @RequestMapping("token")
    public boolean checkToken(@RequestParam("acessToken") String accessToken){
        return redisTemplate.hasKey(accessToken);
    }
    @RequestMapping("loginOut")
    public boolean loginOut(String accessToken){
        System.out.println(accessToken);
        Boolean b = redisTemplate.delete(accessToken);
        System.out.println(b);
        return b;
    }
}
