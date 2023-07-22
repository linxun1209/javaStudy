package com.设计模式.Facade;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.设计模式.Facade
 * @date 2023/5/26 19:03
 */
public class ConcretePatient implements Patient{
    private String name;

    public ConcretePatient(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
