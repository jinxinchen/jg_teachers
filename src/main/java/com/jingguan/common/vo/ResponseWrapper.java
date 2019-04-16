package com.jingguan.common.vo;

/**
 * Created by yangbo on 2016/8/23.
 */
public class ResponseWrapper<T> {
    private boolean success;
    private T data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
