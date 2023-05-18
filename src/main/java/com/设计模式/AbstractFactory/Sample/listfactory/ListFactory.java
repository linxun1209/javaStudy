package com.设计模式.AbstractFactory.Sample.listfactory;


import com.设计模式.AbstractFactory.Sample.factory.Factory;
import com.设计模式.AbstractFactory.Sample.factory.Link;
import com.设计模式.AbstractFactory.Sample.factory.Page;
import com.设计模式.AbstractFactory.Sample.factory.Tray;

public class ListFactory extends Factory {
    @Override
    public Link createLink(String caption, String url) {
        return new ListLink(caption, url);
    }
    @Override
    public Tray createTray(String caption) {
        return new ListTray(caption);
    }
    @Override
    public Page createPage(String title, String author) {
        return new ListPage(title, author);
    }
}
