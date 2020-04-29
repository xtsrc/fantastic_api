package com.xt.exercise.enums;

/**
 * @Author: tao.xiong
 * @Date: 2019/12/25 17:12
 * @Description:
 */
public enum SortOrder {
    asc, desc;
    SortOrder() {
    }

    public static SortOrder parse(String sortOrder) {
        try {

            return valueOf(sortOrder);
        } catch (Exception e) {
            return null;
        }
    }
}
