package com.设计模式.AbstractFactory.Sample.factory;

/**
 * @author xing'chen
 */
public abstract class Item {
    protected String caption;
    public Item(String caption) {
        this.caption = caption;
    }
    public abstract String makeHTML();
}
