package com.高并发;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.高并发
 * @date 2023/12/7 22:35
 */
public class sychronizedTest {
    public static void main(String[] args) {
        // 可重入锁演示
        save();
    }
    public synchronized static void save() {
        System.out.println("save");
        update();
    }
    public synchronized static void update() {
        System.out.println("update");
    }
}
