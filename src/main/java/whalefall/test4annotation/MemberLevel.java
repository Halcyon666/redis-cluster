package whalefall.test4annotation;

import java.lang.annotation.*;

/**
 * @author: WhaleFall541
 * @date: 2021/10/6 17:22
 */
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MemberLevel {
    String type();
}
