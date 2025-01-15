package demo.zjm._08反射._09获取注解;

import java.util.Arrays;

@BaseUsedAnnotation("")
public class Base {
    public static void main(String[] args) throws NoSuchMethodException {
        System.out.println(Arrays.asList(Base.class.getAnnotations()));
        System.out.println(Arrays.asList(Base.class.getAnnotationsByType(BaseUsedAnnotation.class)));
    }
}
