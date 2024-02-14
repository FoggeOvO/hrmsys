package com.peo.annotation;

import java.lang.annotation.*;
 
@Inherited
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE})
@Retention(RetentionPolicy.RUNTIME)
public @interface DataScope {
    boolean flag() default  true;
}