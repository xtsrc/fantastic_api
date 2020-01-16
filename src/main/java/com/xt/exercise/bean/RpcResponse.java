package com.xt.exercise.bean;

import java.io.Serializable;

/**
 * @Author: tao.xiong
 * @Date: 2019/12/25 16:59
 * @Description:
 */
public final class RpcResponse<T> implements Serializable {
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

    public static RpcResponse fail(String msg) {
        return createResponse(Boolean.FALSE, msg, null);
    }

    public static <T> RpcResponse<T> success(T data) {
        return createResponse(Boolean.TRUE, null, data);
    }

    public static <T> RpcResponse<T> createResponse(boolean success, String message, T data) {
        RpcResponse<T> ret = new RpcResponse();
        ret.setSuccess(success);
        ret.setMessage(message);
        ret.setData(data);
        return ret;
    }
}
