package summary.java.cms.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface RequestMapping {
    String value() default "";
    /*
        method 에도 annotation을 적용해서 하는것임.
        Controller의 호출 방법이 바뀌게 되는 trigger
    */
}
