package com.设计模式.Facade;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.设计模式.Facade
 * @date 2023/5/26 19:02
 */
public class Pharmacy implements Disposer{
    @Override
    public void dispose(Patient patient) {
        System.out.println("I am giving medicine... " + patient.getName());
    }
}
