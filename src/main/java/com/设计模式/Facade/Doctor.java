package com.设计模式.Facade;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.设计模式.Facade
 * @date 2023/5/26 19:01
 */
public class Doctor implements Disposer{
    @Override
    public void dispose(Patient patient) {
        System.out.println("I am diagnosing..." + patient.getName());
    }
}
