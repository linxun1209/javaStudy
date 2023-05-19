package com.linxun.leetcode.代码随想录.数组;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.数组
 * @date 2023/5/19 18:23
 */
public class validMountainArray {
    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3) {
            // 此时，一定不是有效的山脉数组
            return false;
        }
        int l=0,r=arr.length;
        while (l+1<arr.length&&arr[l]<arr[l+1]){
            l++;
        }
        while (r>0&arr[r]<arr[r-1]){
            r--;
        }
        if(l==r&&l!=0&&r!=arr.length-1){
            return true;
        }
        return false;

    }
}
