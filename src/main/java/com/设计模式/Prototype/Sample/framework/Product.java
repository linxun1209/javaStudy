package com.设计模式.Prototype.Sample.framework;

/**
 * @author xing'chen
 */
public interface Product extends Cloneable {

    public abstract void use(String s);

    public abstract Product createClone();
}
