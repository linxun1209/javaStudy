package com.JavaStudy.三种键盘输入的方法;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.JavaStudy.三种键盘输入的方法
 * @date 2022/9/18 11:16
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class EnterTest {

    public static void main(String[] args) { //主方法
        CharTest();  //调用System.in方法
        ReadTest();  //调用ReadTest方法
        ScannerTest();//调用ScannerTest方法
    }
    /**
     * System.in和System.out方法
     * 缺点一: 该方法能获取从键盘输入的字符，但只能针对一个字符的获取
     * 缺点二: 获取的只是char类型的。如果想获得int,float等类型的输入,比较麻烦。
     */
    public static void CharTest(){
        try{
            System.out.print("Enter a Char:");
            char i = (char)System.in.read();
            System.out.println("Yout Enter Char is:" + i);
        }
        catch(IOException e){
            e.printStackTrace();
        }

    }
    /**
     * InputStreamReader和BufferedReader方法
     * 优点: 可以获取键盘输入的字符串
     * 缺点: 如何要获取的是int,float等类型的仍然需要转换
     */
    public static void ReadTest(){
        System.out.println("ReadTest, Please Enter Data:");
        InputStreamReader is = new InputStreamReader(System.in); //new构造InputStreamReader对象
        BufferedReader br = new BufferedReader(is); //拿构造的方法传到BufferedReader中
        try{ //该方法中有个IOExcepiton需要捕获
            String name = br.readLine();
            System.out.println("ReadTest Output:" + name);
        }
        catch(IOException e){
            e.printStackTrace();
        }

    }
    /**
     * Scanner类中的方法
     * 优点一: 可以获取键盘输入的字符串
     * 优点二: 有现成的获取int,float等类型数据，非常强大，也非常方便；
     */
    public static void ScannerTest(){
        Scanner sc = new Scanner(System.in);
        System.out.println("ScannerTest, Please Enter Name:");
        String name = sc.nextLine();  //读取字符串型输入
        System.out.println("ScannerTest, Please Enter Age:");
        int age = sc.nextInt();    //读取整型输入
        System.out.println("ScannerTest, Please Enter Salary:");
        float salary = sc.nextFloat(); //读取float型输入
        System.out.println("Your Information is as below:");
        System.out.println("Name:" + name +" " + "Age:"+age + " "+"Salary:"+salary);
    }
}
