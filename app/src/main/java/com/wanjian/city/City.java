package com.wanjian.city;

import com.data.person.Person;

/**
 * Created by wanjian on 2017/7/24.
 */

public class City {
    public Person man;
    public Person woman = new Person();

    @Override
    public String toString() {
        return "City{" +
                "man=" + man +
                ", woman=" + woman +
                '}';
    }
}
