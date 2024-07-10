package com.面试相关.大三暑假;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

/**
 * @author xing'chen
 * @version 1.0
 * @description: TODO
 * @date 2024/7/9 14:21
 */
public class MyBloomFilterTest {
    public static void main(String[] args) {
        String value1 = "https://javaguide.cn/";
        String value2 = "https://github.com/Snailclimb";
        MyBloomFilter filter = new MyBloomFilter();
        System.out.println(filter.contains(value1));
        System.out.println(filter.contains(value2));
        filter.add(value1);
        filter.add(value2);
        System.out.println(filter.contains(value1));
        System.out.println(filter.contains(value2));

        /*
        Integer value1 = 13423;
        Integer value2 = 22131;
        MyBloomFilter filter = new MyBloomFilter();
        System.out.println(filter.contains(value1));
        System.out.println(filter.contains(value2));
        filter.add(value1);
        filter.add(value2);
        System.out.println(filter.contains(value1));
        System.out.println(filter.contains(value2));

         */


        /**
         * Guava 提供的布隆过滤器的实现还是很不错的（想要详细了解的可以看一下它的源码实现），但是它有一个重大的缺陷就是只能单机使用（另外，容量扩展也不容易），而现在互联网一般都是分布式的场景。为了解决这个问题，我们就需要用到 Redis 中的布隆过滤器了。
         * ------
         * 著作权归JavaGuide(javaguide.cn)所有
         * 基于MIT协议
         * 原文链接：https://javaguide.cn/cs-basics/data-structure/bloom-filter.html
         */
        // 创建布隆过滤器对象
        BloomFilter<Integer> filter2 = BloomFilter.create(
                Funnels.integerFunnel(),
                1500,
                0.01);
        // 判断指定元素是否存在
        System.out.println(filter2.mightContain(1));
        System.out.println(filter2.mightContain(2));
        // 将元素添加进布隆过滤器
        filter2.put(1);
        filter2.put(2);
        System.out.println(filter2.mightContain(1));
        System.out.println(filter2.mightContain(2));
    }
}

