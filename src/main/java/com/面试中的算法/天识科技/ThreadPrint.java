package com.面试中的算法.天识科技;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadPrint {
    // 声明一个ReentrantLock锁，用于控制线程同步
    private final Lock lock = new ReentrantLock();

    // 声明一个Condition对象，用于线程等待和唤醒
    private final Condition condition = lock.newCondition();

    // 当前应该打印的线程编号，从1开始
    private int current = 1;

    /**
     * 启动多个线程并进行交替打印
     *
     * @param threadCount 总线程数量
     * @param start 起始打印的数值
     * @param end 结束打印的数值
     */
    public void threadPrint(int threadCount, int start, int end) {
        // 创建 threadCount 个线程
        for (int i = 1; i <= threadCount; i++) {
            final int threadId = i;
            new Thread(() -> printNumbers(threadId, threadCount, start, end), "Thread-" + threadId).start();
        }
    }

    /**
     * 每个线程按照自己的编号交替打印数字
     */
    private void printNumbers(int threadId, int threadCount, int start, int end) {
        // i的取值：根据线程编号和步长来决定每个线程打印哪些值
        for (int i = start + threadId - 1; i <= end; i += threadCount) {
            lock.lock(); // 加锁，确保线程同步
            try {
                // 只允许当前线程编号为current的线程打印，其他线程等待
                while (current != threadId) {
                    condition.await(); // 当前线程等待，直到被唤醒
                }

                // 当前线程可以打印
                System.out.println(Thread.currentThread().getName() + ": " + i);

                // 修改current，让下一个线程运行
                current = (current % threadCount) + 1;

                // 唤醒其他所有等待的线程
                condition.signalAll();

            } catch (InterruptedException e) {
                // 如果线程被中断，重置中断状态
                Thread.currentThread().interrupt();
            } finally {
                // 确保最终释放锁，避免死锁
                lock.unlock();
            }
        }
    }

    /**
     * 主函数，启动线程进行交替打印
     */
    public static void main(String[] args) {
        ThreadPrint tp = new ThreadPrint();

        // 启动两个线程，交替打印从1到10的数值
        tp.threadPrint(2, 1, 10);
    }
}