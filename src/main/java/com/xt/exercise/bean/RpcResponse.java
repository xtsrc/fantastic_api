package com.xt.exercise.bean;

import java.io.Serializable;

/**
 * @Author: tao.xiong
 * @Date: 2019/12/25 16:59
 * @Description:
 */
public class RpcResponse<T> implements Serializable {
    private static final long serialVersionUID = -8857537357659842080L;
    private Boolean success;
    private String message;
    private T data;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
