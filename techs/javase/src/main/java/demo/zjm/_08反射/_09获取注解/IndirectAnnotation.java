package demo.zjm._08反射._09获取注解;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Repeatable(IndirectAnnotations.class)
@Retention(RetentionPolicy.RUNTIME)
//这里尤其注意public不能漏掉，具体什么原因
public @interface IndirectAnnotation {
    String value() default "default value";
}
