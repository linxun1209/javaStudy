package com.面试中的算法.来未来;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class ShowMeBug2 {
    private double balance; // 账户余额
    private final ReentrantLock lock = new ReentrantLock(); // 定义锁

    /**
     * 存款
     *
     * @param money 存入金额
     */
    public void deposit(double money) {
        lock.lock(); // 加锁
        try {
            balance += money;
        } finally {
            lock.unlock(); // 解锁
        }
    }

    /**
     * 获得账户余额
     */
    public double getBalance() {
        return balance;
    }

    public static void main(String[] args) {
        ShowMeBug2 account = new ShowMeBug2();

        // 创建线程池并发执行100个存款操作
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 100; i++) {
            executorService.execute(() -> account.deposit(1));
        }


        // 关闭线程池
        executorService.shutdown();
        while (!executorService.isTerminated()) {
            // 等待所有线程执行完毕
        }

        System.out.println("账户余额: " + account.getBalance());
    }
}
