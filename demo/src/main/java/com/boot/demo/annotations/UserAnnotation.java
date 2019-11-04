package com.boot.demo.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value = ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UserAnnotation {
    int id() default 0;

    String name() default "";

    int age() default 18;

    String gender() default "M";
}