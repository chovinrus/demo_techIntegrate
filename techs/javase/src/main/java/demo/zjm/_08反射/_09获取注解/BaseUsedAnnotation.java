package demo.zjm._08反射._09获取注解;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

//注意这个@Inherited注解必不可少
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface BaseUsedAnnotation {
    String value() default "default value";
}
