package com.linxun.leetcode.面试经典150题.堆;

import java.util.Arrays;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 215. 数组中的第K个最大元素
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 *
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 * @date 2024/8/14 20:34
 */
public class findKthLargest {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public int findKthLargest4(int[] nums, int k) {
        int[] arr=new int[k];
        for (int i=0;i<k;i++){
            arr[i]=nums[i];
        }
        bulidHeap1(arr,k-1);
        for (int i=k;i<nums.length;i++){
            if(nums[i]<arr[0]){
                arr[0]=nums[i];
                heapify1(arr, k - 1, 0);
            }

        }
        return arr[0];
    }

    private void bulidHeap1(int[] arr, int n) {
        for (int i=n/2;i>=0;i--){
            heapify1(arr,n,i);
        }
    }

    private void heapify1(int[] arr, int n, int i) {
        while(true){
            int minPos=i,left=i*2+1,right=left+1;
            if(left<=n&&arr[minPos]>arr[left]) minPos=left;
            if(right<=n&&arr[minPos]>arr[right]) minPos=right;
            if(minPos==i) break;
            swap1(arr,i,minPos);
            i=minPos;
        }
    }

    private void swap1(int[] arr, int i, int minPos) {
        int temp=arr[i];
        arr[i]=arr[minPos];
        arr[minPos]=temp;
    }


    public int findKthLargest2(int[] nums, int k) {
        int[] arr = new int[k];
        for (int i = 0; i < k; i++) {
            arr[i] = nums[i];
        }
        //维护一个小k的顶堆
        buildHeap(arr, k - 1);
        for (int i = k; i < nums.length; i++) {
            //在其中找k个最大值，如果当前值比堆顶大，则替换堆顶，然后重新调整堆
            //接下来，我们从第k个元素开始遍历nums数组。对于每个遍历到的元素，如果它大于arr数组的根节点arr[0]，
            // 则将该元素替换为根节点，并进行heapify操作，维护小顶堆的性质。
            //最后，我们返回arr数组的根节点arr[0]作为第k大的元素。
            if (nums[i] > arr[0]) {
                arr[0] = nums[i];
                heapify(arr, k - 1, 0);
            }
        }
        return arr[0];
    }
    private void buildHeap(int[] nums, int n) {
        for (int i = n / 2; i >= 0; i--) {
            heapify(nums, n, i);
        }
    }
    private void heapify(int[] nums, int n, int i) {
        while (true) {
            int minPos = i, left = 2 * i + 1, right = left + 1;
            if (left <= n && nums[minPos] > nums[left]) minPos = left;
            if (right <= n && nums[minPos] > nums[right]) minPos = right;
            if (minPos == i) break;
            swap(nums, i, minPos);
            i = minPos;
        }
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {
        findKthLargest3(new int[]{3,2,1,5,6,4},2);
    }

    public static int findKthLargest3(int[] nums, int k) {
        //找到最大值和最小值
        int max = nums[0], min = nums[0];
        for (int num : nums) {
            if (max < num) max = num;
            if (min > num) min = num;
        }
        //根据最大值和最小值确定计数范围
        int[] count = new int[max - min + 1];
        for (int num : nums) {
            count[num - min]++;
        }
        //寻找第k大的数字
        for (int i = max - min; i >= 0; i--) {
            k -= count[i];
            if (k <= 0) return i + min;
        }
        return nums[0];
    }
}

