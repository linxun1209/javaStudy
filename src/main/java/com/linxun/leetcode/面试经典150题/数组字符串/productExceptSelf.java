package com.linxun.leetcode.面试经典150题.数组字符串;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.hot
 * 238. 除自身以外数组的乘积
 * @date 2023/3/19 9:21
 *
 * 普通数组第四题
 * 除自身意外数组的乘积
 *
 *
 * 要求
 * 给你一个整数数组 nums，返回 数组 answer ，
 * 其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 *
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 *
 * 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 */
public class productExceptSelf {
    public static void main(String[] args) {
        int[] nums={1,2,3,4};
        productExceptSelf(nums);
    }


    public static int[] productExceptSelf(int[] nums) {
        int left = 1;
        int right = 1;
        int len = nums.length;
        int[] output = new int[len];
        for(int i=0;i<len;i++){
            output[i] = left;
            left *= nums[i];
        }
        for(int j=len-1;j>=0;j--){
            output[j] *= right;
            right *= nums[j];
        }
        return output;
    }


    public static int[] productExceptSelf2(int[] nums) {
        int length = nums.length;
        int[] answer = new int[length];

        // answer[i] 表示索引 i 左侧所有元素的乘积
        // 因为索引为 '0' 的元素左侧没有元素， 所以 answer[0] = 1
        answer[0] = 1;
        for (int i = 1; i < length; i++) {
            answer[i] = nums[i - 1] * answer[i - 1];
        }

        // R 为右侧所有元素的乘积
        // 刚开始右边没有元素，所以 R = 1
        int R = 1;
        for (int i = length - 1; i >= 0; i--) {
            // 对于索引 i，左边的乘积为 answer[i]，右边的乘积为 R
            answer[i] = answer[i] * R;
            // R 需要包含右边所有的乘积，所以计算下一个结果时需要将当前值乘到 R 上
            R *= nums[i];
        }
        return answer;
    }



    public static int[] productExceptSelfTest(int[] nums) {
//        int left=1;
//        int right=1;
//        int len=nums.length;
//        int[] res=new int[len];
//        for (int i=0;i<len;i++){
//            res[i]=left;
//            left*=nums[i];
//        }
//        for (int i=len-1;i>=0;i--){
//            res[i]*=right;
//            right*=nums[i];
//        }
//        return res;
        int len=nums.length;
        int[] res=new int[len];
        res[0]=1;
        for (int i=0;i<len;i++){
            res[i]=res[i-1]*nums[i-1];
        }
        int r=1;
        for (int i=len-1;i>=0;i--){
            res[i]=res[i]*r;
            r*=nums[i];
        }
        return res;
    }


    public int[] productExceptSelf4(int[] nums) {
        int length = nums.length;

        // L 和 R 分别表示左右两侧的乘积列表
        int[] L = new int[length];
        int[] R = new int[length];

        int[] answer = new int[length];

        // L[i] 为索引 i 左侧所有元素的乘积
        // 对于索引为 '0' 的元素，因为左侧没有元素，所以 L[0] = 1
        L[0] = 1;
        for (int i = 1; i < length; i++) {
            L[i] = nums[i - 1] * L[i - 1];
        }

        // R[i] 为索引 i 右侧所有元素的乘积
        // 对于索引为 'length-1' 的元素，因为右侧没有元素，所以 R[length-1] = 1
        R[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--) {
            R[i] = nums[i + 1] * R[i + 1];
        }

        // 对于索引 i，除 nums[i] 之外其余各元素的乘积就是左侧所有元素的乘积乘以右侧所有元素的乘积
        for (int i = 0; i < length; i++) {
            answer[i] = L[i] * R[i];
        }

        return answer;
    }
}



