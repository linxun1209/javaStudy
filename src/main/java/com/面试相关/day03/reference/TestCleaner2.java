//package com.面试相关.day03.reference;
//
//
//import java.io.IOException;
//
//import com.面试相关.day02.LoggerUtils;
//import jdk.internal.ref.Cleaner;
//
//public class TestCleaner2 {
//    public static void main(String[] args) throws IOException {
//        Cleaner cleaner1 = Cleaner.create(new MyResource(), ()-> LoggerUtils.get().debug("clean 1"));
//        Cleaner cleaner2 = Cleaner.create(new MyResource(), ()-> LoggerUtils.get().debug("clean 2"));
//        Cleaner cleaner3 = Cleaner.create(new MyResource(), ()-> LoggerUtils.get().debug("clean 3"));
//        Cleaner cleaner4 = Cleaner.create(new MyResource(), ()-> LoggerUtils.get().debug("clean 4"));
//
//        System.gc();
//        System.in.read();
//    }
//
//    static class MyResource {
//
//    }
//}
