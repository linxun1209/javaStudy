package com.JavaStudy.输入流和输出流;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.JavaStudy.输入流和输出流
 * @date 2022/9/18 12:13
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 读取文件内容
 */
public class IoDemo9 {
    public static void main(String[] args) throws FileNotFoundException {
        String filePath = "D:\\io_test\\1\\tt.txt";
        Scanner scanner = new Scanner(new File(filePath));
        //因为读取的内容可能不止一条，所以加上while循环
        while (scanner.hasNext()){
            System.out.println(scanner.nextLine());
        }
    }
}

