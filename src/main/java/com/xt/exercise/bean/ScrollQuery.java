package com.xt.exercise.bean;

import java.util.List;

import com.xt.exercise.enums.GroupField;
import com.xt.exercise.enums.SortField;
import com.xt.exercise.enums.SortOrder;

/**
 * @Author: tao.xiong
 * @Date: 2019/12/30 11:24
 * @Description:
 */
public class ScrollQuery<T> {
    private int scrollSize;
    private Long scrollId;
    private List<String> include;
    /**
     * @see GroupField#name()
     */
    private String groupField;
    /**
     * @see SortField#name()
     */
    private String sortField;
    /**
     * @see SortOrder#name()
     */
    private String sortOrder;

    private T bean;

    public int getScrollSize() {
        return scrollSize;
    }

    public void setScrollSize(int scrollSize) {
        this.scrollSize = scrollSize;
    }

    public Long getScrollId() {
        return scrollId;
    }

    public void setScrollId(Long scrollId) {
        this.scrollId = scrollId;
    }

    public List<String> getInclude() {
        return include;
    }

    public void setInclude(List<String> include) {
        this.include = include;
    }

    public String getGroupField() {
        return groupField;
    }

    public void setGroupField(String groupField) {
        this.groupField = groupField;
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

    public T getBean() {
        return bean;
    }

    public void setBean(T bean) {
        this.bean = bean;
    }
}
