package com.linxun.leetcode.代码随想录.字符串;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.字符串
 * @date 2023/5/22 22:59
 */
public class backspaceCompare {
    public static boolean backspaceCompare(String s, String t) {
        char[] sarray = s.toCharArray();
        char[] tarray = t.toCharArray();
        return generate(sarray).equals(generate(tarray));
    }
    public static String generate(char[] a){
        int slow = -1;
        int fast = 0;
        if(a.length == 1){
            return new String(a);
        } else{
            for(fast = 0; fast < a.length; fast++){
                if(a[fast] != '#') {
                    a[++slow] = a[fast];
                } else{
                    if(slow >= 0) {
                        slow--;
                    }
                }
            }
            return new String(a,0,slow + 1);
        }
    }

    // 普通方法（使用栈的思路）
        public boolean backspaceCompare2(String s, String t) {
            StringBuilder ssb = new StringBuilder(); // 模拟栈
            StringBuilder tsb = new StringBuilder(); // 模拟栈
            // 分别处理两个 String
            for (char c : s.toCharArray()) {
                if (c != '#') {
                    ssb.append(c); // 模拟入栈
                } else if (ssb.length() > 0){ // 栈非空才能弹栈
                    ssb.deleteCharAt(ssb.length() - 1); // 模拟弹栈
                }
            }
            for (char c : t.toCharArray()) {
                if (c != '#') {
                    tsb.append(c); // 模拟入栈
                } else if (tsb.length() > 0){ // 栈非空才能弹栈
                    tsb.deleteCharAt(tsb.length() - 1); // 模拟弹栈
                }
            }
            return ssb.toString().equals(tsb.toString());
        }



    class Solution {
        public  boolean backspaceCompare(String s, String t) {
            int sSkipNum = 0; //记录s的#的个数
            int tSkipNum = 0; //记录t的#的个数
            int sIndex = s.length() - 1;
            int tIndex = t.length() - 1;
            while(true) {
                while(sIndex >= 0) { //每次记录连续的#并跳过被删除的字符
                    if(s.charAt(sIndex) == '#') {
                        sSkipNum++;
                    } else {
                        if(sSkipNum > 0) {
                            sSkipNum--;
                        } else {
                            break;
                        }
                    }
                    sIndex--;
                }
                while(tIndex >= 0) { //每次记录连续的#并跳过被删除的字符
                    if(t.charAt(tIndex) == '#') {
                        tSkipNum++;
                    } else {
                        if(tSkipNum > 0) {
                            tSkipNum--;
                        } else {
                            break;
                        }
                    }
                    tIndex--;
                }
                if(sIndex < 0 || tIndex < 0) { //s 或者 t遍历完了
                    break;
                }
                if(s.charAt(sIndex) != t.charAt(tIndex)) { //当前下标的字符不相等
                    return false;
                }
                sIndex--;
                tIndex--;
            }
            if(sIndex == -1 && tIndex == -1) { //同时遍历完 则相等
                return true;
            }
            return false;
        }
    }
}
