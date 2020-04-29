package com.xt.exercise.validate;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * @Author: tao.xiong
 * @Date: 2020/4/29 15:55
 * @Description:
 */
@Constraint(validatedBy = EnumValidator.class)
@Target({ java.lang.annotation.ElementType.FIELD })
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@Documented
public @interface InEnum {
    String message() default "";

    /**
     * 是否必填
     */

    boolean required() default false;
    /**
     * 枚举的Class
     * @return
     */
    Class<? extends Enum<?>> enumClass();

    /**
     * 枚举中的验证方法
     * @return
     */
    String enumMethod() default "parse";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
