package com.并发;

import com.linxun.leetcode.Tree.TreeNode;

import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.并发
 * @date 2023/4/4 22:01
 */
public class SIsuoTest {

    final HashMap<String ,String> map=new HashMap<>(2);
    Thread t=new Thread(new Runnable() {
        @Override
        public void run() {
            for (int i = 0; i < 10000; i++) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        map.put((UUID.randomUUID()).toString(),"");
                    }
                },"ftf"+i).start();
            }
        }
    },"ftf");
//    t.start();
//    t.join();


}
