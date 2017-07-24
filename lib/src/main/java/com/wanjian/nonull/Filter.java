package com.wanjian.nonull;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

/**
 * You can rewrite the relevant method to decide which class to process
 * <p>
 * Created by wanjian on 2017/7/23.
 */

public class Filter {

    protected List<String> packagePrefix() {
        return Arrays.asList();
    }

    protected List<String> packageSuffix() {
        return Arrays.asList();
    }

    protected List<String> packageContains() {
        return Arrays.asList();
    }

    protected List<Class<?>> classes() {
        return Arrays.asList();
    }

    boolean filter(Class<?> clz) {
        if (clz == null) {
            return false;
        }

        List<Class<?>> classes = classes();
        if (classes == null) {
            throw new RuntimeException("classes method can not return null !");
        }
        if (classes.contains(clz)) {
            return true;
        }
        Package pkg = clz.getPackage();
        if (pkg == null) {//array
            return false;
        }
        String packageName = pkg.getName();
        List<String> prefix = packagePrefix();
        if (prefix == null) {
            throw new RuntimeException("packagePrefix method can not return null !");
        }
        for (String s : prefix) {
            if (packageName.startsWith(s)) {
                return true;
            }
        }

        List<String> suffix = packageSuffix();
        if (suffix == null) {
            throw new RuntimeException("packageSuffix method can not return null !");
        }
        for (String s : suffix) {
            if (packageName.endsWith(s)) {
                return true;
            }
        }
        List<String> contains = packageContains();
        if (contains == null) {
            throw new RuntimeException("packageContains method can not return null !");
        }
        for (String s : contains) {
            if (packageName.contains(s)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Basic type is not processed and
     * do not deal with {@link Keep} annotated
     *
     * @param field
     * @return
     */
    boolean filter(Field field) {
        if (field == null) {
            return false;
        }

        switch (field.getType().getName()) {
            case "int":
            case "short":
            case "long":
            case "float":
            case "double":
            case "boolean":
            case "char":
            case "byte":
                return false;
        }
        return field.getAnnotation(Keep.class) == null;
    }

}
