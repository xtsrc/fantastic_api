package com.xt.exercise.bean;

import java.io.Serializable;

import com.xt.exercise.enums.SortField;
import com.xt.exercise.enums.SortOrder;
import com.xt.exercise.validate.InEnum;

/**
 * @Author: tao.xiong
 * @Date: 2019/12/25 17:03
 * @Description:
 */
public final class PageQuery<T> implements Serializable {
    private static final long serialVersionUID = -8149462096653228454L;
    private T bean;
    private int pageIndex;
    private int pageSize = 20;
    private int totalCount;
    private int totalPages;
    @InEnum(enumClass = SortField.class)
    private String sortField;
    @InEnum(enumClass = SortOrder.class)
    private String sortOrder;

    public T getBean() {
        return bean;
    }

    public void setBean(T bean) {
        this.bean = bean;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public String getSortField() {
        return sortField;
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    public int getBeginIndex() {
        int beginIndex = this.getPageIndex() * this.pageSize;
        if (beginIndex > this.getTotalCount()) {
            beginIndex = this.getTotalCount();
        }

        return beginIndex < 0 ? 0 : beginIndex;
    }
}
