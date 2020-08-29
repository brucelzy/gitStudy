package com.aaa.entity;

import lombok.Data;

import java.util.List;

/**
 * @author ：袁霄
 * @date ：Created in 2020/6/23 16:26
 * @description：
 * @modified By：
 * @version:
 */
@Data
public class LayUiTable {
    private int code;
    private String msg;
    private Integer count;
    private List<?> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }
}
