package com.linxun.leetcode.面试经典150题.数组字符串;

import java.util.Stack;

/**
 * @author xing'chen
 * @version 1.0
 * @description: 42. 接雨水
 * @date 2024/3/6 19:02
 */
public class trap {
    public int trap(int[] height) {
        int len=height.length;
        int ans=0;
        if(len<3){
            return 0;
        }
        int left_max[]=new int[len];
        int right_max[]=new int[len];
        left_max[0]=height[0];
        right_max[len-1]=height[len-1];
        for(int i=1;i<len;i++){
            left_max[i]=Math.max(left_max[i-1],height[i]);
        }
        for(int i=len-2;i>=0;i--){
            right_max[i]=Math.max(right_max[i+1],height[i]);
        }
        for(int i=0;i<len;i++){
            ans+=Math.min(left_max[i],right_max[i])-height[i];
        }
        return ans;

    }


    public int trap2(int[] height) {
        int i=0,ans=0;
        Stack<Integer> Stack=new Stack<>();
        while(i<height.length){
            while(!Stack.isEmpty()&&height[i]>height[Stack.peek()]){
                int top=Stack.pop();
                if(Stack.isEmpty()){
                    break;
                }
                int distance=i-Stack.peek()-1;
                int bought_height=Math.min(height[i],height[Stack.peek()])- height[top];
                ans+=distance*bought_height;

            }
            Stack.push(i++);
        }
        return ans;

    }


    public int trap3(int[] height) {
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


    /**
     * 超时
     *
     * @param height
     * @return
     */
    public int trap5(int[] height) {
        int sum = 0;
        int max = getMax(height);//找到最大的高度，以便遍历。
        for (int i = 1; i <= max; i++) {
            boolean isStart = false; //标记是否开始更新 temp
            int temp_sum = 0;
            for (int j = 0; j < height.length; j++) {
                if (isStart && height[j] < i) {
                    temp_sum++;
                }
                if (height[j] >= i) {
                    sum = sum + temp_sum;
                    temp_sum = 0;
                    isStart = true;
                }
            }
        }
        return sum;
    }
    private int getMax(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > max) {
                max = height[i];
            }
        }
        return max;
    }



    public int trap6(int[] height) {
        int sum = 0;
        //最两端的列不用考虑，因为一定不会有水。所以下标从 1 到 length - 2
        for (int i = 1; i < height.length - 1; i++) {
            int max_left = 0;
            //找出左边最高
            for (int j = i - 1; j >= 0; j--) {
                if (height[j] > max_left) {
                    max_left = height[j];
                }
            }
            int max_right = 0;
            //找出右边最高
            for (int j = i + 1; j < height.length; j++) {
                if (height[j] > max_right) {
                    max_right = height[j];
                }
            }
            //找出两端较小的
            int min = Math.min(max_left, max_right);
            //只有较小的一段大于当前列的高度才会有水，其他情况不会有水
            if (min > height[i]) {
                sum = sum + (min - height[i]);
            }
        }
        return sum;
    }
}

