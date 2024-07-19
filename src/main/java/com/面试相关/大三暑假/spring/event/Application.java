package com.面试相关.大三暑假.spring.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    @Autowired
    private DemoPublisher demoPublisher;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    public void someMethod() {
        // 调用publish方法
        demoPublisher.publish("Hello, World!");
    }
}