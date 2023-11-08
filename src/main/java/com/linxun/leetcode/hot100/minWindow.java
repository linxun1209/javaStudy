package com.linxun.leetcode.hot100;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.hot100
 * @date 2023/8/12 11:52
 * 子串第一题
 * 最小覆盖子串
 *
 */
public class minWindow {
    public static void main(String[] args) {
        String s="ADOBECODEBANC";
        String t="ABC";
        minWindow(s,t);

    }
    /**
     * 滑窗 + 哈希表
     *利用128位数组模拟哈希表。ht存储模板t的字母频次，在s上维护不小于t长度的窗口，hs记录窗口词频，
     * 当hs词频均不小于模板ht时，比较最小窗口长度min，若更min则记录当前窗口起止下标。
     * 完成min比较后尝试收缩窗口左边界，保证hs仍包含ht，若不包含则停止收缩并继续扩张右边界。
     * @param s
     * @param t
     * @return
     */
    public static String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();
        if (s.length() < t.length()) {
            return "";
        }
        int[] sp = new int[128];
        int[] tp = new int[128];
        for (char c : t.toCharArray()) {
            tp[c]++;
        }
        int min = m + 1, start = -1, end = -1;
        for (int l = 0, r = 0; r < m; r++) {
            sp[s.charAt(r)]++;
            if (r < n - 1) {
                continue;
            }
            while (check(sp, tp) && r - l + 1 >= n) {
                if (r - l + 1 < min) {
                    min = r - l + 1;
                    start = l;
                    end = r;
                }
                sp[s.charAt(l++)]--;
            }
        }
        return m<min?"":s.substring(start,end+1);
    }

    private static boolean check(int[] sp, int[] tp) {
        for (int i=0;i<128;i++){
            if(sp[i]<tp[i]){
                return false;
            }
        }
        return true;
    }


    public  String minWindowTest(String s, String t) {
        int m=s.length();
        int n=t.length();
        if(s.length()<t.length()){
            return "";
        }
        int[] sp=new int[128];
        int[] tp=new int[128];
        for (char c:t.toCharArray()){
            tp[c]++;
        }
        int min=m+1,start=-1,end=-1;
        for (int l=0,r=0;r<m;r++){
            sp[s.charAt(r)]++;
            if(r<n-1){
                continue;
            }
            while (check1(sp,tp)&&r-l+1>=n){
                if(r-l+1<min){
                    min=r-l+1;
                    start=l;
                    end=r;
                }
                sp[s.charAt(l++)]--;
            }
        }
        return m<min?"":s.substring(start,end);
    }
    private boolean check1(int[] sp,int[] tp){
        for (int i=0;i<128;i++){
            if(sp[i]<tp[i]){
                return false;
            }
        }
        return true;
    }
}
