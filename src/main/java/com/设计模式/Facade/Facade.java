package com.设计模式.Facade;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.设计模式.Facade
 * @date 2023/5/26 19:02
 */
public class Facade {
    private Patient patient;

    public Facade(Patient patient) {
        this.patient = patient;
    }

    void dispose() {
        Registry registry = new Registry();
        Doctor doctor = new Doctor();
        Pharmacy pharmacy = new Pharmacy();

        registry.dispose(patient);
        doctor.dispose(patient);
        pharmacy.dispose(patient);
    }
}
