package com.xingchen.StringBuffer;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.xingchen.StringBuffer
 * @date 2022/8/30 19:58
 */
public class setCharAt {
    //StringBuffer 类的 setCharAt() 方法用于在字符串的指定索引位置替换一个字符
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("hello");
        sb.setCharAt(1,'E');
        System.out.println(sb);    // 输出：hEllo
        sb.setCharAt(0,'H');
        System.out.println(sb);    // 输出：HEllo
        sb.setCharAt(2,'p');
        System.out.println(sb);    // 输出：HEplo
    }
}
