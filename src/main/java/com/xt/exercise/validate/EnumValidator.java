package com.xt.exercise.validate;

import java.lang.reflect.Method;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @Author: tao.xiong
 * @Date: 2020/4/29 15:55
 * @Description:
 */
public class EnumValidator implements ConstraintValidator<InEnum, Object> {
    private Class<? extends Enum<?>> selected;
    private String method = null;
    private String msg = null;
    private Boolean required = null;

    @Override
    public void initialize(InEnum constraintAnnotation) {
        this.selected = constraintAnnotation.enumClass();
        this.method = constraintAnnotation.enumMethod();
        this.required = constraintAnnotation.required();
        this.msg = String.format("只能取枚举类%s的值", selected.getName());

    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (value == null) {
            return !required;
        }

        try {
            Method method = selected.getMethod(this.method, value.getClass());
            if (method.invoke(null, value) == null) {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        if (context.getDefaultConstraintMessageTemplate().isEmpty()) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(this.msg).addConstraintViolation();
        }
        return false;
    }
}
