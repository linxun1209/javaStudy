package com.JavaStudy.输入流和输出流;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.JavaStudy.输入流和输出流
 * @date 2022/9/18 12:12
 */
import java.io.FileWriter;
import java.io.IOException;

/**
 * 内容的写入：D:\io_test\1下创建一个text.txt文件，并写入内容
 */
public class IoDemo7 {
    public static void main(String[] args) throws IOException {
        //定义文件地址
        String filePath = "D:\\io_test\\1\\text.txt";
        //写入内容
        String content = "欢迎来到Java~";
        //因为是写入文件，所以要使用FileWriter方法
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(filePath);
            fileWriter.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //关闭流
            fileWriter.close();
        }
    }
}
