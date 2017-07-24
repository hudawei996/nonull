package com.wanjian.test.data;


import com.wanjian.city.City;
import com.wanjian.nonull.Keep;

/**
 * Created by wanjian on 2017/7/24.
 */

public class Province {
    public City qingdao;
    public City hangzhou = new City();
    @Keep
    public City beijing;
    public Province(int a) {
    }

    @Override
    public String toString() {
        return "Province{" +
                "qingdao=" + qingdao +
                ", hangzhou=" + hangzhou +
                ", beijing=" + beijing +
                '}';
    }
}
