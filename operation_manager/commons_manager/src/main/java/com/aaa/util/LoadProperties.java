package com.aaa.util;

import java.io.IOException;
import java.util.Properties;

/**
 * @author ：奎
 * @date ：Created in 2020/7/31 18:52
 * @description：这是个配置文件工具类
 * @modified By：
 * @version: 1.0
 */

public class LoadProperties {
    public static Properties LoadPropertyByPath(String path){
        Properties properties=new Properties();
        try {
            properties.load(LoadProperties.class.getResourceAsStream("/"+path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
