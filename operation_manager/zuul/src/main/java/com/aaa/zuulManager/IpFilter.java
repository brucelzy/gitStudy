package com.aaa.zuulManager;


import com.aaa.util.LoadProperties;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;

/**
 * @author ：奎
 * @date ：Created in 2020/7/25 14:37
 * @description：
 * @modified By：
 * @version:
 */
@Component
public class IpFilter extends ZuulFilter {
    /*
        pre  在进入业务之前执行
        route 在执行业务中时执行
        post   在执行中和遇到错误之前执行
        error  在遇到异常时执行
    */
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        //如果有多个Filter  执行顺序，返回值越小，执行优先级越高
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        //该Filter是否起作用
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        //过滤器处理过滤业务的地方
        RequestContext currentContext = RequestContext.getCurrentContext();
        //获取HttpServerletReQuest
        HttpServletRequest request = currentContext.getRequest();
        //获取HttpServiceResponse对象
        HttpServletResponse response = currentContext.getResponse();
        //获取远程请求的地址
        String remoteAddr = request.getRemoteAddr();
        System.out.println("请求的地址为："+remoteAddr);
        Properties properties = LoadProperties.LoadPropertyByPath("Filter_config.properties");
        //if(remoteAddr.endsWith("13")||remoteAddr.endsWith("16")){
        if(properties.getProperty("filter_ip").contains(remoteAddr)){
            try {
                response.setCharacterEncoding("utf-8");
                response.sendError(403,"您的Ip非法，不能登录我的网站");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
