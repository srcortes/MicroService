package com.formacionbdi.springboot.app.productos.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Documented
@Target({ElementType.TYPE_USE})
public @interface InfoController {
    long id() default 0L;
    String descriptionVariable() default "";
}
