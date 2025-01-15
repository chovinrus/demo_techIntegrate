package demo.zjm._08反射._09获取注解;

import java.util.Arrays;

@IndirectAnnotation("value1")
@IndirectAnnotation("value2")
@DirectAnnotation
@SuppressWarnings("VALUE")
@Deprecated()
public class Main<T> extends Base {

    public static void main(String[] args) throws NoSuchMethodException {
        //public <A extends Annotation> A[] getAnnotationsByType
        //返回当前类和从父类继承的注解
        System.out.println(Arrays.asList(Main.class.getAnnotationsByType(DirectAnnotation.class)));
        System.out.println(Arrays.asList(Main.class.getAnnotationsByType(IndirectAnnotation.class)));
        System.out.println(Arrays.asList(Main.class.getAnnotationsByType(BaseUsedAnnotation.class)));
        //[@反射._09获取注解.DirectAnnotation()]
        //[@反射._09获取注解.IndirectAnnotation(value=value1), @反射._09获取注解.IndirectAnnotation(value=value2)]
        //[@反射._09获取注解.BaseUsedAnnotation(value=)]

        //public <A extends Annotation > A[] getDeclaredAnnotationsByType
        //获取当前类的所有注解
        System.out.println(Arrays.asList(Main.class.getDeclaredAnnotationsByType(DirectAnnotation.class)));
        System.out.println(Arrays.asList(Main.class.getDeclaredAnnotationsByType(IndirectAnnotation.class)));
        System.out.println(Arrays.asList(Main.class.getDeclaredAnnotationsByType(BaseUsedAnnotation.class)));
        //[@反射._09获取注解.DirectAnnotation()]
        //[@反射._09获取注解.IndirectAnnotation(value=value1), @反射._09获取注解.IndirectAnnotation(value=value2)]
        //[]

        //获取当前类和父类的直接注解
        System.out.println(Arrays.asList(Main.class.getAnnotation(DirectAnnotation.class)));
        System.out.println(Arrays.asList(Main.class.getAnnotation(IndirectAnnotation.class)));
        System.out.println(Arrays.asList(Main.class.getAnnotation(BaseUsedAnnotation.class)));
        //[@反射._09获取注解.DirectAnnotation()]
        //[null]
        //[@反射._09获取注解.BaseUsedAnnotation(value=)]

        //获取当前类的直接注解
        System.out.println(Arrays.asList(Main.class.getDeclaredAnnotation(DirectAnnotation.class)));
        System.out.println(Arrays.asList(Main.class.getDeclaredAnnotation(IndirectAnnotation.class)));
        System.out.println(Arrays.asList(Main.class.getDeclaredAnnotation(BaseUsedAnnotation.class)));
        //[@反射._09获取注解.DirectAnnotation()]
        //[null]
        //[null]
    }
}
