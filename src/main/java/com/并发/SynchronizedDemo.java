package com.并发;

public class SynchronizedDemo {
    public void method() {
        synchronized (this) {
            System.out.println("synchronized");
        }
    }
}
