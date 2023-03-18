package com.Four;

import java.util.Objects;

public class AutomobileFactory {
    /*
    私有成员变量：
汽车编号（id)，String类型
价格(price)，float类型
构造方法：
通过形参初始化汽车编号（id)和价格(price)。
普通方法：
1)设置getter和setter方法用于获取和设置类中价格(price)变量的值。
2)重写equals方法，当汽车编号（id)相等时相同。
3)重写toString方法，返回汽车编号（id)和价格(price)的信息，样式如下：“汽车编号：XXX，价格：XXX”。
     */
    private String id;
    private float price;

    @Override
    public String toString() {
        return "汽车编号："+this.id+". 价格："+this.price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AutomobileFactory that = (AutomobileFactory) o;
        return Objects.equals(id, that.id);
    }


    public AutomobileFactory(String id, float price) {
        this.id = id;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
