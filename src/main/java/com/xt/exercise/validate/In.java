package com.xt.exercise.validate;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * @Author: tao.xiong
 * @Date: 2020/4/29 14:28
 * @Description:
 */
@Constraint(validatedBy = InValidator.class)
@Target({ java.lang.annotation.ElementType.FIELD })
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@Documented
public @interface In {
    String message() default "";

    boolean required() default true;

    String[] values() default {};

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
