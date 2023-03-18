package com.JavaStudy.输入流和输出流;

import java.io.File;
import java.io.IOException;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.JavaStudy.输入流和输出流
 * @date 2022/9/18 15:29
 */
public class Iodine {
    public static void main(String[] args) throws IOException {
        File f1 = new File("C:\\Windows");
        File f2 = new File("C:\\Windows\\notepad.exe");
        File f3 = new File("C:\\Windows\\nothing");
        System.out.println(f1.isFile());
        System.out.println(f1.isDirectory());
        System.out.println(f2.isFile());
        System.out.println(f2.isDirectory());
        System.out.println(f3.isFile());
        System.out.println(f3.isDirectory());
    }
}
