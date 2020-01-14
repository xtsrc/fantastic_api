package com.xt.exercise.enums;

import org.apache.commons.lang3.StringUtils;

/**
 * @Author: tao.xiong
 * @Date: 2020/1/14 12:02
 * @Description:
 */
public enum GroupField {

    business_id(),;
    GroupField() {

    }

    public static GroupField parase(String groupField) {
        GroupField[] var1 = values();
        int var2 = var1.length;

        for (int var3 = 0; var3 < var2; ++var3) {
            GroupField field = var1[var3];
            if (StringUtils.equals(groupField, field.name())) {
                return field;
            }
        }

        return null;
    }
}
