package com.aaa.zuulManager;

import com.aaa.util.LoadProperties;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

/**
 * @author ：奎
 * @date ：Created in 2020/7/25 16:03
 * @description：
 * @modified By：
 * @version:
 */
@Component
public class IllgelCharFilter extends ZuulFilter {
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
        return 1;
    }
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        System.out.println("已进入敏感词筛选阶段");
        //过滤器处理过滤业务的地方
        RequestContext currentContext = RequestContext.getCurrentContext();
        //获取RequestServerlet
        HttpServletRequest request = currentContext.getRequest();
        //获取HttpServiceResponse对象
        HttpServletResponse response = currentContext.getResponse();
        //获取参数的名称key集合  url?a=1&b=22&v=333
        Enumeration<String> parameterNames = request.getParameterNames();//[a,b,c]
        //获取配置的非法字符
        Properties properties = LoadProperties.LoadPropertyByPath("Filter_config.properties");
        String illigelchar = properties.getProperty("illigel_char");
        String[] ichars = illigelchar.split(",");
        while (parameterNames.hasMoreElements()){//判断是否有下一个元素
            String paraname = parameterNames.nextElement();//获取 第一次获取a 第二次吧第三次c
            //更具名称获取值
            String parameter = request.getParameter(paraname);//第一次 1 第二次 22 第三次 333
            for (String icher : ichars) {
                if(parameter.contains(icher)){
                    try {
                        response.setCharacterEncoding("utf-8");
                        response.sendError(403,"本网站拒绝敏感词");
                        break;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
        return null;
    }
}
