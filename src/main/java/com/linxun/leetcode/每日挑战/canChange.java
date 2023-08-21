package com.linxun.leetcode.每日挑战;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.每日挑战
 * @date 2023/8/21 18:09
 */
public class canChange {
    public boolean canChange(String start, String target) {
        char[] source = start.toCharArray();
        for (int i = 0; i < target.length(); i++) {
            char ch = target.charAt(i);
            int j = i;
            if (source[i] != ch) {
                if (ch == 'R') {
                    return false;
                } else if (ch == 'L') {
                    if (source[i] == 'R') {
                        return false;
                    } else {
                        while (j < source.length && source[j] == '_') {
                            j++;
                        }
                        if (j < source.length && source[j] == 'L') {
                            source[i] = 'L';
                            source[j] = '_';
                        } else {
                            return false;
                        }
                    }
                } else if (ch == '_') {
                    if (source[i] == 'L') {
                        return false;
                    } else {
                        //在出现L之前，需要找到一个_
                        while (j < source.length && source[j] != '_') {
                            if (source[j] == 'L') {
                                return false;
                            }
                            j++;
                        }
                        if (j < source.length && source[j] == '_') {
                            source[i] = '_';
                            source[j] = 'R';
                        } else {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }


    /**
     * 双指针
     * @param start
     * @param target
     * @return
     */
    public static boolean canChange2(String start, String target) {
        int i = 0, j = 0, length = start.length();
        while (i < length && j < length) {
            while (i < length && start.charAt(i) == '_') {
                i++;
            }
            while (j < length && target.charAt(j) == '_') {
                j++;
            }
            if (i < length && j < length) {
                if ((start.charAt(i) != target.charAt(j))
                        || (start.charAt(i) == 'L' && i < j) ||
                        (start.charAt(i) == 'R' && i > j)) {
                    return false;
                }
                i++;
                j++;
            }
        }
        while (i < length) {
            if (start.charAt(i) != '_') {
                return false;
            }
            i++;
        }
        while (j < length) {
            if (target.charAt(j) != '_') {
                return false;
            }
            j++;
        }
        return true;
    }


    public boolean canChange3(String start, String target) {

        int right = 0;
        for (int left = 0; left < start.length(); left++) {
            if (start.charAt(left) != '_') {
                while (right < target.length() && target.charAt(right) == '_') {
                    right++;
                }
                if (right == target.length() || start.charAt(left) != target.charAt(right)) {
                    return false;
                }
                if (start.charAt(left) == 'L' && left < right) {
                    return false;
                }
                if (start.charAt(left) == 'R' && left > right) {
                    return false;
                }
                right++;
            }
        }
        for (right = right; right < target.length(); right++) {
            if (target.charAt(right) != '_') {
                return false;
            }
        }
        return true;

    }


    /**
     * 双指针依次移动比较每个字符是否相等以及下标大小即可。
     * @param start
     * @param target
     * @return
     */
    public boolean canChange6(String start, String target) {
        int n=start.length(),i=0,j=0;
        while (i<n||j<n){
            while (i<n&&start.charAt(i)=='_'){
                i++;
            }
            while (j < n && target.charAt(j) == '_') {
                j++;

            }
            if(i<n&&j<n){
                if(start.charAt(i)!=target.charAt(j)||(start.charAt(i)=='L'&&i<j)||(start.charAt(i)=='R'&&i>j)){
                    return false;
                }
                i++;
                j++;
            }else {
                break;
            }


        }
        return i==n&&j==n;


    }
    public boolean canChange5(String start, String target) {
        //根据题意已知start中字符无论怎么移动，其'L'和'R'的相对位置不会改变
        int n=start.length();
        int i=0,j=0;
        while(i<n||j<n){
            while(i<n&&start.charAt(i)=='_') {
                i++;
            }
            while(j<n&&target.charAt(j)=='_') {
                j++;
            }
            if(i<n&&j<n){   //说明下标i的字符移动能得到下标j的字符
                if(start.charAt(i)!=target.charAt(j)||start.charAt(i)=='L'&&i<j||start.charAt(i)=='R'&&i>j){     //L字符只能左移，R字符只能右移
                    return false;
                }
                i++;j++;
            }
            else {
                break;
            }
        }
        return i==n&&j==n;
    }


    public static void main(String[] args) {
        String s="_L__R__R_",t="L______RR";
        canChange2(s,t);
    }
}
