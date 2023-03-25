package com.linxun.leetcode.每日挑战;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.每日挑战
 * @date 2023/3/25 18:14
 */
public class findLengthOfShortestSubarray {

    public static void main(String[] args) {
        int[] arr={1,2,3,10,4,2,3,5};
        System.out.println(findLengthOfShortestSubarray(arr));
    }

//    public static int findLengthOfShortestSubarray(int[] arr) {
//        int len=arr.length;
//        int res=0;
//        for(int i=1;i<len;i++){
//            if (arr[i]<=arr[i-1]){
//                res++;
//                i++;
//            }
//        }
//        return res;
//    }
    public static int findLengthOfShortestSubarray(int[] arr) {
        int l = 0, r = arr.length-1, R = arr.length-1, min = arr.length-1;
        while(l < arr.length-1 && arr[l] <= arr[l+1]) {
            l++;
        }
        while(r > 0 && arr[r] >= arr[r-1]) {
            r--;
        }
        if(l >= r) {
            return 0;
        }
        if(arr[l] <= arr[r]) {
            return r - l - 1;
        }
        for(int i=l; i>=0 && R >= r; i--){
            while(R >= r && arr[R] >= arr[i]) {
                R--;
            }
            min = Math.min(min,R - i);
        }
        return Math.min(min,r);
}


    /**
     * 双指针
     *
     * @param arr
     * @return
     */
    public int findLengthOfShortestSubarray2(int[] arr) {
        int n = arr.length, j = n - 1;
        while (j > 0 && arr[j - 1] <= arr[j]) {
            j--;
        }
        if (j == 0) {
            return 0;
        }
        int res = j;
        for (int i = 0; i < n; i++) {
            while (j < n && arr[j] < arr[i]) {
                j++;
            }
            res = Math.min(res, j - i - 1);
            if (i + 1 < n && arr[i] > arr[i + 1]) {
                break;
            }
        }
        return res;
    }
}
