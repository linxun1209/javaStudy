package com.linxun.leetcode.算法复习.快速排序;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 快排模板
 * @date 2024/7/19 14:29
 */
public class quick_sort_Template {
    /**
     * void quick_sort(int q[], int l, int r){
     *         if (l >= r) return;
     *
     *         int i = l - 1, j = r + 1, x = q[l + r >> 1];
     *         while (i < j)
     *         {
     *             do i ++ ; while (q[i] < x);
     *             do j -- ; while (q[j] > x);
     *             if (i < j) swap(q[i], q[j]);
     *         }
     *         quick_sort(q, l, j), quick_sort(q, j + 1, r);
     * }
     *
     *
     *
     *
     * @param q
     * @param l
     * @param r
     */
    public static void quickSort(int [] q ,int l ,int r){
        if(l >= r){
            return;
        }
        int i = l - 1;
        int j = r + 1;
        int x = q[l + r >> 1];
        while(i < j){
            do i++; while(q[i] <x);
            do j--; while(q[j] > x);
            if(i < j){
                int temp = q[i];
                q[i] = q[j];
                q[j] = temp;
            }
        }
        quickSort(q,l,j);
        quickSort(q,j+1,r);
    }


    private static int[] quickSort1(int[] arr, int left, int right) {
        // 递归终止条件，如果左边界大于等于右边界则认为递归结束
        if (left >= right) {
            return arr;
        }
        // 设定一个分界值，这里是（left + right）/ 2
        int p = arr[left + right >> 1];
        // 左右提前预留一个位置
        int i = left - 1;
        int j = right + 1;
        while (i < j) {
            // 等效于do while
            // 当数值小于分界值时持续遍历，直到找到第一个大于等于分界值的索引
            // 如果是逆序则调整两个while循环
            while (arr[++i] < p) ;
            while (arr[--j] > p) ;
            // 交换左右两侧不符合预期的数值
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // 由于分界值取的是left + right >> 1，因此递归取的是left，j j + 1，right
        quickSort1(arr, left, j);
        quickSort1(arr, j + 1, right);
        return arr;
    }





}

