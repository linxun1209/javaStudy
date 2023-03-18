package com.xingchen.StringBuffer;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.xingchen.StringBuffer
 * @date 2022/8/30 20:00
 */
public class reverse {
    //StringBuffer 类中的 reverse() 方法用于将字符串序列用其反转的形式取代
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("java");
        sb.reverse();
        System.out.println(sb);    // 输出：avaj
    }
}
