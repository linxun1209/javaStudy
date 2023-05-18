package com.linxun.leetcode.代码随想录.单调栈;

import java.util.Stack;

/**
 * @author xingchen
 * @version V1.0
 * @Package com.linxun.leetcode.代码随想录.单调栈
 * @date 2023/5/18 17:59
 */
public class trap {
    public static void main(String[] args) {
        int[] height={0,1,0,2,1,0,1,3,2,1,2,1};
        trap(height);
    }

    public static int trap(int[] height) {
        int i=0,ans=0;
        Stack<Integer> Stack=new Stack<>();
        while(i<height.length){
            while(!Stack.isEmpty()&&height[i]>height[Stack.peek()]){
                int top=Stack.pop();
                if(Stack.isEmpty()){
                    break;

                }
                int distance=i-Stack.peek()-1;
                int bought_height=Math.min(height[i],height[Stack.peek()])-
                        height[top];
                ans+=distance*bought_height;

            }
            Stack.push(i++);
        }
        return ans;

    }


    /**
     * 暴力
     * @param height
     * @return
     */
    public int trap2(int[] height) {
        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            // 第一个柱子和最后一个柱子不接雨水
            if (i==0 || i== height.length - 1) {
                continue;
            }

            int rHeight = height[i];
            // 记录右边柱子的最高高度
            int lHeight = height[i];
            // 记录左边柱子的最高高度
            for (int r = i+1; r < height.length; r++) {
                if (height[r] > rHeight) {
                    rHeight = height[r];
                }
            }
            for (int l = i-1; l >= 0; l--) {
                if(height[l] > lHeight) {
                    lHeight = height[l];
                }
            }
            int h = Math.min(lHeight, rHeight) - height[i];
            if (h > 0) {
                sum += h;
            }
        }
        return sum;

    }


    /**
     * 双指针
     * @param height
     * @return
     */
    public int trap3(int[] height) {
        int length = height.length;
        if (length <= 2) {
            return 0;
        }
        int[] maxLeft = new int[length];
        int[] maxRight = new int[length];

        // 记录每个柱子左边柱子最大高度
        maxLeft[0] = height[0];
        for (int i = 1; i< length; i++) {
            maxLeft[i] = Math.max(height[i], maxLeft[i-1]);
        }

        // 记录每个柱子右边柱子最大高度
        maxRight[length - 1] = height[length - 1];
        for(int i = length - 2; i >= 0; i--) {
            maxRight[i] = Math.max(height[i], maxRight[i+1]);
        }

        // 求和
        int sum = 0;
        for (int i = 0; i < length; i++) {
            int count = Math.min(maxLeft[i], maxRight[i]) - height[i];
            if (count > 0) {
                sum += count;
            }
        }
        return sum;
    }


    /**
     * 单调栈
     *
     * @param height
     * @return
     */
    public int trap4(int[] height){
        int size = height.length;

        if (size <= 2) {
            return 0;
        }

        // in the stack, we push the index of array
        // using height[] to access the real height
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);

        int sum = 0;
        for (int index = 1; index < size; index++){
            int stackTop = stack.peek();
            if (height[index] < height[stackTop]){
                stack.push(index);
            }else if (height[index] == height[stackTop]){
                // 因为相等的相邻墙，左边一个是不可能存放雨水的，所以pop左边的index, push当前的index
                stack.pop();
                stack.push(index);
            }else{
                //pop up all lower value
                int heightAtIdx = height[index];
                while (!stack.isEmpty() && (heightAtIdx > height[stackTop])){
                    int mid = stack.pop();

                    if (!stack.isEmpty()){
                        int left = stack.peek();

                        int h = Math.min(height[left], height[index]) - height[mid];
                        int w = index - left - 1;
                        int hold = h * w;
                        if (hold > 0) {
                            sum += hold;
                        }
                        stackTop = stack.peek();
                    }
                }
                stack.push(index);
            }
        }

        return sum;
    }


}
