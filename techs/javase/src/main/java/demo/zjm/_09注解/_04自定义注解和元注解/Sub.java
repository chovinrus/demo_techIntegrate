package demo.zjm._09注解._04自定义注解和元注解;

import java.lang.annotation.Annotation;

public class Sub extends Main {
    public static void main(String[] args) {
        for (Annotation annotation : Sub.class.getAnnotations()) {
            System.out.println(annotation);
        }
    }
}
