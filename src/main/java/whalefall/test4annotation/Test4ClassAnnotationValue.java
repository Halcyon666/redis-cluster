package whalefall.test4annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author: WhaleFall541
 * @date: 2021/10/6 17:30
 */
public class Test4ClassAnnotationValue {
    public static void main(String[] args) {
        Annotation annotation = Member.Normal.class.getAnnotation(MemberLevel.class);
        String type = (String) getAnnotationValue(annotation, "type");
        System.err.println(type);

    }

    //获取该注解对象的属性值
    public static Object getAnnotationValue(Annotation annotation, String property) {
        Object result = null;
        if (annotation != null) {
            InvocationHandler invo = Proxy.getInvocationHandler(annotation); //获取被代理的对象
            Map map = (HashMap) getFieldValue(invo, "memberValues");
            if (map != null) {
                result = map.get(property);
            }
        }
        return result;
    }

    public static <T> Object getFieldValue(T object, String property) {
        if (object != null && property != null) {
            Class<T> currClass = (Class<T>) object.getClass();

            try {
                Field field = currClass.getDeclaredField(property);
                field.setAccessible(true);
                return field.get(object);
            } catch (NoSuchFieldException e) {
                throw new IllegalArgumentException(currClass + " has no property: " + property);
            } catch (IllegalArgumentException e) {
                throw e;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
