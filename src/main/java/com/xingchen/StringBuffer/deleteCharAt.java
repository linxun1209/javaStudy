package com.xingchen.StringBuffer;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.xingchen.StringBuffer
 * @date 2022/8/30 20:00
 */
public class deleteCharAt {
    //deleteCharAt() 方法用于移除序列中指定位置的字符
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("She");
        sb.deleteCharAt(2);
        System.out.println(sb);    // 输出：Sh
        //delete() 方法用于移除序列中子字符串的字符
        //StringBuffer 对象.delete(int start,int end);
        //其中，start 表示要删除字符的起始索引值（包括索引值所对应的字符），end 表示要删除字符串的结束索引值（不包括索引值所对应的字符）。该方法的作用是删除指定区域以内的所有字符
        StringBuffer sb1 = new StringBuffer("hello jack");
        sb1.delete(2,5);
        System.out.println(sb);    // 输出：he jack
        sb1.delete(2,5);
        System.out.println(sb);    // 输出：heck
    }
}
