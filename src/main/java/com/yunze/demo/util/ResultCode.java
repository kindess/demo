package com.yunze.demo.util;

import lombok.Data;

/**
 * 响应结构
 */
@Data
public class ResultCode<T> {

    // 响应业务状态  状态码 200 成功 , 201 失败
    private Integer status;
    // 响应消息
    private String msg ;
    // 响应中的数据
    private T data;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ResultCode(Integer status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 成功
     * @param data
     */
    public ResultCode(T data) {
        this.status = 200;
        this.msg = "success";
        this.data = data;
    }
    public static <T> ResultCode<T> success(T data) {
        return new ResultCode<T>(data);
    }

    /**
     * 失败
     * @param msg
     */
    public ResultCode(String msg) {
        this.status = 201;
        this.msg = msg;
        this.data = null;
    }
    public static <T> ResultCode<T> error(String msg) {
        return new ResultCode<T>( msg);
    }

    @Override
    public String toString() {
        return "ResultCode [status=" + status + ", msg=" + msg + ", data=" + data + "]";
    }
}