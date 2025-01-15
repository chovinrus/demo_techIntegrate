package demo.zjm._08反射._09获取注解;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface IndirectAnnotations {
    public IndirectAnnotation[] value();
}
