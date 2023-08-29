package com.面试相关.day02;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.面试相关.day02
 * @date 2023/8/26 21:19
 */
import java.util.Date;

public class MyData {

    private boolean flag=false;
    public void setFlag(boolean flag) {
        this.flag = flag;
    }
    public boolean isFlag() {
        return flag;
    }

    public static void main(String[] args) throws Exception {
        MyData myData = new MyData();
        // 线程1 修改值
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 子线程3s 后 修改为true
                myData.setFlag(true);
            }
        }).start();

        System.out.println(new Date());
        while (!myData.isFlag()){
            // (如果不用 volatile)  理论上 3s  这里的死循环会结束,但是 实际上3s 后主线程一直在死循环
            // 如果不用 volatile 主线程并没有感知到 子线程修改了变量
        }
        System.out.println("已经被修改了"+new Date());
    }
}