package demo.zjm._09注解._05重复注解;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;


@Retention(RetentionPolicy.RUNTIME)
@Inherited  //可继承性来说，可重复注解是非可继承的，包含它的注解使用可继承，算是不可继承的子集，可以理解为，添加了进一步的条件，也就是子集了
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE, ANNOTATION_TYPE, PACKAGE, TYPE_PARAMETER, TYPE_USE})
public @interface MyAnnotations {
    MyAnnotation[] value();
}
