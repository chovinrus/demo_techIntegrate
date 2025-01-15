package demo.zjm._09注解._04自定义注解和元注解;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

//指定生命周期
//默认是CLASS
@Retention(RetentionPolicy.RUNTIME)
//指明注解可以修饰的程序元素
//默认是所有能修饰
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE, ANNOTATION_TYPE, PACKAGE, TYPE_PARAMETER, TYPE_USE})
//解析生成文档的时候保留该注解，无参数，比如deprecated就需要在文档中被保留
@Documented
//@Inherited 修饰的 Annotation, 则其子类将自动具有该注解
@Inherited
//@Inherited 修饰的 Annotation修饰的类,，其子类将自动具有该注解
//注释掉再运行Sub类里的main方法获取Sub的注解，会发现结果空空
public @interface MyAnnotation {
    String value() default "default value";//配置参数默认为某值，只有一个时建议命名为value
}

//  @Retention()
//public @interface Retention {
//    RetentionPolicy value();
//}
//public enum RetentionPolicy {
//    SOURCE, CLASS, RUNTIME
//}

//  @Target()
//public @interface Target {
//    ElementType[] value();
//}
//public enum ElementType {
//    TYPE, FIELD, METHOD, PARAMETER,CONSTRUCTOR, LOCAL_VARIABLE, ANNOTATION_TYPE, PACKAGE, TYPE_PARAMETER, TYPE_USE
//}
