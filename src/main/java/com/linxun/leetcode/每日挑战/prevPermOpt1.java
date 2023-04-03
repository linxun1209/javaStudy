package com.linxun.leetcode.每日挑战;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.每日挑战
 * @date 2023/4/3 10:58
 */
public class prevPermOpt1 {
    public static void main(String[] args) {
        int[] arr={3,2,1};
        prevPermOpt2(arr);
    }


        public static int[] prevPermOpt2(int[] arr) {
            int p = arr.length - 1;
            while (p > 0) {
                if (arr[p] >= arr[p - 1]) {
                    p--;
                } else {
                    break;
                }
            }
            if (p == 0) {
                return arr;
            }
            int left = p - 1;
            int right = p;
            while (true) {
                if (p + 1 < arr.length && arr[p + 1] < arr[left]) {
                    p++;
                    if (arr[p] > arr[right]) {
                        right = p;
                    }
                } else {
                    int t = arr[right];
                    arr[right] = arr[left];
                    arr[left] = t;
                    break;
                }
            }
            return arr;
        }


    public int[] prevPermOpt3(int[] arr) {
        int ans = arr.length - 1;
        while (ans > 0) {
            if (arr[ans] > arr[ans - 1]) {
                ans--;
            } else {
                break;
            }
        }
//        for(int i=0;i<n-1;i++){
//            if(arr[i]>arr[i+1]){
//                ans=i;
//                break;
//            }
//        }
        if (ans == 0) {
            return arr;
        }
        int left = ans;
        int right = ans + 1;
        while (true) {
            if (ans + 1 < arr.length && arr[ans + 1] < arr[left]) {
                ans++;
                if (arr[ans] > arr[right]) {
                    right = ans;
                }
            } else {
                int t = arr[right];
                arr[right] = arr[left];
                arr[left] = t;
                break;
            }

        }
        return arr;
    }

//        int min=arr[ans];
//        for (int i=ans;i<n;i++){
//            if(arr[i]>min){
//
//            }
//        }
    public static int[] prevPermOpt1(int[] arr) {
        int n=arr.length,min=arr[n-1];
        for(int i=n-2;i>=0;i--){
            if(min<arr[i]){
                int p=-1;
                for(int j=n-1;j>i;j--){
                    if(arr[j]>=min&&arr[j]<arr[i]){
                        p=j;
                        min=arr[j];
                    }
                }
                arr[i]+=arr[p];
                arr[p]=arr[i]-arr[p];
                arr[i]-=arr[p];
                break;
            }
            min=Math.min(min,arr[i]);
        }
        return arr;
    }


    /**
     * 贪心算法
     *
     */

    public int[] prevPermOpt5(int[] arr) {
        int n=arr.length;
        for(int i=n-2;i>=0;i++){
            if(arr[i]>arr[i+1]){
                int j=n-1;
                while (arr[j]>=arr[i]||arr[j]==arr[j-1]){
                    j--;
                }
                int temp=arr[j];
                arr[j]=arr[i];
                arr[i]=temp;
                break;
            }
        }
        return arr;
    }
}
