package com.xt.exercise.enums;

import org.apache.commons.lang3.StringUtils;

/**
 * @Author: tao.xiong
 * @Date: 2019/12/25 17:12
 * @Description:
 */
public enum SortOrder {
    asc,desc;
    private SortOrder() {
    }

    public static SortOrder parase(String sortOrder) {
        SortOrder[] var1 = values();
        int var2 = var1.length;

        for(int var3 = 0; var3 < var2; ++var3) {
            SortOrder order = var1[var3];
            if (StringUtils.equals(sortOrder, order.name())) {
                return order;
            }
        }

        return null;
    }
}
