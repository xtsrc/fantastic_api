package com.xt.exercise.enums;

/**
 * @Author: tao.xiong
 * @Date: 2019/12/25 17:04
 * @Description: 排序字段
 */
public enum SortField {
    update_time, id, create_time;

    SortField() {
    }

    public static SortField parse(String sortField) {
        try {

            return valueOf(sortField);
        } catch (Exception e) {
            return null;
        }
    }
}
