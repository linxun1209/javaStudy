package com.设计模式.Facade;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.设计模式.Facade
 * @date 2023/5/26 19:03
 */
public class FacadeTest {
    public static void main(String[] args) {
        Patient patient=new ConcretePatient("xingchen");
        Facade facade=new Facade(patient);
        facade.dispose();
    }
}
