package com.example.demo.commom.springAop.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.PARAMETER})
@Inherited
@Documented
public @interface MyAnnotation {
}
