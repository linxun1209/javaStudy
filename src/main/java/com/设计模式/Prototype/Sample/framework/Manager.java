package com.设计模式.Prototype.Sample.framework;

import java.util.HashMap;

/**
 * @author xing'chen
 */
public class Manager {
    private HashMap showcase = new HashMap();
    public void register(String name, Product proto) {
        showcase.put(name, proto);
    }
    public Product create(String protoName) {
        Product p = (Product)showcase.get(protoName);
        return p.createClone();
    }
}
