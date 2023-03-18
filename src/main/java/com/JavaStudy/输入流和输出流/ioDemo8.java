package com.JavaStudy.输入流和输出流;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.JavaStudy.输入流和输出流
 * @date 2022/9/18 12:13
 */
public class ioDemo8 {
    public static void main(String[] args) throws IOException {
        //定义文件地址
        String filePath = "D:\\io_test\\1\\text.txt";
        //写入内容
        String content = "欢迎来到java~,";
        //因为是写入文件，所以要使用FileWriter方法
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(filePath,true);
            fileWriter.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            fileWriter.close();
        }
    }
}


