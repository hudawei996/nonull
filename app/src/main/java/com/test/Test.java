package com.test;

import com.wanjian.Country;
import com.wanjian.city.City;
import com.wanjian.nonull.Filter;
import com.wanjian.nonull.God;
import com.wanjian.nonull.NoNull;
import com.wanjian.test.data.Province;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.wanjian.nonull.NoNull.$;
import static com.wanjian.nonull.NoNull.$$;

/**
 * Created by wanjian on 2017/7/23.
 */

public class Test {


    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        init();
//        List<String> list = NoNull.$(null, List.class);
        Country country = $$(new Country(), Country.class);
        System.out.println(country);

        Date birth = country.zhejiang.hangzhou.woman.birth;
        System.out.println($(birth) ? birth : "does not exist");

        birth = country.shandong.hangzhou.woman.birth;
        System.out.println($(birth) ? birth : "does not exist");

        City city = country.shandong.qingdao;
        System.out.println($(city) ? city : "does not exist");
        city = country.zhejiang.hangzhou;
        System.out.println($(city) ? city : "does not exist");


        Map map=country.zhejiang.hangzhou.woman.map;
        System.out.println($(map) ? map : "does not exist");



        log(country);

    }

    private static void log(Country country) {
        boolean b;

        b = $(country);
        System.out.println(b);
        b = $(country.shandong);
        System.out.println(b);
        b = $(country.shandong.qingdao);
        System.out.println(b);
        b = $(country.shandong.qingdao.man);
        System.out.println(b);
        b = $(country.shandong.qingdao.man.age);
        System.out.println(b);
        b = $(country.shandong.qingdao.man.birth);
        System.out.println(b);
        b = $(country.shandong.qingdao.man.mCountry);
        System.out.println(b);
        b = $(country.shandong.qingdao.man.friends);
        System.out.println(b);
        b = $(country.shandong.qingdao.man.name);
        System.out.println(b);
        b = $(country.shandong.qingdao.man.brothers);
        System.out.println(b);
        b = $(country.shandong.qingdao.man.note);
        System.out.println(b);
        b = $(country.shandong.qingdao.woman);
        System.out.println(b);
        b = $(country.shandong.qingdao.woman.age);
        System.out.println(b);
        b = $(country.shandong.qingdao.woman.birth);
        System.out.println(b);
        b = $(country.shandong.qingdao.woman.mCountry);
        System.out.println(b);
        b = $(country.shandong.qingdao.woman.friends);
        System.out.println(b);
        b = $(country.shandong.qingdao.woman.name);
        System.out.println(b);
        b = $(country.shandong.qingdao.woman.brothers);
        System.out.println(b);
        b = $(country.shandong.qingdao.woman.note);
        System.out.println(b);
        b = $(country.shandong.hangzhou);
        System.out.println(b);
        b = $(country.shandong.hangzhou.man);
        System.out.println(b);
        b = $(country.shandong.hangzhou.man.age);
        System.out.println(b);
        b = $(country.shandong.hangzhou.man.birth);
        System.out.println(b);
        b = $(country.shandong.hangzhou.man.mCountry);
        System.out.println(b);
        b = $(country.shandong.hangzhou.man.friends);
        System.out.println(b);
        b = $(country.shandong.hangzhou.man.name);
        System.out.println(b);
        b = $(country.shandong.hangzhou.man.brothers);
        System.out.println(b);
        b = $(country.shandong.hangzhou.man.note);
        System.out.println(b);
        b = $(country.shandong.hangzhou.woman);
        System.out.println(b);
        b = $(country.shandong.hangzhou.woman.age);
        System.out.println(b);
        b = $(country.shandong.hangzhou.woman.birth);
        System.out.println(b);
        b = $(country.shandong.hangzhou.woman.mCountry);
        System.out.println(b);
        b = $(country.shandong.hangzhou.woman.friends);
        System.out.println(b);
        b = $(country.shandong.hangzhou.woman.name);
        System.out.println(b);
        b = $(country.shandong.hangzhou.woman.brothers);
        System.out.println(b);
        b = $(country.shandong.hangzhou.woman.note);
        System.out.println(b);
        b = $(country.zhejiang);
        System.out.println(b);
        b = $(country.zhejiang.qingdao);
        System.out.println(b);
        b = $(country.zhejiang.qingdao.man);
        System.out.println(b);
        b = $(country.zhejiang.qingdao.man.age);
        System.out.println(b);
        b = $(country.zhejiang.qingdao.man.birth);
        System.out.println(b);
        b = $(country.zhejiang.qingdao.man.mCountry);
        System.out.println(b);
        b = $(country.zhejiang.qingdao.man.friends);
        System.out.println(b);
        b = $(country.zhejiang.qingdao.man.name);
        System.out.println(b);
        b = $(country.zhejiang.qingdao.man.brothers);
        System.out.println(b);
        b = $(country.zhejiang.qingdao.man.note);
        System.out.println(b);
        b = $(country.zhejiang.qingdao.woman);
        System.out.println(b);
        b = $(country.zhejiang.qingdao.woman.age);
        System.out.println(b);
        b = $(country.zhejiang.qingdao.woman.birth);
        System.out.println(b);
        b = $(country.zhejiang.qingdao.woman.mCountry);
        System.out.println(b);
        b = $(country.zhejiang.qingdao.woman.friends);
        System.out.println(b);
        b = $(country.zhejiang.qingdao.woman.name);
        System.out.println(b);
        b = $(country.zhejiang.qingdao.woman.brothers);
        System.out.println(b);
        b = $(country.zhejiang.qingdao.woman.note);
        System.out.println(b);
        b = $(country.zhejiang.hangzhou);
        System.out.println(b);
        b = $(country.zhejiang.hangzhou.man);
        System.out.println(b);
        b = $(country.zhejiang.hangzhou.man.age);
        System.out.println(b);
        b = $(country.zhejiang.hangzhou.man.birth);
        System.out.println(b);
        b = $(country.zhejiang.hangzhou.man.mCountry);
        System.out.println(b);
        b = $(country.zhejiang.hangzhou.man.friends);
        System.out.println(b);
        b = $(country.zhejiang.hangzhou.man.name);
        System.out.println(b);
        b = $(country.zhejiang.hangzhou.man.brothers);
        System.out.println(b);
        b = $(country.zhejiang.hangzhou.man.note);
        System.out.println(b);
        b = $(country.zhejiang.hangzhou.woman);
        System.out.println(b);
        b = $(country.zhejiang.hangzhou.woman.age);
        System.out.println(b);
        b = $(country.zhejiang.hangzhou.woman.birth);
        System.out.println(b);
        b = $(country.zhejiang.hangzhou.woman.mCountry);
        System.out.println(b);
        b = $(country.zhejiang.hangzhou.woman.friends);
        System.out.println(b);
        b = $(country.zhejiang.hangzhou.woman.name);
        System.out.println(b);
        b = $(country.zhejiang.hangzhou.woman.brothers);
        System.out.println(b);
        b = $(country.zhejiang.hangzhou.woman.note);
        System.out.println(b);

    }

    private static void init() {
        NoNull.init(new God() {
            @Override
            protected <T> Object create(Class<T> clz) {
                if (clz == Province.class) {
                    return new Province(-1);
                }
                if (clz == List.class) {
                    return new ArrayList<>();
                }
                if (clz == Map.class) {
                    return new HashMap<>();
                }
                return super.create(clz);
            }
        }, new Filter() {
            @Override
            protected List<Class<?>> classes() {
                return Arrays.asList(Country.class);
            }

            @Override
            protected List<String> packagePrefix() {
                return Arrays.asList("com.data");
            }

            @Override
            protected List<String> packageSuffix() {
                return Arrays.asList("data");
            }

            @Override
            protected List<String> packageContains() {
                return Arrays.asList("city");
            }
        });

    }
}
