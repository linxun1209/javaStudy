package com.设计模式.Prototype.complex;
import com.设计模式.Prototype.Sample.framework.Product;

import java.util.*;

/**
 * @author xing'chen
 */
public class Manager {
    private HashMap showcase = new HashMap();
    public void register(String name, com.设计模式.Prototype.Sample.framework.Product proto) {
        showcase.put(name, proto);
    }
    public com.设计模式.Prototype.Sample.framework.Product create(String protoName) {
        com.设计模式.Prototype.Sample.framework.Product p = (Product)showcase.get(protoName);
        return p.createClone();
    }
}
