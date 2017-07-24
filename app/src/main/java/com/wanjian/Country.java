package com.wanjian;

import com.wanjian.test.data.Province;

/**
 * Created by wanjian on 2017/7/24.
 */

public class Country {
    public Province shandong;
    public Province zhejiang = new Province(1);

    @Override
    public String toString() {
        return "Country{" +
                "shandong=" + shandong +
                ", zhejiang=" + zhejiang +
                '}';
    }
}
