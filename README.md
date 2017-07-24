## nonull

客户端使用服务端返回的数据时通常需要各种判空，不判空就可能导致crash，
为此我们经常会写一些这样的代码

``` java
     if (country != null
                && country.zhejiang != null
                && country.zhejiang.hangzhou != null
                && country.zhejiang.hangzhou.woman != null
                && country.zhejiang.hangzhou.woman.friends != null) {
            dealWith(country.zhejiang.hangzhou.woman.friends);
     }

```

判断逻辑占据了大量篇幅，条件语句增多导致代码变得混乱，数据的可靠性应该像网络协议一样，由专门的处理层保证，不应该影响业务逻辑


我们来看一下Kotlin是如何优雅的实现的

Kotlin 类型定义
``` kotlin
class Country {
    var shandong: Province? = null
    var zhejiang = Province();
    override fun toString(): String {
        return "Country(shandong=$shandong, zhejiang=$zhejiang)"
    }
}
class Province{
    var qingdao: City? = null
    var hangzhou = City()
    var beijing: City? = null
    override fun toString(): String {
        return "Province(qingdao=$qingdao, hangzhou=$hangzhou, beijing=$beijing)"
    }
}
class City{
    var man: Person? = null
    var woman = Person();
    override fun toString(): String {
        return "City(man=$man, woman=$woman)"
    }
}
class Person{
    var name = "CTS"
    var birth = Date(0)
    var age = Date().year
    var isStudent: Boolean? = true
    var friends: List<Person> = ArrayList()
    var family: ArrayList<Person> = ArrayList()
    var toys: LinkedList<String>? = null
    var brothers = arrayOfNulls<Person>(0)
    var note = arrayOfNulls<Long>(0)
    var map: Map<String, String>? = null
    var mCountry: Country? = null
    override fun toString(): String {
        return "Person(name='$name', birth=$birth, age=$age, isStudent=$isStudent, friends=$friends, family=$family, toys=$toys, brothers=${Arrays.toString(brothers)}, note=${Arrays.toString(note)}, map=$map)"
    }
}

```

使用

``` kotlin


        var country = Country();

        var values = country.zhejiang?.hangzhou?.woman?.birth;
        println(if (values != null) values else "does not exist")


        var birth2 = country.shandong?.hangzhou?.woman?.birth
        println(if (birth2 != null) birth2 else "does not exist")


        var city = country.shandong?.qingdao
        println(if (city != null) city else "does not exist")

        city = country.zhejiang.hangzhou
        println(if (city != null) city else "does not exist")


        val map = country.zhejiang.hangzhou.woman.map
        println(if (map != null) map else "does not exist")



```

输出

```

Thu Jan 01 08:00:00 GMT+08:00 1970
does not exist
does not exist
City(man=null, woman=Person(name='CTS', birth=Thu Jan 01 08:00:00 GM...
does not exist

```

kotlin 引入了可选语法减少了判空，那java想变得同样优雅该怎么办呢？

#### 如何使用nonull

比如我们有如下的几个类

```java

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

```

```java
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


```

```java
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
```

```java
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

```

我们只需要这样使用

```java


import static com.wanjian.nonull.NoNull.$;
import static com.wanjian.nonull.NoNull.$$;

public class Test {
    public static void main(String[] args) {
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


        Map map = country.zhejiang.hangzhou.woman.map;
        System.out.println($(map) ? map : "does not exist");
    }
}

```

输出

```
Thu Jan 01 08:00:00 CST 1970
does not exist
does not exist
City{man=Person{name='', birth=null, age=-214748...
does not exist

```

语法比Kotlin还要简单，只需要把最外层的对象传递给 `NoNull.$$()`即可得到一个非空的对象，
可以调用这个对象所有字段都不会是空，除非对象中的字段使用了 `com.wanjian.nonull.Keep`
注解，可以使用`NoNull.$()`判断一个对象是否存在。具体用法参考`com.test.Test`