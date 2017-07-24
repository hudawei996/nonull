package com.wanjian.nonull;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wanjian on 2017/7/23.
 */

public class God {
    private Map<Class<?>, Object> sEmptyInstance = new HashMap<>();

    <T> T innerCreate(Class<T> clz) {
        Object o = sEmptyInstance.get(clz);
        if (o == null) {
            o = create(clz);
            if (o == null || !clz.isInstance(o)) {
                throw new RuntimeException("create method should return an instance of " + clz);
            }
            sEmptyInstance.put(o.getClass(), o);
        }
        return (T) o;
    }

    boolean ifChild(Object o) {
        return o != null && sEmptyInstance.get(o.getClass()) == o;
    }

    protected <T> Object create(Class<T> clz) {

        if (clz == Integer.class) {
            return new Integer(Integer.MIN_VALUE);
        }
        if (clz == Short.class) {
            return new Short(Short.MIN_VALUE);
        }
        if (clz == Long.class) {
            return new Long(Long.MIN_VALUE);
        }
        if (clz == Double.class) {
            return new Double(Double.MIN_VALUE);
        }
        if (clz == Float.class) {
            return new Float(Float.MIN_VALUE);
        }
        if (clz == Character.class) {
            return new Character('\0');
        }
        if (clz == Byte.class) {
            return new Byte(Byte.MIN_VALUE);
        }
        if (clz == Boolean.class) {
            return new Boolean(false);
        }


        try {
            try {
                return clz.newInstance();
            } catch (InstantiationException e) {
                //Perhaps an array
                return Array.newInstance(clz.getComponentType(), 0);
            }
        } catch (Exception e) {
            throw new RuntimeException("you should provide an instance of " + clz);
        }


    }
}
