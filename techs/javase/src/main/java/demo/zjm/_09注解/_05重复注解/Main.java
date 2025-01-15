package demo.zjm._09注解._05重复注解;


import java.lang.annotation.Annotation;

@MyAnnotation("1")
@MyAnnotation("2")
public class Main {
    public static void main(String[] args) {
        for (Annotation annotation : Main.class.getAnnotations()) {
            System.out.println(annotation);
        }
    }
    //@注解._05重复注解.MyAnnotations(value=[@注解._05重复注解.MyAnnotation(value=1), @注解._05重复注解.MyAnnotation(value=2)])
}
