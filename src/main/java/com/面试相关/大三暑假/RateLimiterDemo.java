package com.面试相关.大三暑假;

import com.google.common.util.concurrent.RateLimiter;

/**
 * @author Guide哥
 * @date 2021/10/08 19:12
 * 平滑突发限流
 **/
public class RateLimiterDemo {

    public static void main(String[] args) {
        // 1s 放 5 个令牌到桶里也就是 0.2s 放 1个令牌到桶里
        RateLimiter rateLimiter = RateLimiter.create(5);
        for (int i = 0; i < 10; i++) {
            double sleepingTime = rateLimiter.acquire(1);
            System.out.printf("get 1 tokens: %ss%n", sleepingTime);
        }
    }


}

