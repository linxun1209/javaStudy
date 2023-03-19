package com.linxun.leetcode.每日挑战;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeSet;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.每日挑战
 * @date 2023/3/19 9:03
 */
public class findLexSmallestString {
    public static void main(String[] args) {
        String s="5525";
        int a=9;
        int b=2;
        System.out.println(findLexSmallestString(s, a, b));

    }

    public static String findLexSmallestString(String s, int a, int b) {
        TreeSet<String> visited = new TreeSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(s);
        visited.add(s);
        while(!queue.isEmpty()) {
            String cur = queue.poll();
            char[] ch = cur.toCharArray();
            //累加：将  a 加到 s 中所有下标为奇数的元素上（下标从 0 开始）。
            //数字一旦超过 9 就会变成 0，如此循环往复。例如，s = "3456"
            //且 a = 5，则执行此操作后 s 变成 "3951"。
            for(int i = 1; i < ch.length; i += 2) {
                ch[i] = (char)((ch[i] - '0' + a) % 10 + '0');
            }
            String str = new String(ch);
            if(!visited.contains(str)) {
                visited.add(str);
                queue.offer(str);
            }

            //轮转：将 s 向右轮转 b 位。例如，s = "3456"
            //且 b = 1，则执行此操作后 s 变成 "6345"。
            String sub1 = cur.substring(0, b);
            String sub2 = cur.substring(b);
            String con = sub2 + sub1;
            if(!visited.contains(con)) {
                visited.add(con);
                queue.offer(con);
            }
        }
        return visited.first();
    }
}
