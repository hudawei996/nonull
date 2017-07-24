package com.wanjian.nonull;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * Reflects each field of the object，if the field is null，
 * assigns the unique value corresponding to the type of
 * the field to the field. This value is actually an instance
 * of the type of the field,and this value is provided by {@link God#innerCreate(Class)}
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * Created by wanjian on 2017/7/23.
 */

public class NoNull {

    private static God sGod = new God();
    private static Filter sFilter = new Filter();
    //Prevent nested references
    private static Map<Object, Boolean> sInited = new HashMap<>();

    public static void init(God god, Filter filter) {
        if (god != null) {
            sGod = god;
        }
        if (filter != null) {
            sFilter = filter;
        }
    }

    /**
     * @param obj
     * @param clz
     * @param <T>
     * @return
     */
    public static <T> T $$(T obj, Class<T> clz) {
        if (clz == null) {
            throw new IllegalArgumentException("clz can not be null !");
        }
        return (T) $$(obj, clz, false);
    }

    /**
     * @param obj
     * @param clz
     * @param forceNull When an object is null, mark all the fields in the object as empty
     * @return
     */
    private static Object $$(Object obj, Class<?> clz, boolean forceNull) {
        if (obj == null) {
            forceNull = true;
            obj = sGod.innerCreate(clz);
            if (sInited.get(obj) == null) {
                sInited.put(obj, true);
            } else {
                return obj;
            }
        }
        Class<?> clas = clz;
        while (clas != Object.class && sFilter.filter(clz)) {
            Field[] fields = clas.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                try {
                    Object value = null;
                    if (forceNull) {
                        field.set(obj, null);
                    } else {
                        value = field.get(obj);
                    }
                    if (sFilter.filter(field)) {
                        Object o = $$(value, field.getType(), forceNull);
                        field.set(obj, o);
                    }
                } catch (IllegalAccessException e) {
                    // e.printStackTrace();
                } catch (IllegalArgumentException e) {
                    // e.printStackTrace();
                }
            }
            clas = clz.getSuperclass();
        }

        return obj;
    }

    /**
     * Whether the field exists
     *
     * @param o
     * @return
     */
    public static boolean $(Object o) {
        return o != null && !sGod.ifChild(o);
    }
}
