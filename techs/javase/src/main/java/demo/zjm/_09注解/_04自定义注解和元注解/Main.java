package demo.zjm._09注解._04自定义注解和元注解;

import java.lang.annotation.Annotation;

@MyAnnotation("嘤嘤嘤")   //配置参数只有一个时只需要写值即可
public class Main {
    public static void main(String[] args) {
        for (Annotation annotation : Main.class.getAnnotations()) {
            System.out.println(annotation);
        }
        //@注解._04自定义注解.MyAnnotation(value=嘤嘤嘤)
    }
}
