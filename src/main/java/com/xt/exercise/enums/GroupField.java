package com.xt.exercise.enums;

/**
 * @Author: tao.xiong
 * @Date: 2020/1/14 12:02
 * @Description:
 */
public enum GroupField {
    business_id;
    GroupField() {

    }

    public static GroupField parse(String groupField) {
        try {
            return valueOf(groupField);
        } catch (Exception e) {
            return null;
        }
    }
}
