package com.aaa.zuulManager;

import com.aaa.service.UserService;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * fileName:SingleSignOnFilter
 * description:
 * author:zz
 * createTime:2020/7/31 11:08
 * version:1.0.0
 */
@Component
public class SingleSignOnFilter extends ZuulFilter{
    @Autowired
    private UserService userService;
    @Override
    public String filterType() {
        //pre 在业务执行之前  route  执行中    post 执行后   error 遇到异常
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 20;
    }

    @Override
    public boolean shouldFilter() {
        //修改这里就可以
        return false;
    }

    @Override
    public Object run() throws ZuulException {
        //获取上下文对象
        RequestContext requestContext =RequestContext.getCurrentContext();
        //获取请求和响应对象
        HttpServletRequest request = requestContext.getRequest();
        HttpServletResponse response = requestContext.getResponse();
        //获取请求的路径  url =http://ip:port/  +  uri
        String requestURI = request.getRequestURI();
        System.out.println(requestURI);
        //判断是否携带accessToken  判断是否正确
        String accessToken = request.getParameter("accessToken");
        System.out.println(accessToken);
        // 判断请求是否是登录请求  requestURI =/sso/user/login
        if(requestURI.contains("/sls/slss/login")||(!StringUtils.isEmpty(accessToken)&&userService.checkToken(accessToken))){

            //放行
            requestContext.setSendZuulResponse(true);
            requestContext.setResponseStatusCode(HttpStatus.SC_OK);
        }else{
            //不放行
            requestContext.setSendZuulResponse(false);
            //requestContext.setResponseStatusCode(HttpStatus.SC_UNAUTHORIZED);
            try {
                response.getWriter().print("noLogin");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}
