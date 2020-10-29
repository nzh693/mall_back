package com.manage.mall.utils;

import java.lang.reflect.Field;

public class MyBeanUtil {

    /**
     * 判断bean的属性是否全为空
     * @param o
     * @return
     */
    public static boolean allFieldIsNULL(Object o){

        try {
            for (Field field : o.getClass().getDeclaredFields()) {
                field.setAccessible(true);

                Object object = field.get(o);
                if (object instanceof CharSequence) {
                    if (!org.springframework.util.ObjectUtils.isEmpty(object)) {
                        return false;
                    }
                } else {
                    if (null != object) {
                        return false;
                    }
                }
            }
        } catch (Exception e) {
           throw  new RuntimeException(e);
        }
        return true;
    }

}
