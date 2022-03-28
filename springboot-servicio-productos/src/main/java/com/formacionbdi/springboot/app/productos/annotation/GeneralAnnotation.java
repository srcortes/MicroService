package com.formacionbdi.springboot.app.productos.annotation;

import java.lang.annotation.Documented;


public @interface GeneralAnnotation {
    String value() default "";
}
