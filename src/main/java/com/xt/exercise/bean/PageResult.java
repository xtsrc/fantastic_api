package com.xt.exercise.bean;

import java.io.Serializable;
import java.util.List;

import com.xt.exercise.util.JsonUtils;

/**
 * @Author: tao.xiong
 * @Date: 2019/12/25 17:24
 * @Description:
 */
public final class PageResult<T> implements Serializable {
    private static final long serialVersionUID = -2830151567553317478L;
    private int total = 0;
    private int pageIndex = 0;
    private List<T> data;

    public PageResult() {
    }

    public int getTotal() {
        return this.total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getData() {
        return this.data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getPageIndex() {
        return this.pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    @Override
    public String toString() {
        return JsonUtils.encode(this);
    }
}
