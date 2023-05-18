package com.设计模式.AbstractFactory.Sample.factory;

/**
 * @author xing'chen
 */
public abstract class Link extends Item {
    protected String url;
    public Link(String caption, String url) {
        super(caption);
        this.url = url;
    }
}
