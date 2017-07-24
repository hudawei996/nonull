package com.data.person;

import com.wanjian.Country;
import com.wanjian.nonull.Keep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by wanjian on 2017/7/24.
 */

public class Person {
    public String name = "CTS";
    @Keep
    public Date birth = new Date(0);
    public Integer age = new Date().getYear();
    public Boolean isStudent = true;

    public List<Person> friends = new ArrayList<>();
    public ArrayList<Person> family = new ArrayList<>();
    public LinkedList<String> toys;
    public Person[] brothers = new Person[0];
    public Long[] note = new Long[0];
    public Map<String, String> map;
    public Country mCountry;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", birth=" + birth +
                ", age=" + age +
                ", isStudent=" + isStudent +
                ", friends=" + friends +
                ", family=" + family +
                ", toys=" + toys +
                ", brothers=" + Arrays.toString(brothers) +
                ", note=" + Arrays.toString(note) +
                ", map=" + map +
                ", mCountry=" +
                '}';
    }
}
