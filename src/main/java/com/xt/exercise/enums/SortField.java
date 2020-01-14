package com.xt.exercise.enums;

import org.apache.commons.lang3.StringUtils;

/**
 * @Author: tao.xiong
 * @Date: 2019/12/25 17:04
 * @Description: 排序字段
 */
public enum SortField {
    update_time(), id(), create_time();

    SortField() {
    }

    public static SortField parase(String sortField) {
        SortField[] var1 = values();
        int var2 = var1.length;

        for (int var3 = 0; var3 < var2; ++var3) {
            SortField field = var1[var3];
            if (StringUtils.equals(sortField, field.name())) {
                return field;
            }
        }

        return null;
    }
}
