package com.Four;

public class Automobile extends AutomobileFactory implements CarModel{
    /*
    c)汽车类（Automobile），继承自汽车工厂（AutomobileFactory）类，实现汽车模型（CarModel）接口
私有成员变量：
速度（speed)，int类型，
构造方法：
通过形参初始化速度（speed)的值，并调用父类构造方法初始化汽车编号（id)和价格(price)信息。
普通方法

1)实现接口中的accelerate()方法，给速度（speed)变量加十。
2)实现接口中的slowDown()方法，给速度（speed)变量减十。
3)设置getter和setter方法用于获取和设置类中(speed)变量的值。

     */
    private int speed;

    @Override
    public void accelerate() {
        this.speed+=10;
    }

    @Override
    public void slowDown() {
        this.speed-=10;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Automobile(String id, float price, int speed) {
        super(id, price);
        this.speed = speed;
    }

}
