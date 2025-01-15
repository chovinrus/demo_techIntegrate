package demo.zjm._09注解._06类型注解;

import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE_PARAMETER;
import static java.lang.annotation.ElementType.TYPE_USE;

//前者可以解决类泛型的注解修饰，后者，嗯用了就表示无所不能，嘛都能修饰
@Target({TYPE_PARAMETER, TYPE_USE})
public @interface annotation {

}
