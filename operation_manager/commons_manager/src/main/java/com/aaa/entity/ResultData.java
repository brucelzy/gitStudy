package com.aaa.entity;

public class ResultData {
    private boolean state;
    private String message;
    private Object data;

    public ResultData(boolean state, String message, Object data) {
        this.state = state;
        this.message = message;
        this.data = data;
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
