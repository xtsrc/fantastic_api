package com.xt.exercise.validate;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @Author: tao.xiong
 * @Date: 2020/4/29 14:16
 * @Description:
 */
public class InValidator implements ConstraintValidator<In, String> {
    private final Set<String> values = new HashSet<>();
    private String msg = null;

    @Override
    public void initialize(In constraintAnnotation) {
        Collections.addAll(this.values, constraintAnnotation.values());
        String msg = values.stream().map(Object::toString).collect(Collectors.joining(",", "[", "]"));
        this.msg = String.format("只能取值%s", msg);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        if (values.contains(value)) {
            return true;
        }
        if (context.getDefaultConstraintMessageTemplate().isEmpty()) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(this.msg).addConstraintViolation();
        }
        return false;
    }

}
