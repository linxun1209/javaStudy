package com.JavaStudy.输入流和输出流;

import java.io.File;
import java.io.IOException;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.JavaStudy.输入流和输出流
 * @date 2022/9/18 15:28
 */
public class Io {
    public static void main(String[] args) throws IOException {
        File f = new File("..");
        System.out.println(f.getPath());
        System.out.println(f.getAbsolutePath());
        System.out.println(f.getCanonicalPath());
    }
}
